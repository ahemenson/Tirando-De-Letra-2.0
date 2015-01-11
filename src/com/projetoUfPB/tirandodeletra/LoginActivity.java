package com.projetoUfPB.tirandodeletra;

import com.projetoUfPB.tirandodeletra.R.id;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener{
	
	private String nome;
	private Button ok;
	private EditText editextNome;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		ok = (Button) findViewById(id.ok);
		editextNome = (EditText) findViewById(R.id.editText_nome);
		ok.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {			
		 	case R.id.ok:
		 		nome = editextNome.getText().toString();
				startActivity(new Intent(LoginActivity.this, MainActivity.class));
				finish();
				break;
		}
	}
}
