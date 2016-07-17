package com.marcgregor.flickster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.marcgregor.flickster.R;
import com.marcgregor.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by Marc Gregor on 7/16/2016.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        //get the data item for position
        Movie movie = getItem(position);

        // check the existing view being reused
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        //find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);

        // Clear out image from convert view
        ivImage.setImageResource(0);


        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView txOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        // populate data
        tvTitle.setText(movie.getOriginalTitle());
        txOverview.setText(movie.getOverview());

        //Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        // return the view

        Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(10, 10)).centerCrop().resize(200, 300).into(ivImage);

        return convertView;
    }
}
