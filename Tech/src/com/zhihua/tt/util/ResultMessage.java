package com.zhihua.tt.util;

/*
 * 针对保存删除更新等操作，返回运行结果信息的bean
 * zhaoshuibo
 */

public class ResultMessage {
	
	private boolean succ ;
	
	private String msg ;
	

	public ResultMessage(boolean succ, String msg) {
		super();
		this.succ = succ;
		this.msg = msg;
	}

	public boolean isSucc() {
		return succ;
	}

	public void setSucc(boolean succ) {
		this.succ = succ;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
}
