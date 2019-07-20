package com.reptiles.pp.service;

import com.reptiles.pp.enums.OneCategoryEnum;
import com.reptiles.pp.form.ArticleForm;
import com.reptiles.pp.mapper.ArticleMapper;
import com.reptiles.pp.model.Article;
import com.reptiles.pp.utils.ApplicationUtil;
import com.reptiles.pp.utils.EnumUtil;
import com.reptiles.pp.utils.HeaderUtil;
import com.reptiles.pp.utils.KeyUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Paul Lee
 * <p>
 * 爬取人民网新闻内容
 */
@Service
public class CrawlNewsService {

    /**
     * 自动注入ArticleMapper
     */
    private ArticleMapper articleMapper;

    /**
     * 页面信息
     */
    private Document document = null;

    public CrawlNewsService() {
    }

    public CrawlNewsService(String url) {
        //获得连接
        Connection connection = Jsoup.connect(url).headers(HeaderUtil.getPPHeader());

        ApplicationContext ac = ApplicationUtil.getAc();
        articleMapper = (ArticleMapper) ac.getBean("articleMapper");

        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析传入的第一个链接
     *
     * @throws IOException
     */
    public void parseFirstUrl() throws IOException {

        List<String> urls = getUrls();

        for (String url : urls) {
            //获得详情页内容
            Document html = Jsoup.connect(url).headers(HeaderUtil.getPPHeader()).get();
            parseDetails(html);
        }
    }

    /**
     * 将详细内容存入提取并保存
     *
     * @param html
     */
    private void parseDetails(Document html) {

        //先判断要解析页面是否符合规则
        if (judRules(html)) {
            //获得文章标题
            Element title = html.select("div.clearfix.w1000_320.text_title > h1").get(0);
            //获得文章作者
            Element author = html.select("div.clearfix.w1000_320.text_title div.fl > a").get(0);
            //获得文章内容
            Element content = html.select("#rwb_zw").get(0);
            //获得一级分类
            Element oneCategoryName = html.select("#rwb_navpath > a:nth-child(2)").get(0);

            ArticleForm form = new ArticleForm();
            form.setTitle(title.text());
            form.setAuthor(author.text());
            form.setContent(content.outerHtml());
            form.setOneCategoryName(oneCategoryName.text());

            save(form);
        }
    }

    /**
     * 保存数据
     *
     * @param form
     */
    private void save(ArticleForm form) {

        Article article = new Article();
        BeanUtils.copyProperties(form, article);

        article.setArticleId(KeyUtil.genUniqueKey());
        OneCategoryEnum oneCategoryEnum = EnumUtil.getByMessage(article.getOneCategoryName(), OneCategoryEnum.class);
        if (oneCategoryEnum == null) {
            oneCategoryEnum = OneCategoryEnum.OTHER;
        }

        article.setOneCategoryId(oneCategoryEnum.getCode());
        article.setOneCategoryName(oneCategoryEnum.getMessage());

        articleMapper.insertSelective(article);
    }

    /**
     * 获得本页面标题链接
     *
     * @return
     */
    private List<String> getUrls() {

        List<String> urls = new ArrayList<>();
        Elements newsTitles = document.select("div.news_box a");

        for (Element newsTitle : newsTitles) {
            urls.add(newsTitle.attr("abs:href"));
        }

        return urls;
    }


    /**
     * 判断将要解析的页面是否符合规则
     *
     * @param html
     * @return
     */
    private boolean judRules(Document html) {

        //获得此详情页标题
        Elements titles = html.select("div.clearfix.w1000_320.text_title > h1");

        //如果此详情页包含标题则证明符合规则
        return titles.size() > 0;
    }
}
