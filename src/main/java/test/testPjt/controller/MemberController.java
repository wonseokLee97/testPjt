package test.testPjt.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.testPjt.DTO.MemberRequestDTO;
import test.testPjt.DTO.MemberResponseDTO;
import test.testPjt.domain.Member;
import test.testPjt.domain.Privacy;
import test.testPjt.repository.MemberRepository;
import test.testPjt.service.MemberService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/register")
    public String createForm(Model model) {
        log.info("hi!@#");
        model.addAttribute("memberForm", new MemberRequestDTO());
        return "member/createForm";
    }

    @PostMapping("/register")
    public String create(@Validated @ModelAttribute("memberForm") MemberRequestDTO form,
                         BindingResult result) {
        log.info("1234!@#");

        if (result.hasErrors()) {
            return "member/createForm";
        }

        Privacy privacy = new Privacy(form.getPhoneNum(), form.getEmail());

        Member member = Member.builder()
                .username(form.getUsername())
                .password(form.getPassword())
                .privacy(privacy)
                .build();

        log.info("pass1!");
        memberService.register(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<MemberResponseDTO> members = memberService.findAll();
        model.addAttribute("members", members);
        return "member/memberList";
    }


//    @PostMapping("/register")
//    public String register(@Validated @ModelAttribute("member") Member memberRegister
//            , BindingResult bindingResult) {
//
//        if(bindingResult.hasErrors()) {
//            log.info("erros = {}", bindingResult.getAllErrors());
//            return "member/register";
//        }
//        memberService.register(memberRegister);
//
//        return "redirect:member/login";
//    }

}
