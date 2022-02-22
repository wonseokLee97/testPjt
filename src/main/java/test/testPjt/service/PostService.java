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
    public void save(PostRequestDto form) {

        Post post = Post.builder()
                .title(form.getTitle())
                .content(form.getContent())
                .reward(form.getReward())
                .build();
        postRepository.save(post);
    }

    // 게시판 조회
    public List<PostResponseDto> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<PostResponseDto> PostList = new ArrayList<>();
        List<Post> list = postRepository.findAll(sort); // post 리스트


        for(Post entity : list){
            PostList.add(new PostResponseDto(entity));
        }

        return PostList;
    }

    // 게시물 조회
    public PostResponseDto findOne(Long postId){
        Post entity = postRepository.findById(postId).orElseThrow();
        PostResponseDto postDetail = new PostResponseDto(entity);

        return postDetail;
    }

    // 게시물 수정
    @Transactional
    public void edit(Long id, PostRequestDto form) {
        Post entity = postRepository.findById(id).orElseThrow();
        entity.edit(form.getTitle(), form.getContent(), form.getReward());
    }

    // 찜하기
    public void heart(Long id){
        Post post = postRepository.findById(id).orElseThrow();
    }


}
