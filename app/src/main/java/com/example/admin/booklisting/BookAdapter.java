package com.example.admin.booklisting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class ViewHolder {
    TextView title;
    TextView author;
    ImageView myImageView;
}

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Activity context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            // inflate the layout
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            // set up the ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.book_title);
            viewHolder.author = (TextView) convertView.findViewById(R.id.book_author);
            viewHolder.myImageView = (ImageView) convertView.findViewById(R.id.book_cover);

            // store the holder with the view.
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // object item based on the position
        Book currentBook = getItem(position);

        // assign values if the object is not null
        if (currentBook != null) {
            // get the views from the ViewHolder and then set the values
            viewHolder.title.setText(currentBook.getTitle());
            viewHolder.author.setText(currentBook.getAuthor());
            Glide
                    .with(getContext())
                    .load(currentBook.getThumbnail())
                    .centerCrop()
                    .placeholder(android.R.drawable.alert_light_frame)
                    .crossFade()
                    .into(viewHolder.myImageView);
        }

        return convertView;
    }
}