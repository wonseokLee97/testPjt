package test.testPjt.DTO;

import lombok.Getter;
import test.testPjt.domain.Post;
import test.testPjt.domain.Status;
import java.time.LocalDateTime;

@Getter
public class PostResponseDto {

    private Long id;
    private String writer; // fk
    private LocalDateTime createdTime;
    private String title;
    private String content;
    private Long reward;
    private LocalDateTime editedTime;
    private char deleteYN;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.writer = entity.getWriter();
        this.createdTime = entity.getCreatedTime();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.reward = entity.getReward();
        this.editedTime = entity.getEditedTime();
        this.deleteYN = entity.getDeleteYN();
    }
}
