package test.testPjt.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // fk

    @Column(nullable = false, length = 70)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false, length = 25)
    private Long reward;

    private String writer;
    private LocalDateTime createdTime = LocalDateTime.now();
    private LocalDateTime editedTime;
    private char deleteYN;

    @Builder
    public Post(Long id, String title, String content, char deleteYN, Long reward, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.reward = reward;
        this.deleteYN = deleteYN;
        this.writer = writer;
    }

    /*
    게시글 수정
     */
    public void edit(String title, String content, Long reward) {
        this.title = title;
        this.content = content;
        this.reward = reward;
        this.editedTime = LocalDateTime.now();
    }
}
