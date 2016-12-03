package com.example.admin.booklisting;

import java.util.ArrayList;

public class Book extends ArrayList<Book> {
    private String mTitle;
    private String mAuthor;
    private String mThumbnail;
    private String mInfoLink;

    public Book(String title, String author, String thumbnail, String infoLink) {
        mTitle = title;
        mAuthor = author;
        mThumbnail = thumbnail;
        mInfoLink = infoLink;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public String getInfoLink() {
        return mInfoLink;
    }
}
