package dam.pucp.edu.pe.catalogodepeliculas.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import dam.pucp.edu.pe.catalogodepeliculas.R;
import dam.pucp.edu.pe.catalogodepeliculas.beans.Pelicula;

import org.json.JSONException;
import org.json.JSONObject;

public class MovieInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        //final ImageView imageView = (ImageView) findViewById(R.id.imageView);
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
        String url = "http://www.omdbapi.com/?t=["+"nemo"+"]&plot=short&r=json";
        final Pelicula pelicula = new Pelicula();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            pelicula.setTitle(response.getString("Title"));
                            pelicula.setYear(response.getString("Year"));
                            pelicula.setProductionDate(response.getString("Released"));
                            pelicula.setDuration(response.getString("Runtime"));
                            pelicula.setGenre(response.getString("Genre"));
                            pelicula.setDirector(response.getString("Director"));
                            pelicula.setWriter(response.getString("Writer"));
                            pelicula.setActors(response.getString("Actors"));
                            pelicula.setSummary(response.getString("Plot"));
                            pelicula.setAwards(response.getString("Awards"));
                            pelicula.setRating(Double.parseDouble(response.getString("imdbRating")));

                        } catch (JSONException ex) {
                            ex.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("volley", "Ocurrio un error!");
                    }
                 }
        );

        cola.add(jsonObjectRequest);

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
