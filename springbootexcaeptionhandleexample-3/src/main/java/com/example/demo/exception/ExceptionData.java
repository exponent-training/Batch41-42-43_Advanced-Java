package com.example.demo.exception;

public class ExceptionData {

	
	private String url;
	
	private String errorMsg;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "ExceptionData [url=" + url + ", errorMsg=" + errorMsg + "]";
	}
	
	
	
}
