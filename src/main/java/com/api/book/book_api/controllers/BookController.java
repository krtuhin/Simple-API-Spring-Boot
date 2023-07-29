package com.api.book.book_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController - used in rest api in place of @Controller
//when use @RestController, don't need @ResponseBody annotation
//@GetMapping - @RequestMapping + RequestMethod.GET

@RestController
public class BookController {

    @GetMapping("/books")
    public String getBooks() {
        return "Testing first time";
    }
}