package com.projetoUfPB.tirandodeletra;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FinalScreenActivity extends Activity  implements OnClickListener {
	
	private Button buttonSair; 
	private TextView textNome;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_screen);
		
		
		buttonSair = (Button) findViewById(R.id.button_sair);
		textNome = (TextView) findViewById(R.id.text_nomeDoJogador);
		
		textNome.setText(LoginActivity.nome);
		
				
		buttonSair.setOnClickListener(this);
		
	}

	@Override
	public void onBackPressed() {
	       // Caso o botão back (retorno) do dispositivo seja acionado nada ocorrerá
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch (arg0.getId()) {
		
		case R.id.button_sair:// apagar letra da palavra
			finish();
			System.exit(0);
			break;			
	    }

   }
}
