package br.com.mfs.exececao;

public class ExplosaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
   
	public ExplosaoException(String MSG) {
		super(MSG);
	}
}
