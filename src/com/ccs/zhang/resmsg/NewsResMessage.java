package com.ccs.zhang.resmsg;

import java.util.List;

/**
 * Created by Administrator on 2015/1/23.
 */
public class NewsResMessage extends BaseResMessage {
    private int ArticleCount;
    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
