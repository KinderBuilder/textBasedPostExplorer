package com.postserver.post;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//imports code from other classes
import com.postserver.post.Post; 
import com.postserver.post.PostService;


@RestController
@RequestMapping("api/post")
public class PostController{
	
	private final PostService ps;

	@Autowired
	public PostController(PostService postService){
		this.ps=postService;
	}

    @GetMapping
	public List<Post> toople(){
		//Post post = new Post("Hotdogs","something","sleepy");
		//return List.of(post.toString());
		return this.ps.getPosts();
	}
	
}