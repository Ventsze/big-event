package com.ventsze.service;

import com.ventsze.pojo.Category;

import java.util.List;

public interface CategoryService {

    //新增分类
    void add(Category category);

    //列表查询
    List<Category> list();

    //更新分类
    void update(Category category);
}
