package br.com.msf.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mfs.model.Campo;

class CampoTest {

	private Campo campo;
	
	@BeforeEach
	void inciarCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test
	void testVizinhoDireita() {
	  Campo vizinho = new Campo(3, 2);
	  boolean result = campo.adicionarVizinho(vizinho);
	  assertTrue(result);
	}
	
	@Test
	void testVizinhoEsquerda() {
	  Campo vizinho = new Campo(3, 4);
	  boolean result = campo.adicionarVizinho(vizinho);
	  assertTrue(result);
	}
	
	@Test
	void testVizinhoCima() {
	  Campo vizinho = new Campo(2, 3);
	  boolean result = campo.adicionarVizinho(vizinho);
	  assertTrue(result);
	}
	
	@Test
	void testVizinhoBaixo() {
	  Campo vizinho = new Campo(4, 3);
	  boolean result = campo.adicionarVizinho(vizinho);
	  assertTrue(result);
	}
	
	@Test
	void testVizinhoDiagonal1() {
	  Campo vizinho = new Campo(2, 2);
	  boolean result = campo.adicionarVizinho(vizinho);
	  assertTrue(result);
	}
	
	@Test
	void testVizinhoDiagonal2() {
	  Campo vizinho = new Campo(2, 4);
	  boolean result = campo.adicionarVizinho(vizinho);
	  assertTrue(result);
	}
	
	@Test
	void testVizinhoDiagonal3() {
	  Campo vizinho = new Campo(4, 2);
	  boolean result = campo.adicionarVizinho(vizinho);
	  assertTrue(result);
	}
	
	@Test
	void testVizinhoDiagonal4() {
	  Campo vizinho = new Campo(4, 4);
	  boolean result = campo.adicionarVizinho(vizinho);
	  assertTrue(result);
	}
	
	@Test
	void testNaoVizinho() {
	  Campo vizinho = new Campo(1, 1);
	  boolean result = campo.adicionarVizinho(vizinho);
	  assertFalse(result);
	}
}
