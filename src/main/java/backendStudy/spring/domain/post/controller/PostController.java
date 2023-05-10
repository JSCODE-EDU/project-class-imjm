package backendStudy.spring.domain.post.controller;

import backendStudy.spring.domain.post.domain.Post;
import backendStudy.spring.domain.post.dto.PostDto;
import backendStudy.spring.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody PostDto postDto) {
        Post createdPost = postService.createPost(postDto);
        return ResponseEntity.ok(createdPost);
    }
}
