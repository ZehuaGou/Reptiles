package com.reptiles.pp.form;

import lombok.Data;

/**
 * @author Paul Lee
 */
@Data
public class ArticleForm {

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章作者昵称
     */
    private String author;

    /**
     * 一级分类
     */
    private String oneCategoryName;
}
