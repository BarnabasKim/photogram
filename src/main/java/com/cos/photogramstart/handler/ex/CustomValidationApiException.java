package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomValidationApiException extends RuntimeException{

	//시리얼 번호는 객체를 구분할때!! 
	private static final long serialVersionUID = 1L;
	
	
	private Map<String, String > errorMap;
	public CustomValidationApiException(String message ) {
		super(message); 
	}
	
	
	public CustomValidationApiException(String message,  Map<String, String > errorMap ) {
		super(message); // 부모한테 던진다 자신이가지고있는것이 아니라 
		this.errorMap = errorMap;
	}
	
	//eroorMap을 리턴해주는 getter을 만든다 
	
	public Map<String,String> getErrorMap(){
		return errorMap;
	}

}
