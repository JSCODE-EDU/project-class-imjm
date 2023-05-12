package backendStudy.spring.domain.post.service;

import backendStudy.spring.domain.post.domain.Post;
import backendStudy.spring.domain.post.dto.PostDto;
import backendStudy.spring.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    @Transactional
    public Post createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setCreatedAt(postDto.getCreatedAt());
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    public List<Post> findAllPosts() {
        Pageable pageable = PageRequest.of(0, 100, Sort.Direction.DESC, "createdAt");
        Page<Post> postPage = postRepository.findAll(pageable);
        return postPage.getContent();
    }

    public PostDto findPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 id: " + id));

        return new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt());
    }

    @Transactional
    public PostDto updatePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post id: " + id));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepository.save(post);
        return new PostDto(updatedPost.getId(), updatedPost.getTitle(), updatedPost.getContent(), updatedPost.getCreatedAt());
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}
