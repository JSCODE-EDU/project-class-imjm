package backendStudy.spring.domain.post.service;

import backendStudy.spring.domain.post.domain.Post;
import backendStudy.spring.domain.post.dto.PostDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void testSearchPosts() {
        // given
        String keyword = "Spring";

        // when
        List<PostDto> postDtoList = postService.searchPosts(keyword);

        // then
        assertThat(postDtoList.size()).isLessThanOrEqualTo(100);
        for(PostDto postDto : postDtoList) {
            assertThat(postDto.getTitle()).contains(keyword);
        }
    }
}

