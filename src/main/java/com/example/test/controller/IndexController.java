package com.example.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping({"/","/home"})
    public String index(){
        return "login/index";
    }


  /*  @GetMapping({"/","/index"})
    public String index(){
        return "login/index";
    }
    @GetMapping("toLoginForm")
    public String toLoginForm(){
        return "login/login";
    }

    @GetMapping("/level1/{id}")
    public String level1(@PathVariable("id")int id){
        return "views/level1"+"/"+id;
    }
    @GetMapping("/level2/{id}")
    public String level2(@PathVariable("id")int id){
        return "views/level2"+"/"+id;
    }
    @GetMapping("/level3/{id}")
    public String level3(@PathVariable("id")int id){
        return "views/level3"+"/"+id;
    }*/


}
