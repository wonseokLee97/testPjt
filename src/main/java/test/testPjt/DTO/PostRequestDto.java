package test.testPjt.DTO;

import lombok.*;
import test.testPjt.domain.Member;
import test.testPjt.domain.Post;
import test.testPjt.domain.Status;

import java.time.LocalDateTime;

@Getter @Setter
public class PostRequestDto {

    private String title;
    private String content;
    private Long reward;

    public Post toEntity(Post entity) {
        return Post.builder()
                .title(entity.getTitle())
                .content(entity.getContent())
                .reward(entity.getReward())
                .build();
    }
}
