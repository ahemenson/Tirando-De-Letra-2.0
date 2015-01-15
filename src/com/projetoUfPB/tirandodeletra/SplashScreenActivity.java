package com.projetoUfPB.tirandodeletra;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashScreenActivity extends Activity {
	
	GifView gifView;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		gifView = (GifView) findViewById(R.id.gif_view);
		
		Thread time = new Thread(){

			public void run() {
				try{
					sleep(8000);
				}
				catch(InterruptedException e){
					e.getStackTrace();
				}
				finally{
					startActivity(new Intent(SplashScreenActivity.this,Menu_Activity.class));
					finish();
				}
			}
			
		};
		time.start();
		
	}

	@Override
	public void onBackPressed() {
	       // Caso o botão back (retorno) do dispositivo seja acionado nada ocorrerá
	}

}
