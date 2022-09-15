package br.com.mfs.model;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private final int linha;
	private final int coluna;

	private boolean minado = false;
	private boolean aberto = false;
	private boolean marcado = false;
	
	private List<Campo> vizinhos = new ArrayList<>();
	

	protected Campo(boolean minado, int linha, int coluna) {
		this.minado = minado;
		this.linha = linha;
		this.coluna = coluna;
	}

	public boolean isMinado() {
		return minado;
	}

	public void setMinado(boolean minado) {
		this.minado = minado;
	}
	
	

}
