package test.testPjt.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.testPjt.domain.Member;
import test.testPjt.domain.Privacy;
import test.testPjt.service.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/register")
    public String createForm(Model model){
        log.info("hi!@#");
        model.addAttribute("memberForm", new MemberForm());
        return "member/createForm";
    }

    @PostMapping("/register")
    public String create(@Validated MemberForm form,
                         BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.info("erros = {}", bindingResult.getAllErrors());
            return "member/createForm";
        }

        Privacy privacy = new Privacy(form.getPhoneNum(), form.getEmail());

        Member member = Member.builder()
                .username(form.getUsername())
                .password(form.getPassword())
                .privacy(privacy)
                .build();

        memberService.register(member);
        return "redirect:/";
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
