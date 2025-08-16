package rest_web_services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "hello Independence Day My Brother!!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello world");
    }
    @GetMapping(path = "/hello-world/year/{years}")
    public String helloWorld(@PathVariable("years") int years) {
        return String.format("hello Independence Day My Brother!! its %s years if independence",years);
    }


}
