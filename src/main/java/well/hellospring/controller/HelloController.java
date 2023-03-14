package well.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class  HelloController {

    @GetMapping("hello") // URL이 ../hello 인 경우 아래 함수 실행
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello";  // Spring의 viewResolver가 hello.html을 찾아서 템플릿 엔진 처리 후 브라우저에 전달
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // html 파일 없이 return 한 값을 그대로 화면에 띄워준다.
    public String helloString (@RequestParam("name") String name) {
        return  "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}