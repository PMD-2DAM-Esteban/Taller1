package pmdm.esteban.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
private MediaPlayer sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Bloquea la orientacion de pantalla a solo PORTRAIT no LAND


        Thread time = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    //play sonido

                    sonido= MediaPlayer.create(getApplicationContext(), R.raw.pato);
                    sonido.start();
                    sleep(5000);


                }catch (InterruptedException e){

                }finally {
                    startActivity(new Intent("pmdm.esteban.taller1.STARTINGPOINT"));
                }
            }
        };

        time.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        sonido.release();
        finish();
    }
}