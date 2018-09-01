package appfrasesdodia.com.br.frasesdodia;

import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgInspiracao;
    private Button btnNovaFrase;
    private TextView lblFraseDia;
    private String[] frases;

    int fraseEscolhida2 = 0;

    private int[] imagens = {R.drawable.sun1, R.drawable.sun2, R.drawable.sun3, R.drawable.sun4, R.drawable.sun5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgInspiracao = (ImageView) findViewById(R.id.imgInspiracao);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            @Override
            public void run() {
                imgInspiracao.setImageResource(imagens[i]);
                i++;
                if(i > imagens.length - 1){
                    i = 0;
                }
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);

        lblFraseDia = (TextView) findViewById(R.id.lblFraseDia);
        frases = getResources().getStringArray(R.array.frasesdodia);
        btnNovaFrase = (Button) findViewById(R.id.btnNovaFrase);
        btnNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int fraseEscolhida = random.nextInt(frases.length);

                if (fraseEscolhida != fraseEscolhida2){
                    lblFraseDia.setText(frases[fraseEscolhida]);
                    fraseEscolhida2 = fraseEscolhida;
                } else {
                    while (fraseEscolhida == fraseEscolhida2) {
                        fraseEscolhida = random.nextInt(frases.length);
                    }
                    lblFraseDia.setText(frases[fraseEscolhida]);
                    fraseEscolhida2 = fraseEscolhida;
                }
            }
        });

    }
}
