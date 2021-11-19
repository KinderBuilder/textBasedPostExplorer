package com.postserver.post;
import org.springframework.web.bind.annotation.RestController;

//import jdk.nashorn.internal.ir.Request;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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
		//api handling
		//Post post = new Post("Hotdogs","something","sleepy");
		//return List.of(post.toString());
		return this.ps.getPosts(); 
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> savePost(@RequestBody Post p){
		switch(this.ps.createPost(p)){
			case 0: return new ResponseEntity<String>("Congratulations, your message can now be seen by everyone!", HttpStatus.OK);
			case -1: return new ResponseEntity<String>("Something's empty...\n Empty Field", HttpStatus.EXPECTATION_FAILED);
			case -2: return new ResponseEntity<String>("Where's Waldo? \n Post was missing a field", HttpStatus.EXPECTATION_FAILED);
			case -3: return new ResponseEntity<String>("There's an imposta here \n Duplicate Comments", HttpStatus.CONFLICT);
			default: return new ResponseEntity<String>("ERRROOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOR \n An error occured and we don't know why", HttpStatus.BAD_REQUEST);
		}
	} 
}