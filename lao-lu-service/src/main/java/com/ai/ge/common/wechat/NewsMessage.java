package com.ai.ge.common.wechat;


import java.util.List;

public class NewsMessage {
	
	//接收方帐号（收到的OpenID） 
	private String ToUserName;
		
	//开发者微信号 
	private String FromUserName;
		
	//消息创建时间 （整型）
	private Long CreateTime;
		
	//消息类型 news
	private String MsgType;
		
	//图文消息个数
	private int ArticleCount;
	
	//图文消息组
	private List<Article> Articles;
	
	
	public String getToUserName() {
		return ToUserName;
	}
		
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
		
	public String getFromUserName() {
		return FromUserName;
	}
	
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
		
	public Long getCreateTime() {
		return CreateTime;
	}
		
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
		
	public String getMsgType() {
		return MsgType;
	}
		
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

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
