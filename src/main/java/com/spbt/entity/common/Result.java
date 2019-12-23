package com.spbt.entity.common;

/**
 *
 * json结果实体
 */
public class Result {
	
	/**状态*/
	private boolean status;
	
	/**消息*/
	private String message;
	
	/**状态*/
	private int state;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Result(boolean status ,String message) {
		this.status = status;
		this.message = message;
	}
	
	public Result() {
		
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
