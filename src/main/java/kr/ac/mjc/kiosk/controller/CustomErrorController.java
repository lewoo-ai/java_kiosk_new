package kr.ac.mjc.kiosk.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // 에러 페이지를 반환
        return "errorPage"; // "errorPage.html"이라고 가정합니다.
    }

    public String getErrorPath() {
        return "/custom-error";
    }
}
