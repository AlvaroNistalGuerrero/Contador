package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import android.view.TextureView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

import java.math.BigInteger;
import java.text.BreakIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    TextView contador;
    Button botonMejora1;
    ImageView pokeball_image;

    BigInteger cont = BigInteger.ZERO;
    int valorClick = 1;
    int costeBillete = 100;
    int incremento = 1;
    ExecutorService executor = Executors.newSingleThreadExecutor();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokeball_image=(ImageView)findViewById(R.id.pokeball_image);
        botonMejora1=(Button)findViewById(R.id.button1);
        contador = (TextView) findViewById(R.id.textcontador);
        contador.setText("" + cont);
        segundero();
    }
    public void irMenuInicio(View v){
//        Intent i = new Intent(this, PantallaInicio.class);    // Intent se usa para hacer un salto de actividad
//        startActivity(i);
        finish();
    }

    public void sumar(View v) {
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);

        pokeball_image.startAnimation(fade_in);
        cont = cont.add(BigInteger.valueOf(valorClick));
        añadeTexto();

        // contador.setText("" + cont); al concatenar un String a un int,
        // se crea un String de ambos
    }


    public void mejora1(View v) {
        if (cont.compareTo(BigInteger.valueOf(costeBillete) )>= 0) {
            cont = cont.subtract(BigInteger.valueOf(costeBillete));;
            valorClick = valorClick*2;
            contador.setText(""+ cont);
            costeBillete = costeBillete + 20;
            botonMejora1.setText(costeBillete + " bitcoins");
            añadeTexto();
        }
    }
    public String añadeTexto(){
        String añadeTexto;
        if (cont.compareTo(BigInteger.valueOf(1000)) >= 0) {
            BigInteger mil = BigInteger.valueOf(1000);
            BigInteger cantidad = cont.divide(mil);
            añadeTexto = cantidad + " K";
            if(cont.compareTo(new BigInteger("1000000"))>=0 && cont.compareTo(new BigInteger("99999999999"))<=0){      // Si no
                BigInteger Mill = new BigInteger("1000000");
                BigInteger cantidad_2 = cont.divide(Mill);
                añadeTexto = cantidad_2 + " Mill";
            }
                if(cont.compareTo(new BigInteger("1000000000000"))>= 0){
                    BigInteger Bill = new BigInteger("1000000000000");
                    BigInteger cantidad_3 = cont.divide(Bill);
                    añadeTexto = cantidad_3 + " Bill";
            }
        } else {
            añadeTexto = cont.toString();
        }
        contador.setText(añadeTexto);
        return añadeTexto;
    }
    public void segundero(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cont = cont.add(BigInteger.valueOf(incremento));

                handler.post(() -> {
                    contador.setText(añadeTexto());
                });
            }
        });
        }
}
