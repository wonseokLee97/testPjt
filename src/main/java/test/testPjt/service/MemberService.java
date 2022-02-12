package test.testPjt.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Long register(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
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

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}

//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import test.testPjt.domain.Member;
//import test.testPjt.repository.MemberRepository;
//
//@Service
//@Transactional(readOnly = true)
//@Slf4j
//@RequiredArgsConstructor
//public class MemberService {
//
//    private final MemberRepository memberRepository;
//
//    @Transactional
//    public Member register(Member member){
//        return memberRepository.save(member);
//    }
//}
