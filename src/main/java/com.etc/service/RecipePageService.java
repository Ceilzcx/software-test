package com.etc.service;

import com.etc.model.RecipeEntity;

import java.util.List;

public class RecipePageService {

    public PageBean<RecipeEntity> findRecipeByPage(List<RecipeEntity> entities, int currentPage, int rows){
        PageBean<RecipeEntity> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        int totalCount = entities.size()%rows == 0 ? entities.size()/rows : entities.size()/rows+1;
        pageBean.setTotalCount(totalCount);
        int first = rows * (currentPage-1);
        int end = Integer.min(totalCount, rows*currentPage);
        pageBean.setList(entities.subList(first, end));

        pageBean.setTotalPage(entities.size());

        return pageBean;
    }

}
