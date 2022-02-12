package test.testPjt.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.testPjt.domain.Member;
import test.testPjt.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public String register(@Validated @ModelAttribute("member") Member memberRegister
            , BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.info("erros = {}", bindingResult.getAllErrors());
            return "member/register";
        }
        memberService.register(memberRegister);

        return "redirect:member/login";
    }
}
