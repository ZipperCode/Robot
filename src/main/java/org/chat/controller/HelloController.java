package org.chat.controller;

import org.chat.utils.nlpir.NLPIR;
import org.chat.utils.nlpir.OSInfo;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        File file = new File("pom.xml");
        boolean flag = file.exists();
        try {
            File data = ResourceUtils.getFile("Data");
            System.out.println(data.getPath());
            NLPIR.init(data.getParent());
            System.out.println(NLPIR.paragraphProcess("你好",1));
            NLPIR.exit();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
