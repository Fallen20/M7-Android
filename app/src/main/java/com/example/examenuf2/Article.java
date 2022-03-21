package com.example.examenuf2;

import java.util.List;

public class Article {
    public String authorlink;
    public String authorname;
    public String contact;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;
    public String content;
    public MediaJSON media;
    public String urlvideo;
    public List<String> comments;


    public Article() {
    }

    public String getAuthorlink() {
        return authorlink;
    }

    public void setAuthorlink(String authorlink) {
        this.authorlink = authorlink;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
