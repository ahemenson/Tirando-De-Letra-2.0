package com.example.classesGerenciadoras;


public class Elemento {
	
	private String nome;
	private int enderecoImagem, audioElemento;
		
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

	public int getEnderecoImagem() {
		return this.enderecoImagem;
	}

	public void setEnderecoImagem(int enderecoImagem) {
		this.enderecoImagem = enderecoImagem;
	}

	public void setAudioEmento(int audioElemento) {
		this.audioElemento = audioElemento;
	}
	public int getAudioElemento(){
		return this.audioElemento;
	}
	
}
