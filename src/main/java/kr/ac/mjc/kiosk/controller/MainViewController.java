package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.service.CafeService;
import org.springframework.web.bind.annotation.GetMapping;

public class MainViewController {
 private final CafeService cafeService;

 @GetMapping("/cafes")
    public String getCafe(Model model) {
     List<mainView> cafes = cafeService.findAll().stream()
             .map(mainView::new)
     .tolist();
     model.addAttribute("cafes", cafes); // 저장

     return "main"; //main.html 뷰 조회
 }

}
