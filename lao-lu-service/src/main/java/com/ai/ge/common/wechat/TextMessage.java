package com.ai.ge.common.wechat;


public class TextMessage {

	//接收方帐号（收到的OpenID） 
	private String ToUserName;
	//开发者微信号 
	private String FromUserName;
	//消息创建时间 （整型） 
	private Long CreateTime;
	//消息类型
	private String  MsgType;
	//回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示） 
	private String Content;
	private int FuncFlag;
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

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(int funcFlag) {
		FuncFlag = funcFlag;
	}
	
}
