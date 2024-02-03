package com.jk.controller;

import com.jk.entity.Goods;
import com.jk.entity.Tokens;
import com.jk.service.IGoodsService;
import com.jk.service.ITokensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tokens")
public class TokenController {
    @Autowired
    private ITokensService tokensService;
    // 1、查询系统所有用户
    @GetMapping("/list")
    public List<Tokens> findAll(){
        return tokensService.findAll();
    }


}
