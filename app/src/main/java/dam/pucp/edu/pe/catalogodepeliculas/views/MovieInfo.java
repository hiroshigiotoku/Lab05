package dam.pucp.edu.pe.catalogodepeliculas.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import dam.pucp.edu.pe.catalogodepeliculas.R;
import dam.pucp.edu.pe.catalogodepeliculas.beans.Pelicula;

public class MovieInfo extends AppCompatActivity {
    final private String url_base = "http://www.omdbapi.com/?t=";
    private String url_movie;
    final private String url_params = "&plot=short&r=json";

    public MovieInfo(String url_movie) {
        this.url_movie = url_movie;
    }

    public MovieInfo() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        final TextView title = (TextView) findViewById(R.id.textView);
        final TextView year = (TextView) findViewById(R.id.textView2);
        final TextView fecha_realizacion = (TextView) findViewById(R.id.textView3);
        final TextView duracion = (TextView) findViewById(R.id.textView4);
        final TextView genero = (TextView) findViewById(R.id.textView5);
        final TextView director = (TextView) findViewById(R.id.textView6);
        final TextView guionista = (TextView) findViewById(R.id.textView7);
        final TextView actores = (TextView) findViewById(R.id.textView8);
        final TextView resumen = (TextView) findViewById(R.id.textView9);
        final TextView premios = (TextView) findViewById(R.id.textView10);
        final TextView rating = (TextView) findViewById(R.id.textView11);


        RequestQueue cola = Volley.newRequestQueue(getApplicationContext());
        String url = url_base + url_movie + url_params;
        final Pelicula pelicula = new Pelicula();

        StringRequest sr = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("volley", response);
                        try {
                            JSONObject json = new JSONObject(response);
                            String titulo = json.getJSONObject("Title").getString(url_movie);
                            String anho = json.getJSONObject("Year").getString();
                            pelicula.setTitle(titulo);
                            pelicula.setYear(anho);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("volley", "Ocurrió un error!");
            }
        });

        cola.add(sr);

        title.setText(pelicula.getTitle());
        year.setText(pelicula.getYear());
        fecha_realizacion.setText(pelicula.getProductionDate());
        duracion.setText(pelicula.getDuration());
        genero.setText(pelicula.getGenre());
        director.setText(pelicula.getDirector());
        guionista.setText(pelicula.getWriter());
        actores.setText(pelicula.getActors());
        resumen.setText(pelicula.getSummary());
        premios.setText(pelicula.getAwards());
        rating.setText(pelicula.getRating().toString());
    }
}
