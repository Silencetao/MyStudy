package com.silencetao.exception;

/**
 * 自定义异常类
 * @author Silence
 *
 */
public class AuctionException extends Exception {
	private static final long serialVersionUID = -7404958854907331279L;

	public AuctionException() {
		
	}
	
	public AuctionException(String message) {
		super(message);
	}
}
