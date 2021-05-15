package com.postserver.post.post;

public class Post{
    private String title;
    private String sender;
    private String body;
    public Post(String s, String t, String b){
        this.sender = s;
        this.body = b;
        this.title = t;
    }
    public String getBody(){
        return body;
    }
    public String getTitle(){
        return title;
    }
    public String getSender(){
        return sender;
    }
    public void setBody(String body){
        this.body = body;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setSender(String sender){
        this.sender = sender;
    }
    @Override
    public String toString(){
        return "Title: " + this.title + "\nBody: " + this.body + "\nSent by:" + this.sender + "\n";
    }
}