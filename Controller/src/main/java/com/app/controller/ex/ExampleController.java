package com.app.controller.ex;

import com.app.controller.domain.ProductDTO;
import com.app.controller.domain.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/ex/*")
public class ExampleController {
    //    @RequestMapping(value="ex01", method = RequestMethod.GET)
    @GetMapping("ex01")
    public void ex01(){
        log.info("ex01.................");
    }

//    @GetMapping("ex02")
//    public void ex02(String name){
//        log.info("ex02.................");
//        log.info("name: {}", name);
//    }

    @GetMapping("ex02")
    public void ex02(@ModelAttribute("name") String name){
        log.info("ex02.................");
        log.info("name: {}", name);
    }

//    나이 전달받기
//    /ex/ex03

//    @GetMapping("ex03")
//    public void ex03(int age){
//        log.info("ex03.................");
//        log.info("age: {}", age);
//    }

        @GetMapping("ex03")
        public void ex03(@ModelAttribute("age")int age){
            log.info("ex03.................");
            log.info("age: {}살", age);
    }

//    이름과 나이 전달받기
//    ex/ex04

//@RequestParam("name2") 쓰면 name2 로도 사용가능

//    @GetMapping("ex04")
//    public void ex04(String name ,int age){
//        log.info("ex04................");
//        log.info("name: {} & age:{}", name,age);
//    }

//    @GetMapping("ex04")
//    public void ex04(@ModelAttribute("name") String name , @ModelAttribute("age")int age){
//        log.info("ex04................");
//        log.info("name: {} & age:{}", name,age);
//    }

//    전달받은 값이 많아지면 Model 객체를 받아 메소드를 써준다
    @GetMapping("ex04")
    public void ex04(String name , int age, Model model){
        log.info("ex04................");
        log.info("name: {} & age:{}", name,age);
        model.addAttribute("name",name);
        model.addAttribute("age",age);
    }

//    이름과 나이 전달받기
//    컨트롤러에서는 VO 쓰지않고 DTO를 쓴다
//    하지만 DB 쪽에서는 VO를 써야한다

//    @GetMapping("ex05")
//    public void ex05(UserDTO userDTO){
//        log.info("ex05................");
//        log.info(String.valueOf(userDTO));
//    }

    @GetMapping("ex05")
    public void ex05(UserDTO userDTO){
        log.info("ex05................");
        log.info("{}",userDTO);
    }

//    상품명과 가격 전달받기
//    @GetMapping("ex06")
//    public void ex06(ProductDTO productDTO){
//        log.info("ex06................");
//        log.info(String.valueOf(productDTO));
//    }

    @GetMapping("ex06")
    public void ex06(ProductDTO productDTO){
        log.info("ex06................");
        log.info("{}",productDTO);
    }
}
