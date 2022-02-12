package test.testPjt.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import test.testPjt.domain.Member;
import test.testPjt.repository.MemberRepository;

@WebAppConfiguration
@SpringBootTest
@Transactional
@Slf4j
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        Member member =
                Member.builder()
                        .username("test")
                        .password("1234")
                        .build();
        Member member1 = memberRepository.save(member);
        System.out.println(member1.toString() + "!!!");
    }

    @Test
    public void 중복() throws Exception {
        // given
        Member member1 = Member.builder()
                .username("kim1")
                .password("1234")
                .build();

        Member member2 = Member.builder()
                .username("kim1")
                .password("1234")
                .build();

        // when
        memberService.register(member1);
        memberService.register(member2);

        // then
//        fail("예외가 발생한다.");
    }

}