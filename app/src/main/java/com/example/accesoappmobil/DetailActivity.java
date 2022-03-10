package com.example.accesoappmobil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imagen;
    private Button delete;
    private Button download;


    //StorageReference storageReference = FirebaseStorage.getInstance().getReference();

    public static final String DIRECTORY_DOWNLOADS = "storage/emulated/0/Downloads/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String url = intent.getStringExtra("img");


        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();//link al firebase
        StorageReference storagetHTTP = firebaseStorage.getReferenceFromUrl(url);

        imagen = findViewById(R.id.imagenDetail);
        delete = findViewById(R.id.deleteButton);
        download = findViewById(R.id.downloadButton);
        toolbar = findViewById(R.id.toolbarDetail);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Picasso.get().load(url).fit().centerInside().into(imagen);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteImage(storagetHTTP);
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = createFileName();
                downloadFile(DetailActivity.this, nombre, ".jpg", DIRECTORY_DOWNLOADS, url);
            }
        });

    }


    private void deleteImage(StorageReference httpsReference) {
        httpsReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(), "Image deleted", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DetailActivity.this, ListActivity.class);
                startActivity(intent);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error deleting image", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //---------------------------------------
//downlod
    public void downloadFile(Context context, String fileName, String fileExt, String destination, String url) {

        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destination, fileName + fileExt);
        downloadManager.enqueue(request);
    }


    private String createFileName() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp;
        return imageFileName;
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
        switch (item.getItemId()) {
            case R.id.photoMenu://los id de los item del menu
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
                return true;

            case R.id.gridMenu:
                Intent intent2 = new Intent(DetailActivity.this, ListActivity.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}