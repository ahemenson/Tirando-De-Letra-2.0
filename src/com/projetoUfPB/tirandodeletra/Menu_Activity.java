package com.projetoUfPB.tirandodeletra;

import com.projetoUfPB.tirandodeletra.R.id;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Menu_Activity extends Activity implements OnClickListener {
	
	private Button buttonJogo, buttonInstrucao, buttonSair;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_);
		
		buttonJogo = (Button) findViewById(id.button_Jogar);
		buttonInstrucao = (Button) findViewById(id.button_Instrucoes);
		buttonSair = (Button) findViewById(id.button_Sair);
		
		buttonJogo.setOnClickListener(this);
		buttonInstrucao.setOnClickListener(this);
		buttonSair.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_menu_, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		 switch (arg0.getId()) {			
			 case R.id.button_Jogar:
				startActivity(new Intent(Menu_Activity.this, MainActivity.class));
				finish();
				break;
				
			 case R.id.button_Sair:			
				 finish();
				 System.exit(0);

		 }
		
	}

}
