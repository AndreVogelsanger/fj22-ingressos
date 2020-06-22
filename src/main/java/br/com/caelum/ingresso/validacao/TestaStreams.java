package br.com.caelum.ingresso.validacao;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.ingresso.model.Filme;

public class TestaStreams {
	
	public static void main(String[] args) {
		
		Filme f1 = new Filme("Terminator",Duration.ofHours(1),"Ação");
		Filme f2 = new Filme("Derminato2",Duration.ofHours(1),"Drama");
		Filme f3 = new Filme("Aerminator3",Duration.ofHours(1), "Drama");
		
		List<Filme> filmes = Arrays.asList(f1,f2,f3);
		
		System.out.println("Filmes: ");

//     mesma forma de escrever.
//		filmes.stream().forEach(f -> System.out.println(f.getNome()));
		filmes.stream()
			.map(f -> f.getNome())
			.sorted()
			.forEach(System.out::println);
//			for(Filme f :filmes) {
//			System.out.println(f.getNome());	
//		}
	
		
		
//		List<Filme> dramas = new ArrayList<>();
//		for(Filme f :filmes) {
//			if ("Drama".equals(f.getGenero()))
//				dramas.add(f);	
//		}
		
//		List<Filme> dramas = filmes.stream()
//				.filter(f-> "Drama".equals(f.getGenero()))
//				.collect(Collectors.toList());
		
		System.out.println("Dramas: ");
		filmes.stream()
				.filter(f-> "Drama".equals(f.getGenero()))
				.map(f -> f.getNome())
				.sorted()
				.forEach(System.out::println);
		
		
//		for(Filme f : dramas) {
//			System.out.println(f.getNome());	
//		}
	
		
		
		
		
		
	}

}
