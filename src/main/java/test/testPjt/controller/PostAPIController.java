//package test.testPjt.controller;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//import test.testPjt.DTO.PostRequestDto;
//import test.testPjt.DTO.PostResponseDto;
//import test.testPjt.service.MemberService;
//import test.testPjt.service.PostService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
//@Slf4j
//public class PostAPIController {
//
//    private final PostService postService;
//
//    @PostMapping("/posts")
//    public Long save(@RequestBody final PostRequestDto params) {
//        log.info("hi");
//        return postService.save(params);
//    }
//
//    @GetMapping("/posts")
//    public List<PostResponseDto> findAll() {
//        log.info("123!!");
//        return postService.findAll();
//    }
//
//    @PatchMapping("/posts/{id}")
//    public Long save(@PathVariable final Long id, @RequestBody final PostRequestDto params) {
//        return postService.edit(id, params);
//    }
//}
