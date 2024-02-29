package com.ventsze.controller;

import com.ventsze.pojo.Article;
import com.ventsze.pojo.Result;
import com.ventsze.service.ArticleService;
import com.ventsze.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
//
//    @GetMapping("/list")
//    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/){
////        //验证token
////        try {
////            Map<String, Object> claims = JwtUtil.parseToken(token);
////        } catch (Exception e) {
////            //http响应代码为401
////            response.setStatus(401);
////            return Result.error("未登录");
////        }
//        return Result.success("所有的文章数据。。。");
//    }

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody Article article){
        articleService.add(article);
        return Result.success();

    }
}
