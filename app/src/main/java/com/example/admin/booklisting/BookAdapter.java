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

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Activity context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Book currentBook = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.book_title);
        title.setText(currentBook.getTitle());

        TextView author = (TextView) listItemView.findViewById(R.id.book_author);
        author.setText(currentBook.getAuthor());

        ImageView myImageView = (ImageView) listItemView.findViewById(R.id.book_cover);

        Glide
                .with(getContext())
                .load(currentBook.getThumbnail())
                .centerCrop()
                .placeholder(android.R.drawable.alert_light_frame)
                .crossFade()
                .into(myImageView);

        return listItemView;
    }
}
