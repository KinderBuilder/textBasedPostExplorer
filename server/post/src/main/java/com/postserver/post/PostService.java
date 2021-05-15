package com.postserver.post.post;
import java.util.ArrayList;

public class PostService{
    private ArrayList <Post> database;
    public PostService(){
        this.database = new ArrayList<Post>();
        this.database.add(new Post("Music", "I like Anime... what you thought I was going to talk about music? Uhhh Music. There I talked about music", "-DOGE"));
        this.database.add(new Post("Anime", "Anime", "-Anime"));
    }

}