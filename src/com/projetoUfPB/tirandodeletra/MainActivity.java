package com.projetoUfPB.tirandodeletra;

import com.example.classesGerenciadoras.Elemento;
import com.example.classesGerenciadoras.GerElemento;
import com.projetoUfPB.tirandodeletra.R.id;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private Button buttonElemento, buttonOk, buttonCorrige, buttonConfiguracao, buttonPontuacao;
	private EditText editTextPalavra;
	Button buttonsLetras[] = new Button[23];
	private GerElemento gerenteElementos;
	private Elemento elemento;
	private MediaPlayer musica,audioAcerto;
	private int contador = 0;
	

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        // texto
        editTextPalavra = (EditText) findViewById(R.id.editText1);
        editTextPalavra.setInputType(InputType.TYPE_NULL);//configura a não entrada do teclado virtual
        
      	// elemento
        buttonElemento = (Button) findViewById(R.id.button_Elemento);
      						
        // botão
        buttonOk = (Button) findViewById(R.id.button_OK);
                    
        //musica
           
        musica = MediaPlayer.create(this, R.raw.music_game);
        audioAcerto = MediaPlayer.create(this, R.raw.audio_acerto);
        
        buttonCorrige = (Button) findViewById(R.id.Button_Corrige);
        buttonConfiguracao = (Button) findViewById(R.id.Button_configuracao);
        buttonPontuacao = (Button) findViewById(R.id.button_pontuacao);
       
                
        findViewLetras(); // método que localiza as letras no xml
        
        //------------[listenes]-------------------            
		
		buttonOk.setOnClickListener(this); // 
						
		buttonCorrige.setOnClickListener(this);
		buttonConfiguracao.setOnClickListener(this);
				
		// listeners letras
        buttonsLetras[0].setOnClickListener(this);
		buttonsLetras[1].setOnClickListener(this);
		buttonsLetras[2].setOnClickListener(this);
		buttonsLetras[3].setOnClickListener(this);
		buttonsLetras[4].setOnClickListener(this);
		buttonsLetras[5].setOnClickListener(this);
		buttonsLetras[6].setOnClickListener(this);
		buttonsLetras[7].setOnClickListener(this);
		buttonsLetras[8].setOnClickListener(this);
		buttonsLetras[9].setOnClickListener(this);
		buttonsLetras[10].setOnClickListener(this);
		buttonsLetras[11].setOnClickListener(this);
		buttonsLetras[12].setOnClickListener(this);
		buttonsLetras[13].setOnClickListener(this);
		buttonsLetras[14].setOnClickListener(this);
		buttonsLetras[15].setOnClickListener(this);
		buttonsLetras[16].setOnClickListener(this);
		buttonsLetras[17].setOnClickListener(this);
		buttonsLetras[18].setOnClickListener(this);
		buttonsLetras[19].setOnClickListener(this);
		buttonsLetras[20].setOnClickListener(this);
		buttonsLetras[21].setOnClickListener(this);
		buttonsLetras[22].setOnClickListener(this);
		
		// Letras com Acentos  (Foram retiradas)
