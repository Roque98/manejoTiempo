package com.example.manejotiempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // Logica
    private int contadorSegundos = 0;
    private int valorMaximoContadorSegundos = 50;

    private int contadorAux = 0;
    private boolean NoPausa = true;

    private int numeroIntervalosDeEsperar = (valorMaximoContadorSegundos / 10);
    private int tiempoEsperaEntreIntervalosEnSegundos = 5;

    private int tiempoEsperaRealEnSegundos = valorMaximoContadorSegundos + (numeroIntervalosDeEsperar * tiempoEsperaEntreIntervalosEnSegundos);
    private int tiempoEsperaRealEnMilisSegundos = tiempoEsperaRealEnSegundos * 1000;

    // Contador
    TextView tvContador;
    TextView tvContadorAux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Componentes
        tvContador = findViewById(R.id.tvContador);
        tvContadorAux = findViewById(R.id.tvContador2);

        CountDownTimer countDownTimer = new CountDownTimer((tiempoEsperaRealEnMilisSegundos+100) + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinish) {

                if(NoPausa){
                    contadorSegundos++;
                    tvContador.setText(contadorSegundos+"");


                    if(contadorSegundos % 10 == 0 ){
                        NoPausa = false;
                    }
                } else {
                    contadorAux++;
                    tvContadorAux.setText(contadorAux+"");

                    if(contadorAux == 5){
                        NoPausa = true;
                        contadorAux = 0;
                        tvContadorAux.setText(contadorAux+"");
                    }
                }
            }

            @Override
            public void onFinish() {

            }
        };

        countDownTimer.start();
    }
}
