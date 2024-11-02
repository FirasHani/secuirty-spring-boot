package com.demo.security.demo;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
public class ManagementController {

    @GetMapping
    public String get(){
        return "Hello iam management";
    }

    @PostMapping
    public String post(

    ){
        return "hello post management";
    }

    @PutMapping
    public String put(){
        return "hello put management";
    }

    @DeleteMapping
    public String delete(){
        return "hello delete management";
    }

}
