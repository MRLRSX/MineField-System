package br.com.msf.application;

import br.com.mfs.model.Tabuleiro;
import br.com.mfs.view.TabuleiroConsole;

public class Program {
	public static void main(String[] args) {
      Tabuleiro tabuleiro = new Tabuleiro(6, 6, 1);
      new TabuleiroConsole(tabuleiro);
	}
}
