package com.example.lse_bot.controller;

import com.example.lse_bot.model.NewsModel;
import com.example.lse_bot.services.LseServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LseController {
     private LseServices lseServices;

    LseController(LseServices lseServices)
    {
        this.lseServices=lseServices;
    }

    @GetMapping("/getnews")
    public ResponseEntity<List<NewsModel>> getAllRecords() {
        return ResponseEntity.status(200).body(lseServices.getnews());
    }

}
