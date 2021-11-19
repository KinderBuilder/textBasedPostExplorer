package com.postserver;
//imports the files
import com.postserver.Account.Account;
import com.postserver.post.Post;

import java.util.ArrayList;

import javax.xml.crypto.Data;

public class Database {
    private static ArrayList<Account> accounts = new ArrayList<Account>();    
    private static ArrayList<Post> posts = new ArrayList<Post>();

    //Getters
    public static ArrayList<Post> getPosts(){return(posts);}
    public static ArrayList<Account> getAccounts(){return(accounts);}

    //Adders (Ig)
    public static void addPosts(Post add){posts.add(add);}
    public static void addAccounts(Account add){accounts.add(add);}

    //Search
    public static boolean containsPosts(Post search){return posts.contains(search);}
    public static boolean containsAccounts(Account search){return accounts.contains(search);}

    /* Think this was a mistake \_(=_=)_/
    public static void addToPost(Post p){posts.add(p);}
    public static void addToAccount(Account a){accounts.add(a);}*/
}
