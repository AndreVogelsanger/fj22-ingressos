package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DescontoTest {

	private Sala sala;
	private Sessao sessao;
	private Filme filme;
	private Lugar lugar;
	
	@Before
	public void before() {
		lugar = new Lugar("A", 1);
		sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
		filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
		sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
	}

	@Test
	public void naoDeveConcederDescontoParaIngressoNormal() {
//		Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
//		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
//		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO,lugar);
		BigDecimal precoEsperado = new BigDecimal("32.50");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void deveConcederDescontoDe30PorcentoParaIngressosDeClientesDeBancos() {
//		Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
//		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
//		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.BANCO,lugar);

		BigDecimal precoEsperado = new BigDecimal("22.75");

		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void deveConcederDescontoDe50PorcentoParaIngressoDeEstudante() {
//		Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
//		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), 
//				"SCI-FI", new BigDecimal("12"));
//		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.ESTUDANTE,lugar);
		BigDecimal precoEsperado = new BigDecimal("16.25");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}


}
