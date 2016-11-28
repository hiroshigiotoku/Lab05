package dam.pucp.edu.pe.catalogodepeliculas.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import dam.pucp.edu.pe.catalogodepeliculas.R;

/**
 * Created by Tactical on 10/11/2016.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    private Integer[] mThumbIds = {
            R.drawable.movie_1, R.drawable.movie_2,
            R.drawable.movie_3, R.drawable.movie_4,
            R.drawable.movie_5, R.drawable.movie_6,
            R.drawable.movie_7, R.drawable.movie_8
    };

    public ImageAdapter(Context c) {
        this.mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85,85));
            imageView.setPadding(5,5,5,5);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[i]);
        return imageView;
    }
}