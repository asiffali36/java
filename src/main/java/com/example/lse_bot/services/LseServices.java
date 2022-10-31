package com.example.lse_bot.services;

import com.example.lse_bot.repo.LseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LseServices {
    @Autowired
    LseRepo lseRepo;
public List getnews()
{
   return lseRepo.getNews();
}
}