package test.testPjt.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.testPjt.DTO.PostRequestDto;
import test.testPjt.DTO.PostResponseDto;
import test.testPjt.domain.Post;
import test.testPjt.service.PostService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
@Slf4j
public class PostController {

    private final PostService postService;

    // 게시물 작성
    @GetMapping("/write")
    public String createForm(Model model) {
        model.addAttribute("post", new PostRequestDto());
        return "post/writeForm";
    }

    // 게시물 작성
    @PostMapping("/write")
    public String post(@Validated @ModelAttribute("post") PostRequestDto form,
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
        return "redirect:/post/list";
    }

    // 게시판 조회
    @GetMapping("/list")
    public String list(Model model) {
        List<PostResponseDto> postList = postService.findAll();
        model.addAttribute("posts", postList);
        return "post/postList";
    }

    // 게시물 조회
    @GetMapping("/{postId}/detail")
    public String detailPost(@PathVariable("postId") Long postId, Model model) {
        PostResponseDto form = postService.findOne(postId);
        model.addAttribute("form", form);
        log.info("success!!...");
        return "post/postDetail";
    }

    // 게시물 수정
    @GetMapping("/{postId}/edit")
    public String updatePost(@PathVariable("postId") Long postId, Model model) {

        PostResponseDto form = postService.findOne(postId);
        model.addAttribute("form", form);
        log.info("success!!123...");
        return "post/postUpdate";
    }

    @PostMapping("/{postId}/edit")
    public String updatePost(@PathVariable Long postId, @ModelAttribute("form") PostRequestDto form) {
        postService.edit(postId, form);
        return "redirect:/post/list";
    }
}
