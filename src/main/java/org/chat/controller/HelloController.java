package org.chat.controller;

import org.chat.annotation.Log;
import org.chat.utils.nlpir.NLPIR;
import org.chat.utils.nlpir.OSInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileNotFoundException;

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
