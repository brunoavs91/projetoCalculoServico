package br.com.banco.inter.exception;

import org.springframework.http.HttpStatus;

public class BancoInterException extends RuntimeException {
	private static final long serialVersionUID = 2696967935110761853L;
	
	private String message;
	
	private HttpStatus status;
	
	public BancoInterException(String message,HttpStatus status) {
		this.message=message;
		this.status=status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
