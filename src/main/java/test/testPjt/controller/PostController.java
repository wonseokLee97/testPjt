package test.testPjt.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.testPjt.DTO.PostRequestDto;
import test.testPjt.domain.Post;
import test.testPjt.service.PostService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("/write")
    public String createForm(Model model) {
        model.addAttribute("post", new PostRequestDto());
        return "post/writeForm";
    }

    @PostMapping("/write")
    public String post(@Validated PostRequestDto form,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("erros = {}", bindingResult.getAllErrors());
            return "post/writeForm";
        }

        Post post = Post.builder()
                .title(form.getTitle())
                .content(form.getContent())
                .reward(form.getReward())
                .build();

        postService.save(post);
        return "redirect:/";
    }
}
