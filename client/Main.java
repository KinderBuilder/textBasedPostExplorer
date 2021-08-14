/*
Inside the client code, create a function called create post
within this function, use a Scanner to read in the text , title, and sender of the post
then create a in Object for this post...
*/
/*
 */

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.ProtocolException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Scanner;

import java.util.ArrayList;

import java.nio.charset.StandardCharsets;


public class Main{
    public static void main(String[] args) {
        sendPost("wifi","wow","weeeeE");
    }

    public static void sendPost(String t, String b, String s){
        try{
            URL url = new URL("http://127.0.0.1:8080/api/post");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            //create a json
            byte[] json = ("{\"title\":\""+t+"\",\"sender\":\""+s+"\",\"body\":\""+b+"\"}").getBytes(StandardCharsets.UTF_8);
            int length = json.length;
            con.setFixedLengthStreamingMode(length);
            con.setDoOutput(true);
            OutputStream out = con.getOutputStream();
            out.write(json);
            //think of the BufferedReader as the Youtube gray bar
            //this decodes the connection.getInputStream
            BufferedReader decoder = new BufferedReader(
                new InputStreamReader(con.getInputStream())
            );
            System.out.println(decoder.readLine());
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static ArrayList<Post> setLists(){
        try{
            URL url = new URL("http://127.0.0.1:8080/api/post");
            ArrayList<String> postList = new ArrayList<String>();


            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            //think of the BufferedReader as the Youtube gray bar
            //this decodes the connection.getInputStream
            BufferedReader decoder = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
            );
            //stores decoder into string
            String dogs = decoder.readLine();

            //prints out what it would look like in json
            while(dogs!=null){
                while(dogs.indexOf("{")!=-1){
                    int open = dogs.indexOf("{");
                    int close = dogs.indexOf("}");
                    postList.add(dogs.substring(open+1,close)); 
                    dogs = dogs.substring(close+1);
                }
                dogs = decoder.readLine();
            }
                ArrayList<Post> savedPosts = new ArrayList<Post>();
            for(int n = 0; n < postList.size(); n++){
 
                Post itsAPost = new Post();
                
                //splits the current strings inside postList by every comma, ','
                String[] underList = postList.get(n).split(",");
                
                //prints out underList
                for(int y = 0; y < underList.length; y++){
                    if (underList[y].split(":")[0].contains("sender")){
                         itsAPost.setSender(underList[y].split(":")[1]);     
                    } 
                    else if(underList[y].split(":")[0].contains("body")){
                        itsAPost.setBody(underList[y].split(":")[1]);
                    }
                    else if(underList[y].split(":")[0].contains("title")){
                        itsAPost.setTitle(underList[y].split(":")[1]);
                    }
                }
                savedPosts.add(itsAPost);
            }
            
            return(savedPosts);
        }catch(IOException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return(null);
    }
    /*public static void createPost(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the sender's name");
        String name = a.nextLine();
        System.out.pritnln("Please input the title");
        String title = a.nextLine();
        System.out.println("Please input your message");
        String message = a.nextLine();
        Post postCreated = new Post(title, body, sender);   
    }*/
}