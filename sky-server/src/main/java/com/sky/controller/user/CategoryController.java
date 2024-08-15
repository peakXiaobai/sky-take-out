package com.sky.controller.user;

import com.sky.entity.Category;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Y-peak
 * @Date: 2024/8/15 12:54 星期四
 * @ProductName: IntelliJ IDEA
 * @ProjectName: sky-take-out
 * @ClassName: CategoryController
 * @Description:
 */
@RestController("userCategoryController")
@RequestMapping("/user/category")
@Slf4j
@Api(tags = "C端-分类接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("查询分类")
    public Result<List<Category>> list(Integer type) {
        log.info("用户端查询分类：{}",type);
        List<Category> list = categoryService.queryByCategory(type);
        return Result.success(list);
    }
}