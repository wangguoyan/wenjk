package com.jk.controller;

import com.jk.entity.Goods;
import com.jk.entity.Tokens;
import com.jk.entity.Users;
import com.jk.service.IGoodsService;
import com.jk.service.ITokensService;
import com.jk.service.IUsersService;
import com.jk.utils.ResultUtil;
import net.sf.jsqlparser.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @PostMapping("/login")
    public ResultUtil login(@RequestBody Tokens tokens ){
        List<Tokens> all = tokensService.findAll();
        Optional<Tokens> first = all.stream().filter(t -> Objects.equals(t.getPassword(), tokens.getPassword())
                && Objects.equals(t.getUsername(), tokens.getUsername())
                && Objects.equals(t.getRole(),tokens.getRole())).findFirst();
        return first.map(ResultUtil::ok).orElseGet(() -> ResultUtil.error("登陆失败，请检查用户名密码"));
    }




}
