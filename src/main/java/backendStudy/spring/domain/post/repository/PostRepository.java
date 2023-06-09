package backendStudy.spring.domain.post.repository;

import backendStudy.spring.domain.post.domain.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);
    void deleteById(Long id);
    List<Post> findByTitleContaining(String keyword, Pageable pageable);
}
