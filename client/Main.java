/*
Inside the client code, create a function called create post
within this function, use a Scanner to read in the text , title, and sender of the post
then create a in Object for this post...
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
        //instatiate
        Scanner in = new Scanner(System.in);
        while(true){
            Menu();
            while(!in.hasNextInt()){
                System.out.println("Please input a number");
                in.nextLine();
                System.out.print(": ");
            }
            int choice = in.nextInt();
            in.nextLine();
            if(choice == 1){
                System.out.println("Cool. \nOk than, please input the title of your post");
                String title = in.nextLine();
                System.out.println("Next is the body!");
                String body = in.nextLine();
                System.out.println("Finally is the sender, aka your name");
                String sender = in.nextLine();
                System.out.println(sendPost(title, body, sender));
            } else if(choice == 2){
                ArrayList<Post> savedPost = setLists();
                for(int i=0; i<savedPost.size();i++){
                    System.out.println((savedPost.get(i)).toString());
                }
            } else if (choice==3){
                System.out.println("Well than, I'll be seeing you soon... Trust me");
                break;
            }
        }
    }
    //this prints out the menu
    public static void Menu(){
        System.out.println("Hello there potential customer. Would you like to create a post (1). Or would you be interested in viewing some posts (2)? But maybe, just maybe, you're interested on leaving? (3)");
    }
    //this creates Posts
    public static boolean sendPost(String t, String b, String s){
        //This "con" is a references
        HttpURLConnection con;
        try{
            URL url = new URL("http://127.0.0.1:8080/api/post");
            con = (HttpURLConnection)url.openConnection();
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
            return true;
        } catch(IOException e){
            if(e.getMessage().contains("409")){System.out.println("There's an imposta here\nDuplicate Comments");}
            else if(e.getMessage().contains("417")){System.out.println("Where's Waldo?\nPost was missing a field");}
            else if(e.getMessage().contains("400")){System.out.println("ERRROOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOR\nAn error occured and we don't know why");}
            else{System.out.println("What have you DONE!? \n An error occured and you somehow managed to break this server. *clap* *clap* *clap*");}
            return false;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    //This gets the posts
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