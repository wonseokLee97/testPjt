package test.testPjt.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
public class Privacy {

    private String phoneNum;
    private String email;

    public Privacy(String phoneNum, String email) {
        this.phoneNum = phoneNum;
        this.email = email;
    }
}
