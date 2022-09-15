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

	public Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.getLinha();
		boolean colunaDiferente = coluna != vizinho.getColuna();
		boolean diagonal = linhaDiferente && colunaDiferente;

		int deltaLinha = Math.abs(linha - vizinho.getLinha());
		int deltaColuna = Math.abs(coluna - vizinho.getColuna());

		int deltaGeral = deltaLinha + deltaColuna;

		if (deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else if (deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else {
			return false;
		}

	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

}
