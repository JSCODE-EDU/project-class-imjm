package backendStudy.spring.domain.post.service;

import backendStudy.spring.domain.post.domain.Post;
import backendStudy.spring.domain.post.dto.PostDto;
import backendStudy.spring.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        Post savedPost = postRepository.save(post);
        return savedPost;
    }


}