//		buttonsLetras[23].setOnClickListener(this);
//		buttonsLetras[24].setOnClickListener(this);
//		buttonsLetras[25].setOnClickListener(this);
//		buttonsLetras[26].setOnClickListener(this);
//		buttonsLetras[27].setOnClickListener(this);
//		buttonsLetras[28].setOnClickListener(this);
//		buttonsLetras[29].setOnClickListener(this);
//		buttonsLetras[30].setOnClickListener(this);
//		buttonsLetras[31].setOnClickListener(this);
//		buttonsLetras[32].setOnClickListener(this);
				
		configuracaoInicialJogo(); // método de configuração inicial para rodar o jogo		        
      
    }

	
	
	@Override
	public void onBackPressed() {
	       // Caso o botão back (retorno) do dispositivo seja acionado nada ocorrerá
	}

	@Override
	public void onClick(View arg0) {
		
		// caso o usuário toque nos demais buttons presentes na tela
		if((arg0.getId() == R.id.button_Elemento) || (arg0.getId() == R.id.button_OK) || (arg0.getId() == R.id.musica)  || (arg0.getId() == R.id.Button_Corrige) || (arg0.getId() == R.id.Button_configuracao)) {
			// não faça nada
		}
		else{
			editTextPalavra.append(arg0.getTag().toString());
		}		
		
		switch (arg0.getId()) {
		
			case R.id.Button_Corrige:// apagar letra da palavra
				if (editTextPalavra.getText().toString().length() > 0 ) {					
					editTextPalavra.setText(editTextPalavra.getText().toString().substring(0, editTextPalavra.getText().toString().length()-1));
				}	
				break;						
			case R.id.button_OK:							
				 verificarResposta(); // método que verifica a palavra
				 break;				 
			case R.id.Button_configuracao: // retornar para omenu de opções
				ExibeDialogConfiguraçao();
				break;
					 
		}		
	}
	
	public void iniciaElementos(){ // método que contém os elementos(imagens) que serão utilizadas para responder
			
			gerenteElementos = new GerElemento();
			gerenteElementos.adicionaElemento("gato",  R.drawable.gato);			
			gerenteElementos.adicionaElemento("coelho",  R.drawable.coelho);
			gerenteElementos.adicionaElemento("galinha",  R.drawable.galinha);
			gerenteElementos.adicionaElemento("coruja",  R.drawable.coruja);
				
	}
	
	public void capturaElementoAtual(){				
		elemento = gerenteElementos.getElemeto(); 
		
	}
	
	public Elemento verificaElemento(){
		return elemento; // Usado para verificar se o elemento retornado é diferente de null
	}
	
	public void carregaImagemElemento(){
		buttonElemento.setBackgroundResource(elemento.getEnderecoImagem()); // altera a imagem conforme o endereço retornado
		buttonElemento.setTag(elemento.getNome()); // altera o nome da tag do elemento conforme o nome retornado
		buttonElemento.setVisibility(buttonElemento.VISIBLE); // muda para vísivel a imagem do elemento
	}
	
	public void carregaImagemLetras() {
		//percorre o vetor de letras e compara a existência delas na nova palavra carregada na tela
		for (int i = 0; i < buttonsLetras.length; i++) {
			for (int j = 0; j < elemento.getNome().length(); j++) {
				if (buttonsLetras[i].getTag().toString().equals(elemento.getNome().charAt(j) + "")) {
					buttonsLetras[i].setVisibility(buttonsLetras[i].VISIBLE);
				}
			}
		}
	}
	
	private void defineMaximoCaracteres() {
		//configura o número máximo de caracteres da palavra
		int maxLength = elemento.getNome().toString().length();
		InputFilter[] fArray = new InputFilter[1];
		fArray[0] = new InputFilter.LengthFilter(maxLength);
		editTextPalavra.setText("");
		editTextPalavra.setFilters(fArray);
	}
	
	public void verificarResposta() {		
		
//		String n = editTextPalavra.getText().toString();
//		
//		
//		for (int j = 0; j < buttonElemento.getTag().toString().length(); j++) {
//			if (  n.get()   .equals(elemento.getNome().charAt(j) + "")) {
//				buttonsLetras[i].setVisibility(buttonsLetras[i].VISIBLE);
//			}
//		}
		
		
		if (editTextPalavra.getText().toString().equals(buttonElemento.getTag())) {
			audioAcerto.start();
			contador++;
			buttonPontuacao.setText(contador+"");
			preparaProximaJogada();						
	   	}
		else {
			editTextPalavra.setText("");
			ExibeDialogValidar();
		}
		
	}
	
	public void configuraLetrasInvisiveis(){
		for (int i = 0; i < buttonsLetras.length; i++) {
			buttonsLetras[i].setVisibility(buttonsLetras[i].INVISIBLE);
		}
	}
	
	public void tocarMusica(){
		musica.setLooping(true);
		musica.start();
	}
	
	protected void configuracaoInicialJogo() {
		// Prepara o jogo
		configuraLetrasInvisiveis(); // torna todas as letras invisiveis
		iniciaElementos(); // adiciona os elementos contidos no jogo
		capturaElementoAtual();	// busca o elemento
	    carregaImagemElemento(); // 
		carregaImagemLetras();
		defineMaximoCaracteres();
		tocarMusica();
	}
	
	protected void preparaProximaJogada(){
				
		configuraLetrasInvisiveis();
		capturaElementoAtual();	
		        
        if(verificaElemento() != null){
			
	        carregaImagemElemento();
	        carregaImagemLetras();
	        defineMaximoCaracteres();
		}
		else{
			carregaTelaFinal(); // finaliza o jogo
		}

	}
	
	protected void carregaTelaFinal(){
		musica.stop();
		startActivity(new Intent(MainActivity.this, FinalScreenActivity.class));
		finish();
	}
	
	 private void ExibeDialogValidar(){
		 // Responsável por emitir uma alertDialog personalizado 
	        final Dialog dialog = new Dialog(this);
	 
	        dialog.setContentView(R.layout.customdialog_validar);
	 
	        //define o título do Dialog
	        dialog.setTitle("AVISO");
	 
	        //instancia os objetos que estão no layout customdialog.xml
	        final Button confirmar = (Button) dialog.findViewById(R.id.btn_Confirmar);
	                	 
	        confirmar.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                               
	             //finaliza o dialog
	             dialog.dismiss();
	            }
	        });
	 	        	        	         
	        //exibe na tela o dialog
	     dialog.show();
	          
	}
	 
	 private void ExibeDialogConfiguraçao(){
		 // Responsável por emitir uma alertDialog personalizado 
	        final Dialog dialog = new Dialog(this);
	 
	        dialog.setContentView(R.layout.customdialog_configuracao);
	 
	        //define o título do Dialog
	        dialog.setTitle("CONFIGURAÇÃO");
	 
	        //instancia os objetos que estão no layout customdialog.xml
	        
	        final Button menu = (Button) dialog.findViewById(R.id.btn_menu);
	        // botão música
	        final Button buttonMusica = (Button) dialog.findViewById(R.id.musica);
	        
	        final Button sair = (Button) dialog.findViewById(R.id.btn_sair);
	                
	        menu.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	musica.stop(); 
					startActivity(new Intent(MainActivity.this, Menu_Activity.class));
					                               
	             //finaliza o dialog
	             dialog.dismiss();
	             finish();
	            }
	        });
	        
	        buttonMusica.setOnClickListener(new View.OnClickListener() {
	        	//Tocar Música ou Silenciar música		
	            public void onClick(View v) {	            	            
	            	if(buttonMusica.getTag().equals("tocando")){ //(caso a musica estiver tocando)
						silenciarMusica(0.0f,0.0f);		//para de tocar 
					}
					else if(buttonMusica.getTag().equals("silenciado")){;//(caso a musica estiver pausada)
						aumentarMusica(1.0f,1.0f);		//volta a tocar 
					}
	            }
	            
	            public void silenciarMusica(float volumeEsquerdo, float volumeDireito){
	        		buttonMusica.setTag("silenciado");
	        		buttonMusica.setBackgroundResource(R.drawable.sem_som);
	        		musica.setVolume(volumeEsquerdo, volumeDireito);
	        	}
	        	
	        	public void aumentarMusica(float volumeEsquerdo, float volumeDireito){
	        		buttonMusica.setTag("tocando");
	        		buttonMusica.setBackgroundResource(R.drawable.som);
	        		musica.setVolume(volumeEsquerdo, volumeDireito);
	        	}
	            
		    });
	        
	        sair.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {	            	            
	             //finaliza o dialog
	             dialog.dismiss();	             
	            }
	        });
	         
	        //exibe na tela o dialog
	     dialog.show();
	          
	}
	
	protected void findViewLetras(){
		
		 // letras        	               
        buttonsLetras[0] = (Button) findViewById(R.id.button_A);
        buttonsLetras[1] = (Button) findViewById(R.id.button_B);
        buttonsLetras[2] = (Button) findViewById(R.id.button_C);
        buttonsLetras[3] = (Button) findViewById(R.id.Button_D);
        buttonsLetras[4] = (Button) findViewById(R.id.Button_E);
        buttonsLetras[5] = (Button) findViewById(R.id.Button_F);
        buttonsLetras[6] = (Button) findViewById(R.id.button_G);
        buttonsLetras[7] = (Button) findViewById(R.id.button_H);
        buttonsLetras[8] = (Button) findViewById(R.id.Button_I);
        buttonsLetras[9] = (Button) findViewById(R.id.Button_J);
        buttonsLetras[10] = (Button) findViewById(R.id.Button_L);
        buttonsLetras[11] = (Button) findViewById(R.id.button_M);
        buttonsLetras[12] = (Button) findViewById(R.id.button_N);
        buttonsLetras[13] = (Button) findViewById(R.id.button_O);
        buttonsLetras[14] = (Button) findViewById(R.id.Button_P);
        buttonsLetras[15] = (Button) findViewById(R.id.Button_Q);
        buttonsLetras[16] = (Button) findViewById(R.id.Button_R);
        buttonsLetras[17] = (Button) findViewById(R.id.Button_S);
        buttonsLetras[18] = (Button) findViewById(R.id.Button_T);
        buttonsLetras[19] = (Button) findViewById(R.id.Button_U);
        buttonsLetras[20] = (Button) findViewById(R.id.Button_V);
        buttonsLetras[21] = (Button) findViewById(R.id.button_X);
        buttonsLetras[22] = (Button) findViewById(R.id.button_Z);
        
        //Letras com Acentos (Foram retiradas)
//        buttonsLetras[23] = (Button) findViewById(R.id.button_A_Acento_Agudo);
//        buttonsLetras[24] = (Button) findViewById(R.id.button_A_Acento_Circuflexo);
//        buttonsLetras[25] = (Button) findViewById(R.id.button_A_Acento_Til);
//        buttonsLetras[26] = (Button) findViewById(R.id.button_E_Acento_Agudo);
//        buttonsLetras[27] = (Button) findViewById(R.id.button_E_Acento_Circuflexo);        
//        buttonsLetras[28] = (Button) findViewById(R.id.Button_I_Acento_Agudo);
//        buttonsLetras[29] = (Button) findViewById(R.id.button_O_acento_Til);
//        buttonsLetras[30] = (Button) findViewById(R.id.button_O_acento_Circuflexo);
//        buttonsLetras[31] = (Button) findViewById(R.id.button_O_acento_Agudo);
//        buttonsLetras[32] = (Button) findViewById(R.id.Button_U_Acento_Agudo);
      		
	}
	
	
		
	
	

}


