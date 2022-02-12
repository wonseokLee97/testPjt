package test.testPjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.testPjt.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
