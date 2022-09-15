package br.com.msf.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mfs.exececao.ExplosaoException;
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
	
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarDuasMarcacao() {
		campo.alternarMarcao();
		campo.alternarMarcao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirComVizinhos() {
		Campo campo11 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2);
      
        campo22.adicionarVizinho(campo11);
        campo.adicionarVizinho(campo22);
        
		campo.abrir();
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhos2() {

		Campo campo12 = new Campo(1, 2);
		Campo campo11 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2);
		
		campo12.minar();
        
		campo22.adicionarVizinho(campo12);
        campo22.adicionarVizinho(campo11);
        campo.adicionarVizinho(campo22);
        
		campo.abrir();
		assertTrue(campo22.isAberto() && !campo11.isAberto() && !campo12.isAberto());
	}
}
