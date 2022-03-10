package com.example.accesoappmobil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private StorageReference storageReference;
    private RecyclerView recyclerView;

    private Toolbar toolbar;

    private MyAdapter myAdapter;
    private List<String> images=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView=findViewById(R.id.recyclerList);
        toolbar=findViewById(R.id.toolbarList);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView.setLayoutManager(new GridLayoutManager(this,3, RecyclerView.VERTICAL,false));

        storageReference= FirebaseStorage.getInstance().getReference().child("image");

        storageReference.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for(StorageReference archivo:listResult.getItems()){

                    //sacas las imagenes
                    archivo.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            images.add(uri.toString());
                        }
                    })
                    .addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            myAdapter = new MyAdapter(ListActivity.this, images);
                            recyclerView.setAdapter(myAdapter);
                        }
                    });


                }
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

                Intent intent=new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                return true;

            case R.id.gridMenu:
                Toast.makeText(getApplicationContext(), "Already in the activity", Toast.LENGTH_SHORT).show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}