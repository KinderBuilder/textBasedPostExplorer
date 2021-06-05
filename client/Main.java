import java.net.HttpURLConection;
import java.net.URL;

public class Main{
    public static void main(String[] args) {
        URL url = new URL("http://127.0.0.1:8080/api/post");
        HttpURLConection connection = (HttpURLConection)url.openConnection;
        connection.setRequestMethod("GET");
    }
}