package br.com.caelum.ingresso.validacao;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class TestadorDeGerenciadorDeSessao {

	public static void main(String[] args) {
		
	
	Filme f = new Filme("Terminator",Duration.ofHours(1),"Ação");
	Sala s = new Sala("Sala Vip");
	Sessao sessaoNova = new Sessao(LocalTime.of(22,0),f,s);
	List<Sessao> sessoes = new ArrayList<>();
	GerenciadorDeSessao ger = new GerenciadorDeSessao(sessoes);
	System.out.println(ger.cabe(sessaoNova) == true ? "OK":"Falha");		
	
	f = new Filme("Terminator",Duration.ofHours(3),"Ação");
	s = new Sala("Sala Vip");
	sessaoNova = new Sessao(LocalTime.of(22,0),f,s);
	sessoes = new ArrayList<>();
	ger = new GerenciadorDeSessao(sessoes);
	System.out.println(ger.cabe(sessaoNova) == false ? "OK":"Falha");		
	
	f = new Filme("Terminator",Duration.ofHours(1),"Ação");
	s = new Sala("Sala Vip");
	sessaoNova = new Sessao(LocalTime.of(22,0),f,s);
	Sessao sessaoAtual = new Sessao(LocalTime.of(19,0),f,s);
	sessoes = Arrays.asList(sessaoAtual);
	ger = new GerenciadorDeSessao(sessoes);
	System.out.println(ger.cabe(sessaoNova) == true ? "OK":"Falha");
	
	f = new Filme("Terminator",Duration.ofHours(3),"Ação");
	s = new Sala("Sala Vip");
	sessaoNova = new Sessao(LocalTime.of(22,0),f,s);
	sessaoAtual = new Sessao(LocalTime.of(21,30),f,s);
	sessoes = Arrays.asList(sessaoAtual);
	ger = new GerenciadorDeSessao(sessoes);
	System.out.println(ger.cabe(sessaoNova) == false ? "OK":"Falha");
	
	}	
}