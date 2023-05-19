package backendStudy.spring.domain.post.controller;

import backendStudy.spring.domain.post.domain.Post;
import backendStudy.spring.domain.post.dto.PostDto;
import backendStudy.spring.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDto postDto) {
        Post createdPost = postService.createPost(postDto);
        return ResponseEntity.ok(createdPost);
    }

    @GetMapping
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public PostDto findPostById(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @PutMapping("/{id}")
    public PostDto updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        PostDto updatedPost = postService.updatePost(id, postDto);
        return updatedPost;
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "deleted";
    }

    @GetMapping("/search")
    public List<PostDto> search(@RequestParam(value = "keyword") String keyword) {
        List<PostDto> postDtoList = postService.searchPosts(keyword);
        return postDtoList;
    }

}
