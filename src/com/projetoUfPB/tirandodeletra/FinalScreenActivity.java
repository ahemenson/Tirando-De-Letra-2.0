package com.projetoUfPB.tirandodeletra;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class FinalScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_screen);
	}

	@Override
	public void onBackPressed() {
	       // Caso o botão back (retorno) do dispositivo seja acionado nada ocorrerá
	}

}
