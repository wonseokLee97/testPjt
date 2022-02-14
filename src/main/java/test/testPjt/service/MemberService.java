package test.testPjt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testPjt.domain.Member;
import test.testPjt.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 등록
    @Transactional
    public void register(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        log.info("검증중...");
        log.info(member.getUsername());
        List<Member> findUser = memberRepository.findByUsername(member.getUsername());
        log.info(findUser.toString());

        if (!findUser.isEmpty()) {
            log.info("already user ...");
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
