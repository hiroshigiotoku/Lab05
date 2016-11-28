package dam.pucp.edu.pe.catalogodepeliculas.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import dam.pucp.edu.pe.catalogodepeliculas.R;
import dam.pucp.edu.pe.catalogodepeliculas.adapters.ImageAdapter;

public class ViewInfMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_inf_movie);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewInfMovie.this, MovieInfo.class);
                startActivity(intent);
            }
        });
    }
}
