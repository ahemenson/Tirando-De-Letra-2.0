package com.example.classesGerenciadoras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;



public class GerElemento {

	private List<Elemento> elementos;
	
	public GerElemento() {
		elementos = new ArrayList<Elemento>();
		
	}

	public void adicionaElemento(String nome, int enderecoImagem, int audioEmento) {

		Elemento elemento = new Elemento();
		elemento.setNome(nome);
		elemento.setEnderecoImagem(enderecoImagem);
		elemento.setAudioEmento(audioEmento);
		
		elementos.add(elemento);

	}


	
	public Elemento getElemeto(){
		
		Elemento elemento = null;
		
		if(elementos.isEmpty()){
			elemento = null;			
		}
		else{
			elemento = elementos.get(0);
			elementos.remove(0);
		}				
		return elemento;
		
	
	}

}
