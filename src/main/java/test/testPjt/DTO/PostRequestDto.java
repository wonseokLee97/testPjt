package test.testPjt.DTO;

import lombok.*;
import test.testPjt.domain.Member;
import test.testPjt.domain.Post;
import test.testPjt.domain.Status;

import java.time.LocalDateTime;

@Getter @Setter
//@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostRequestDto {

    private String title;
    private String content;
    private Long reward;
    private String writer;
    private char deleteYN;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .reward(reward)
                .deleteYN(deleteYN)
                .writer(writer)
                .build();
    }
}
