package test.testPjt.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testPjt.DTO.PostRequestDto;
import test.testPjt.DTO.PostResponseDto;
import test.testPjt.domain.Post;
import test.testPjt.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    // 게시물 등록
    @Transactional
    public void save(Post post) {
        postRepository.save(post);
    }

    // 게시글 조회
    public List<PostResponseDto> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Post> list = postRepository.findAll(sort); // post 리스트

        List<PostResponseDto> PostList = new ArrayList<>();

        for(Post entity : list){
            PostList.add(new PostResponseDto(entity));
        }

        return PostList;
    }

    // 게시물 수정
    @Transactional
    public Long edit(Long id, PostRequestDto params) {
        Post entity = postRepository.findById(id).orElseThrow();
        entity.edit(params.getTitle(), params.getContent(), params.getReward());
        return id;
    }
}
