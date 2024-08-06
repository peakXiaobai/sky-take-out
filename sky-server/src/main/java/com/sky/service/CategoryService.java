package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

/**
 * @Author: Y-peak
 * @Date: 2024/8/6 15:40 星期二
 * @ProductName: IntelliJ IDEA
 * @ProjectName: sky-take-out
 * @ClassName: CategoryService
 * @Description:
 */
public interface CategoryService {
    /**
     * 新增分类
     * @param categoryDTO
     */
    void addCategory(CategoryDTO categoryDTO);

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    void deleteById(Long id);

    /**
     * 修改分类信息
     * @param categoryDTO
     * @return
     */
    void updateCategory(CategoryDTO categoryDTO);

    /**
     * 启用、禁用分类
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}
