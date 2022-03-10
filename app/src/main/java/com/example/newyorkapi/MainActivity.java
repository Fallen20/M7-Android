package com.example.newyorkapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.newyorkapi.JsonObjectTopStories.JsonResultTop;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView logo;

    private EditText search;
    private ImageView searchIcon;

    private RadioGroup radioGroup;
    private RelativeLayout relativeMovies;
    private RelativeLayout relativeTop;
    private Spinner spinner;

    private TextView statusTxt;
    private TextView numResultsTxt;
    private RecyclerView recyclerView;


    private String radioSeleccion="";
    private String token="rXxP22LbAGvaajWojAGTKtmaUTpBIOFc";

    private List<ResultJson> resultMovies =new ArrayList<>();
    private List<JsonResultTop> resultTop=new ArrayList<>();
    private AdapterMovies adapterMovies;
    private AdapterTop adapterTop;
    private List<String> arraySpinner=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo=findViewById(R.id.logotipoImg);
        search=findViewById(R.id.searchEdit);
        searchIcon=findViewById(R.id.searchIcon);
        statusTxt =findViewById(R.id.status);
        numResultsTxt =findViewById(R.id.result);
        recyclerView=findViewById(R.id.recyclerResultado);
        radioGroup=findViewById(R.id.radioGroup);
        relativeMovies=findViewById(R.id.relative1_Movies);
        relativeTop=findViewById(R.id.relative1_Stories);
        spinner=findViewById(R.id.spinner);

        //cargar imagen
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/The_New_York_Times_Logo.svg/2560px-The_New_York_Times_Logo.svg.png").
                fit().centerInside().into(logo);

        //poner los datos de status y eso como null hasta que busquemos
        statusTxt.setText("");
        numResultsTxt.setText("");

        relativeMovies.setVisibility(View.GONE);
        relativeTop.setVisibility(View.GONE);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int seleccionado=radioGroup.getCheckedRadioButtonId();//esto devuelve el id del boton seleccionad
                RadioButton seleccionTexto= findViewById(seleccionado);

                switch (seleccionado){
                    case R.id.moviesRadio:
                        radioSeleccion="https://api.nytimes.com/svc/movies/v2/reviews/search.json?query=";
                        relativeMovies.setVisibility(View.VISIBLE);
                        relativeTop.setVisibility(View.GONE);

                        //reset recycler
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapterMovies = new AdapterMovies(MainActivity.this, new ArrayList<ResultJson>());
                        recyclerView.setAdapter(adapterMovies);

                        //reset recycler
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapterTop = new AdapterTop(MainActivity.this, new ArrayList<JsonResultTop>());
                        recyclerView.setAdapter(adapterTop);
                        break;

                    case R.id.topRadio:


                        radioSeleccion="https://api.nytimes.com/svc/topstories/v2/";

                        relativeTop.setVisibility(View.VISIBLE);
                        relativeMovies.setVisibility(View.GONE);

                        //reset recycler
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapterMovies = new AdapterMovies(MainActivity.this, new ArrayList<ResultJson>());
                        recyclerView.setAdapter(adapterMovies);

                        //reset recycler
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapterTop = new AdapterTop(MainActivity.this, new ArrayList<JsonResultTop>());
                        recyclerView.setAdapter(adapterTop);
                        break;
                }
            }
        });


        //spinner
        addDataSpinner();

        ArrayAdapter<String> adapterArrayList=new ArrayAdapter<>(
                this,//a que afecta
                R.layout.support_simple_spinner_dropdown_item,
                arraySpinner//esto busca la array. Como es una propia arraylist y no string-array (que son strings), lo añadimos directamente
        );

        spinner.setAdapter(adapterArrayList);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccionado = adapterView.getItemAtPosition(i).toString();

                if(!seleccionado.equals("Select an option")){
                    recuperarJSON_Top(radioSeleccion,seleccionado);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "No hay nada seleccionado", Toast.LENGTH_SHORT).show();
            }
        });


        //search
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!search.getText().toString().trim().isEmpty()) {
                    recuperarJSON_Movies(radioSeleccion,search.getText().toString().trim());
                }
                else{Toast.makeText(getApplicationContext(), "El campo de búsqueda no puede estar vacío", Toast.LENGTH_SHORT).show();}
            }


        });




    }

    private void addDataSpinner() {

        arraySpinner.add(0,"Select an option");
        arraySpinner.add(1,"arts");
        arraySpinner.add(2,"automobiles");
        arraySpinner.add(3,"books");
        arraySpinner.add(4,"business");
        arraySpinner.add(5,"fashion");
        arraySpinner.add(6,"health");
        arraySpinner.add(7,"home");
        arraySpinner.add(8,"insider");
        arraySpinner.add(9,"magazine");
        arraySpinner.add(10,"movies");
        arraySpinner.add(11,"nyregion");
        arraySpinner.add(12,"obituaries");
        arraySpinner.add(13,"politics");
        arraySpinner.add(14,"realestate");
        arraySpinner.add(15,"sundayreview");
        arraySpinner.add(16,"technology");
        arraySpinner.add(17,"theater");
        arraySpinner.add(18,"t-magazine");
        arraySpinner.add(19,"travel");
        arraySpinner.add(20,"upshot");
        arraySpinner.add(21,"us");
    }

    private void recuperarJSON_Top(String direccion, String seleccionado) {

        RequestQueue queue = Volley.newRequestQueue(this);


        String direccionNueva=direccion+seleccionado+".json?api-key="+token;
        //Toast.makeText(getApplicationContext(), direccionNueva, Toast.LENGTH_SHORT).show();

        JsonObjectRequest reques=new JsonObjectRequest(
                Request.Method.GET,
                direccionNueva,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        String status = response.optString("status");//optString es que puede estar o no?
                        String num_results = response.optString("num_results");

                        if(status.equals("OK")){

                            JSONArray jsonArray = response.optJSONArray("results");

                            if(jsonArray!=null){//si encuentra resultados
                                resultTop = Arrays.asList(new GsonBuilder().create().fromJson(jsonArray.toString(), JsonResultTop[].class));
                                //el getString con el for pero con la clase GSON

                                statusTxt.setTextColor(getResources().getColor(R.color.verde));
                                statusTxt.setText(status);
                                numResultsTxt.setText(num_results);


                                ///recycler
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                adapterTop = new AdapterTop(MainActivity.this, resultTop);
                                recyclerView.setAdapter(adapterTop);
                            }
                            else{//sino hay resultados
                                //muestra el recycler vacio
                                statusTxt.setTextColor(getResources().getColor(R.color.rojo));
                                statusTxt.setText(R.string.bad);
                                numResultsTxt.setText("0");

                                ///recycler
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                adapterTop = new AdapterTop(MainActivity.this, new ArrayList<JsonResultTop>());
                                recyclerView.setAdapter(adapterTop);
                            }


                        }
                        else{//si el resultado no es ok
                            statusTxt.setTextColor(getResources().getColor(R.color.rojo));
                            statusTxt.setText(R.string.bad);
                            numResultsTxt.setText("0");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), "Error leyendo datos", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        queue.add(reques);
    }

    private void recuperarJSON_Movies(String direccion, String busqueda) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String direccionNueva=direccion+busqueda+"&api-key="+token;
        Toast.makeText(getApplicationContext(), direccionNueva, Toast.LENGTH_SHORT).show();


        JsonObjectRequest reques=new JsonObjectRequest(
                Request.Method.GET,
                direccionNueva,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        String status = response.optString("status");//optString es que puede estar o no?
                        String num_results = response.optString("num_results");

                        if(status.equals("OK")){
                            //si has podido recuperar el json
                            //si solo pones el ok y no hay resultados, peta
                            //por eso has de poner la comprobacion de numResults>0 o jsonArray!=null por si
                            //no ha habido problemas para recuperar el json pero no hay resultados

                            JSONArray jsonArray = response.optJSONArray("results");
                            //recupera datos bien y los guarda bien

                            if(jsonArray!=null){//si encuentra resultados
                                resultMovies = Arrays.asList(new GsonBuilder().create().fromJson(jsonArray.toString(), ResultJson[].class));
                                //el getString con el for pero con la clase GSON

                                statusTxt.setTextColor(getResources().getColor(R.color.verde));
                                statusTxt.setText(status);
                                numResultsTxt.setText(num_results);


                                ///recycler
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                adapterMovies = new AdapterMovies(MainActivity.this, resultMovies);
                                recyclerView.setAdapter(adapterMovies);
                            }
                            else{//sino hay resultados
                        //muestra el recycler vacio
                                statusTxt.setTextColor(getResources().getColor(R.color.rojo));
                                statusTxt.setText(R.string.bad);
                                numResultsTxt.setText("0");

                                ///recycler
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                adapterMovies = new AdapterMovies(MainActivity.this, new ArrayList<>());
                                recyclerView.setAdapter(adapterMovies);
                            }


                        }
                        else{//si el resultado no es ok
                            statusTxt.setTextColor(getResources().getColor(R.color.rojo));
                            statusTxt.setText(R.string.bad);
                            numResultsTxt.setText("0");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), "Error leyendo datos", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        queue.add(reques);
    }
}