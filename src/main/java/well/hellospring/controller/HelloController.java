package well.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // URL이 ../hello 인 경우 아래 함수 실행
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello";  // Spring의 viewResolver가 hello.html을 찾아서 템플릿 엔진 처리 후 브라우저에 전달
    }
}
