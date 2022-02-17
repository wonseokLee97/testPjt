package test.testPjt.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberRequestDTO {

    @NotEmpty(message = "회원 아이디는 필수기입 항목입니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수기입 항목입니다.")
    private String password;
    private String phoneNum;
    private String email;


}
