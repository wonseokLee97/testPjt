package test.testPjt.DTO;

import lombok.Getter;
import lombok.Setter;
import test.testPjt.domain.Member;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberResponseDTO {

    private Long id;
    private String username;
    private String phoneNum;
    private String email;

    public MemberResponseDTO(Member entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.phoneNum = entity.getPrivacy().getPhoneNum();
        this.email = entity.getPrivacy().getEmail();
    }
}
