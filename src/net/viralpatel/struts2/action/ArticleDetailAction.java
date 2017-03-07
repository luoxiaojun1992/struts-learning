package net.viralpatel.struts2.action;

import java.io.IOException;

import net.viralpatel.struts2.bean.*;
import net.viralpatel.struts2.helper.MarkdownHelper;
import net.viralpatel.struts2.service.ArticleService;

public class ArticleDetailAction extends BaseAction {

    private Article article;
    
    private ArticleService articleServ;
    
    public String execute() {
    	
    	setArticle(getArticleServ().getArticleById(Integer.parseInt(getParam("id", "0"))));
    	
    	return super.execute();
        
    }
    
    public Article getArticle() {
    	
    	return article;
    
    }
    
    //Parse Markdown
    private Article getMarkdownParsedArticle(Article article) {

    	try {
    		article.setContent(MarkdownHelper.getInstance().parse(article.getContent()));
    	} catch (IOException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return article;
    	
    }
    
    public void setArticle(Article article) {
    	
    	this.article = getMarkdownParsedArticle(article);
    
    }
    
    public void setArticleServ(ArticleService articleServ) {
    	
    	this.articleServ = articleServ;
    
    }
    
    public ArticleService getArticleServ() {
    	
    	return articleServ;
    
    }
    
}
