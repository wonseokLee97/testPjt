package test.testPjt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @GetMapping("/list")
    public String PostList() {
        return "post/list";
    }

    @GetMapping("/write")
    public String PostWrite() {
        return "post/write";
    }

}
