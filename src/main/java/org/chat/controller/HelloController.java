package org.chat.controller;

import org.chat.annotation.Log;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.File;

@RestController
@Validated
public class HelloController {


    @GetMapping("/hello")
    @Log
    public String hello(HttpServletRequest request,
                        @NotNull(message = "name 不能为空") String name,
                        @NotNull(message = "age 不能为空") Integer age) {
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        File file = new File("pom.xml");
        return "success";
    }
}
