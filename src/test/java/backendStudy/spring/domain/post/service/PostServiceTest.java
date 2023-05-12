package backendStudy.spring.domain.post.service;

import backendStudy.spring.domain.post.domain.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {
    @Autowired
    private PostService postService;

    @Test
    void findAllPostsWithLimit() {
        List<Post> posts = postService.findAllPosts();
        Assertions.assertTrue(posts.size() <= 100, "Post count exceeds limit of 100");
    }
}