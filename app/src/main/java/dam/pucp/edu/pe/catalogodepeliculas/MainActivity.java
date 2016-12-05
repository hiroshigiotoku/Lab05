package dam.pucp.edu.pe.catalogodepeliculas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import dam.pucp.edu.pe.catalogodepeliculas.views.ViewBestMovies;
import dam.pucp.edu.pe.catalogodepeliculas.views.ViewInfMovie;

public class MainActivity extends Activity {
    final int ID_LOGIN = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button viewMoviesInfo = (Button) findViewById(R.id.infoMovieButton);
        final Button viewBestMovies = (Button) findViewById(R.id.bestMovieButton);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() != null){
            //El usuario ya está logueado
            Toast.makeText(this, "Hola "+ auth.getCurrentUser().getDisplayName(),
                    Toast.LENGTH_LONG).show();
        } else {
            //El usuario no está logueado
            startActivityForResult(
                    AuthUI.getInstance().createSignInIntentBuilder()
                            .setProviders(AuthUI.GOOGLE_PROVIDER).build(),1);
        }

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

    protected void onActivityResult(int code, int resultado, Intent data) {
        super.onActivityResult(code,resultado,data);
        if (code == ID_LOGIN) {
            if (resultado == RESULT_OK) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        }


    }
}
