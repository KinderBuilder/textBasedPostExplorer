package com.postserver.post.post;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.postserver.post.post.Post; 
import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController{
    @GetMapping
	public List<String> toople(){
		Post post = new Post("Hotdogs","something","sleepy");
		return List.of(post.toString());	
	}
}