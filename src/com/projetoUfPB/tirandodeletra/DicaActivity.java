package com.projetoUfPB.tirandodeletra;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DicaActivity extends Activity implements OnClickListener {
	
	GifView2 gifView2;
	Button botao_sair;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dica);
		
		gifView2 = (GifView2) findViewById(R.id.gif_view2);
		
		botao_sair = (Button) findViewById(R.id.button_sair);
		
		botao_sair.setOnClickListener(this);
		
		
	}

	@Override
	public void onBackPressed() {
	       // Caso o botão back (retorno) do dispositivo seja acionado nada ocorrerá
	}

	@Override
	public void onClick(View arg0) {
		
		 switch (arg0.getId()) {	
		
		  	case R.id.button_sair:			  		
		  		startActivity(new Intent(DicaActivity.this, Menu_Activity.class));
		  		finish();	
		  	break;
		 }
		 
	}

}
