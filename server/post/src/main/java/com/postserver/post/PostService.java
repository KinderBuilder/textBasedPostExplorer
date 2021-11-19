package com.postserver.post;
import com.postserver.Database;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.stereotype.Service;

@Service
//create get post
public class PostService{
    
    
    public PostService(){
        Database.addPosts(new Post("Music", "I like Anime... what you thought I was going to talk about music? Uhhh Music. There I talked about music", "-DOGE"));
        Database.addPosts(new Post("Anime", "Anime", "-Anime"));
    }
    public ArrayList<Post> getPosts(){return Database.getPosts();}
    public int createPost(Post p){
        /*
            0 is Good
            -1 is Something is empty
            -2 is Duplicate comment
            -3 is 
        */
        
        if(((!p.getSender().equals(""))&&(!p.getBody().equals(""))&&(!p.getTitle().equals("")))){
            //System.out.println("ByPassed empty, now entering contains");
            if(!Database.containsPosts(p)){
                Database.addPosts(new Post(p.getTitle(), p.getBody(),p.getSender()));
                return(0);
            }else{return(-3);}
        }else{return(-2);}

        /*
        OTHER VERSIONS
                if(p.getSender().trim().isEmpty()&&p.getBody().trim().isEmpty()&&p.getTitle().trim().isEmpty()){return(-1);}
        else if((p.getSender()==null)&&(p.getBody()==null)&&(p.getTitle()==null)){
            return(-2);
        }else{
        if(!database.contains(p)){
            database.add(new Post(p.getTitle(), p.getBody(),p.getSender()));
            return(0);
        }else{return(-3);}
        */
        /*if((!(p.getSender()==null)&&!(p.getBody()==null)&&!(p.getTitle()==null))||(!(p.getSender().trim().isEmpty())&&!(p.getBody().trim().isEmpty())&&!(p.getTitle().trim().isEmpty()))){
            if(!database.contains(p)){
                database.add(new Post(p.getTitle(), p.getBody(),p.getSender()));
                return(0);
            }else{return(-2);}
        }else{return(-1);} */
        //https://lankydan.dev/2017/04/02/simple-spring-boot-post
        
    }
}