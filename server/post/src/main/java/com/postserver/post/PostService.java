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
    public int createPost(Post p){
        /*
            0 is Good
            -1 is Something is empty
            -2 is Duplicate comment
            -3 is 
        */
        
        if(((!p.getSender().equals(""))&&(!p.getBody().equals(""))&&(!p.getTitle().equals("")))){
            System.out.println("ByPassed empty, now entering contains");
            if(!database.contains(p)){
                database.add(new Post(p.getTitle(), p.getBody(),p.getSender()));
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