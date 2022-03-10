package com.example.accesoappmobil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button camera;
    private Button gallery;
    private Button googleFotos;
    private Button upload;
    private ImageView imagenLayout;
    private Toolbar toolbar;


    public static final int CAMERA_PERM_CODE = 101;//puede ser cualquier numero, pero todos diferentes
    public static final int CAMERA_REQUEST = 102;
    public static final int GALLERY_REQUEST_CODE = 103;

    StorageReference storageReference;

    String rutaFotoActual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera=findViewById(R.id.camButton);
        gallery=findViewById(R.id.galriaButton);
        upload=findViewById(R.id.uploadButton);
        googleFotos=findViewById(R.id.googleGalleryButton);
        imagenLayout =findViewById(R.id.imagenMain);


        toolbar=findViewById(R.id.toolbarMain);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        upload.setVisibility(View.INVISIBLE);
        storageReference = FirebaseStorage.getInstance().getReference();

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 askCameraPermission();
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Choose an image" ), GALLERY_REQUEST_CODE);
            }
        });

        googleFotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALLERY_REQUEST_CODE);
            }

        });
    }



    //PERMISOS
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //podemos pedir +1 permiso, por eso []. Pero en este caso solo es uno (camara)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_PERM_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //si ha devuelto algo y nos ha dado el permiso
                //openCamera();//esto no guarda
                takePictureIntent();
            } else {
                Toast.makeText(this, "No access given to open the camera", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CAMERA_REQUEST){//si lo has hecho desde la camara...
            /*
            Bitmap imagenBit= (Bitmap) data.getExtras().get("data");
            imagen.setImageBitmap(imagenBit);//esto solo te da una 'captura' de la imagen, sin tamaño real no nada
            * */

            if(resultCode== Activity.RESULT_OK){
                File file=new File(rutaFotoActual);
                imagenLayout.setImageURI(Uri.fromFile(file));//ahora carga de un archivo
                Log.d("TAG", "AbsoluteURL: " +  Uri.fromFile(file));

                Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri contentUri = Uri.fromFile(file);
                mediaScanIntent.setData(contentUri);
                this.sendBroadcast(mediaScanIntent);

                upload.setVisibility(View.VISIBLE);
                upload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uploadImageToFirebase(file.getName(),Uri.fromFile(file));
                    }
                });

            }

        }
        if(requestCode==GALLERY_REQUEST_CODE && resultCode==RESULT_OK && data!=null){
           /* Uri contentUri = data.getData();
            imagenLayout.setImageURI(contentUri);//lo muestra, pero peque
            Log.d("onActivityResult: ", contentUri + "");*/

            Uri contentUri = data.getData();
            String tiempo=new SimpleDateFormat("yyyyHHdd_HHmmss").format(new Date());

            ContentResolver contentResolver=getContentResolver();
            MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
            String ext= mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(contentUri));

            String nombreImagen="JPEG_"+tiempo+"."+ext;
            Log.d("onActivityResult: ", nombreImagen + "");
            imagenLayout.setImageURI(contentUri);


            upload.setVisibility(View.VISIBLE);
            upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uploadImageToFirebase(nombreImagen,contentUri);
                }
            });

        }
    }

    private void askCameraPermission() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            //es mayor, se ha de pedir permiso

            //miramos si el manifest tiene el permiso para acceder
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                //no tenemos permiso, lo pedimos

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
                //requestPermissin es el metodo de arriba
                //contexto, el permiso que queremos, la constante
            }
            else{//tenemos permiso, abrimos la camara
                takePictureIntent();
            }
        }
        else{
            //es menor, se abre directamente
            takePictureIntent();
        }
    }

    private void openCamera() {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
    }


    private File createImageFile() throws IOException {
        String tiempo=new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
        String nombreFile="JPEG_"+tiempo+"_";

        File guardadoEn=getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        /*
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);//guardado en pictures
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_DCIM);//guardado en dcim
        * */
        File imagen=File.createTempFile(
                nombreFile,
                ".jpg",
                guardadoEn
        );

        rutaFotoActual=imagen.getAbsolutePath();

        return imagen;
    }

    private void takePictureIntent(){
        Intent pictureIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(pictureIntent.resolveActivity(getPackageManager())!=null){
            //ha podido hacer la foto
            File foto=null;

            try {
                foto=createImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //si ha podido guardar las cosas
            if(foto!=null){
                Uri uriFoto= FileProvider.getUriForFile(this,
                        "com.example.accesoappmobil.fileprovider",
                        foto);
                pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,uriFoto);
                startActivityForResult(pictureIntent, CAMERA_REQUEST);
            }
        }

    }


    //------------------
    //FIREBASE
    private void uploadImageToFirebase(String imageFileName, Uri contentUri) {
        final StorageReference image = storageReference.child("image/" + imageFileName);

        //System.out.println("aaaaaaaaaaaaaaaaaaa");
        image.putFile(contentUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                image.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Toast.makeText(MainActivity.this, "Uploaded image", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error uploading image", Toast.LENGTH_SHORT).show();
            }
        });
    }



    //----------------------------
    //TOOLBAR Y ESO
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//esto es para que salga
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);//primero el xml, luego el menu que  nos da el metodo

        return true;//true es que se ha creado
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //para cuando le apretas al icono
        switch(item.getItemId()){

            case R.id.photoMenu://los id de los item del menu
                Toast.makeText(getApplicationContext(), "Already in the activity", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.gridMenu:
                Intent intent=new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}