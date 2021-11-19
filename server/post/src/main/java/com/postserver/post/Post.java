package com.postserver.post;
//create to json
public class Post{
    private String title;
    private String sender;
    private String body;
    public Post(String t, String b, String s){
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
        return "title: " + this.title + "\nbody: " + this.body + "\nsent by:" + this.sender + "\n";
    }
    @Override
    public boolean equals(Object o){
        boolean isEquals = false;
        if(o!=null&&o instanceof Post){
            System.out.println(((Post)o).title);
            //TypeCasting aka converting variables into other variables similar to it (ex: int to long)
            if(this.title.equals(((Post) o).title)&&this.body.equals(((Post)o).body)&&this.sender.equals(((Post)o).sender)){
                isEquals = true;
            }
        }
        return isEquals;
    }
}