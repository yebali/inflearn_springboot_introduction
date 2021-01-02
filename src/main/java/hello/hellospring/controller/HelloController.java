package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");

        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam String name, Model model) {
        model.addAttribute("data", name);

        return "hello-mvc";
    }

    @GetMapping("hello-string")
    @ResponseBody //해당 애너테이션이 있으면 viewResolever없이 return값 그대로 응답함. 객체일 경우 json방식으로 반환.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello; // 객체를 반환 시, 자동으로 json으로 변환하여 반환.
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
