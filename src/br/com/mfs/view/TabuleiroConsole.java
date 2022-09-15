package br.com.mfs.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.mfs.exececao.ExplosaoException;
import br.com.mfs.exececao.SairException;
import br.com.mfs.model.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);
	public TabuleiroConsole(Tabuleiro tabuleiro) {

		this.tabuleiro = tabuleiro;
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			while (continuar) {
				cicloJogo();
				
				System.out.print("Outra Partida (S/n): ");
                String resposta = entrada.nextLine();
                
                if("n".equalsIgnoreCase(resposta)) {
                	continuar = false;
                }else {
                	tabuleiro.reiniciar();
                }
			}
		} catch (SairException sair) {
			System.out.println("TCHAU");
		} finally {
			entrada.close();
		}

	}

	private void cicloJogo() {
	   try{
		   while(!tabuleiro.objetivoAlcancado()){
			   System.out.println(tabuleiro);
			   String digitado = capturarValorDigitado("Digite (x, y): ");
			
			   Iterator<Integer> xy = Arrays.stream(digitado.split(",")).map(e -> Integer.parseInt(e.trim())).iterator();
			   digitado = capturarValorDigitado(" 1 - Abrir ou 2 - (Des)Marcar");
			   
			   if(digitado.equalsIgnoreCase("1")) {
				   tabuleiro.abrir(xy.next(), xy.next());				   
			   }else if(digitado.equalsIgnoreCase("2")) {
				   tabuleiro.marcar(xy.next(), xy.next());
			   }
		   }
		   System.out.println("VOCÊ GANHOU !!!");
	   }catch(ExplosaoException explosao){
		   System.out.println("VOCÊ PERDEU !!!");
	   }
	}
    
	public String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();
		if(digitado.equalsIgnoreCase("sair")) {
			throw new SairException("SAIR");
		}
		return digitado;
	}
}
