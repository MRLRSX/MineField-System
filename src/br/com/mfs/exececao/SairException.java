package br.com.mfs.exececao;

public class SairException extends RuntimeException{

	private static final long serialVersionUID = 1L;
    
	public SairException(String MSG) {
		super(MSG);
	}
}
