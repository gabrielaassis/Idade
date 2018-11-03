package com.example.leandroassis.idade;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private EditText edtText;
    private TextToSpeech falar;
    private ImageView zezinho;
    private int resultado;
    private Locale localeBR = new Locale("pt","br");
    private int[] imagens = {R.drawable.crianca,R.drawable.adolescente,R.drawable.adulto};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        edtText = (EditText) findViewById(R.id.edtText1);
        zezinho = (ImageView) findViewById(R.id.zezinho);


        falar = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int estado) {
                if(estado==TextToSpeech.SUCCESS){
                    resultado= falar.setLanguage(localeBR);
                } else{
                    Toast.makeText(getApplicationContext(), "Recurso de Voz nao suportado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String i = edtText.getText().toString();
                String result;
                String numerovalido = "Digite um número válido.";
                if(i.isEmpty()==true){
                    Toast.makeText(MainActivity.this, "Digite um numero valido", Toast.LENGTH_LONG).show();
                    falar.speak(numerovalido,TextToSpeech.QUEUE_FLUSH,null    );

                }else{
                    int u = Integer.parseInt(i);
                    if(u<=12){
                        result = "Criança";
                        zezinho.setImageResource(imagens[0]);
                        zezinho.setVisibility(View.VISIBLE);
                    }else if(u<18){
                        result = "Adolescente";
                        zezinho.setImageResource(imagens[1]);
                        zezinho.setVisibility(View.VISIBLE);
                    }else{
                        result = "Adulto";
                        zezinho.setImageResource(imagens[2]);
                        zezinho.setVisibility(View.VISIBLE);
                    }
                    esconderteclas();
                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
                    edtText.setText("");
                    falar.speak(result,TextToSpeech.QUEUE_FLUSH,null    );
                }
            }
        });
    }

    public void esconderteclas (){
        InputMethodManager teclado = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        teclado.toggleSoftInput(0,0);
    }
}