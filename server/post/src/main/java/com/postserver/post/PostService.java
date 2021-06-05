package com.postserver.post;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
//create get post
public class PostService{
    private List <Post> database;
    
    public PostService(){
        this.database = new ArrayList<Post>();
        this.database.add(new Post("Music", "I like Anime... what you thought I was going to talk about music? Uhhh Music. There I talked about music", "-DOGE"));
        this.database.add(new Post("Anime", "Anime", "-Anime"));
    }
    public List <Post> getPosts(){
        return this.database;
    }
}