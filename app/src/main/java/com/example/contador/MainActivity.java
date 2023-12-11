package com.example.contador;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity  {

    TextView contador;
    Button botonMejora1;
    //Button buttonSalir;
    ImageView pokeball_image;
    BigInteger cont = BigInteger.ZERO;
    int valorClick = 1;
    int costeBillete = 100;
    int incremento = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokeball_image = (ImageView) findViewById(R.id.pokeball_image);
        botonMejora1 = (Button) findViewById(R.id.boton1);
        contador = (TextView) findViewById(R.id.textcontador);
        //buttonSalir = (Button) findViewById(R.id.buttonSalir);
        contador.setText("" + cont);
        segundero();
    }
    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            (result) -> {
                if (result.getResultCode() == RESULT_OK) {
                    String mejora = result.getData().getStringExtra("mejora");
                    switch (mejora) {
                        case "Multi":
                            mejora1();
                            break;
                    }
                }
            }
    );
    public void IrMenuDeMejoras(View v) {
        Intent intent = new Intent(this, MenuDeMejoras.class);
        intent.putExtra("pts", contador.getText());
        intent.putExtra("valorClick", valorClick);
        intent.putExtra("cont", cont);

        launcher.launch(intent);
        //startActivity(intent);

//        startActivityForResult(intent, 100);
//        intent.putExtra("update", botonMejora1.getText());


    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == 100) {
//            if (resultCode == Activity.RESULT_OK) {
//                Bundle dt = data.getExtras();
//                contador.setText(dt.getString("mj"));
//            }
//        }
//    }

    public void irRecycledView(View v) {
        Intent i = new Intent(this, Recycled_vista.class);    // Intent se usa para hacer un salto de actividad
        startActivity(i);
    }



    public void sumar(View v) {
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);

        pokeball_image.startAnimation(fade_in);
        cont = cont.add(BigInteger.valueOf(valorClick));
        añadeTexto();

    }
    
    public void mejora1() {
        if (cont.compareTo(BigInteger.valueOf(costeBillete)) >= 0) {
            cont = cont.subtract(BigInteger.valueOf(costeBillete));
            valorClick = valorClick * 2;
            contador.setText("" + cont);
            costeBillete = costeBillete + 20;
//          botonMejora1.setText(costeBillete + " pokemons");
            añadeTexto();
        }

    }

    public String añadeTexto() {
        String text = " ";
        if (cont.compareTo(BigInteger.valueOf(1000)) >= 0) {
            BigInteger mil = BigInteger.valueOf(1000);
            BigInteger cantidad = cont.divide(mil);
            text = cantidad + " K";
        }
        if (cont.compareTo(new BigInteger("1000000")) >= 0 && cont.compareTo(new BigInteger("99999999999")) <= 0) {     // Si no
            BigInteger Mill = new BigInteger("1000000");
            BigInteger cantidad_2 = cont.divide(Mill);
            text = cantidad_2 + " Mill";
        }
        if (cont.compareTo(new BigInteger("1000000000000")) >= 0) {
            BigInteger Bill = new BigInteger("1000000000000");
            BigInteger cantidad_3 = cont.divide(Bill);
            text = cantidad_3 + " Bill";

        } else {
            text = cont.toString();
        }
        contador.setText(text);
        return text;
    }

    public void segundero() {
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

    /*
    Para mi barramenu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.barramenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int ns = item.getItemId();
        float valor;
        if (ns == R.id.mp1) {
            valor = contador.getTextSize();
            valor = valor + 20;
            contador.setTextSize(TypedValue.COMPLEX_UNIT_PX, valor);
            return true;
        } else if (ns == R.id.mp2) {
            valor = contador.getTextSize();
            valor = valor - 20;
            contador.setTextSize(TypedValue.COMPLEX_UNIT_PX, valor);
            return true;
        } else if (ns == R.id.mp3) {
            finish();
            return true;
        } else if (ns == R.id.mp4) {
            contador.setTextColor(Color.RED);
            return true;
        } else if (ns == R.id.mp5) {
            contador.setTextColor(Color.YELLOW);
            return true;
        } else if (ns == R.id.mp6) {
            contador.setTextColor(Color.WHITE);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    //Login y resgistro mas progreso con un boton de guardar que te lo guarde
}
