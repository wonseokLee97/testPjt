package test.testPjt.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import test.testPjt.domain.Post;
import test.testPjt.repository.PostRepository;

import java.util.Optional;

@Setter
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    // 게시물 등록
    public void save(Post post) {
        postRepository.save(post);
    }

    // 게시물 수정
    public Post edit(Long postId) {
        Optional<Post> byId = postRepository.findById(postId);

        return;
    }

    // 게시물 삭제
    public void delete(){}
}
