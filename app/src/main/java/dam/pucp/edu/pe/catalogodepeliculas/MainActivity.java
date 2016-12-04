package dam.pucp.edu.pe.catalogodepeliculas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dam.pucp.edu.pe.catalogodepeliculas.views.ViewBestMovies;
import dam.pucp.edu.pe.catalogodepeliculas.views.ViewInfMovie;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button viewMoviesInfo = (Button) findViewById(R.id.infoMovieButton);
        final Button viewBestMovies = (Button) findViewById(R.id.bestMovieButton);

        viewMoviesInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewInfMovie.class);
                startActivity(intent);
            }
        });

        viewMoviesInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewBestMovies.class);
                startActivity(intent);
            }
        });
    }
}
