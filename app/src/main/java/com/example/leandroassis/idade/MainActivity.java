package com.example.leandroassis.idade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        edtText = (EditText) findViewById(R.id.edtText1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String i = edtText.getText().toString();
                String result;
                if(i.isEmpty()==true){
                    Toast.makeText(MainActivity.this, "Digite um numero valido", Toast.LENGTH_LONG).show();
                }else{
                    int u = Integer.parseInt(i);
                    if(u<=12){
                        result = "Criança";
                    }else if(u<=18){
                        result = "Adolescente";
                    }else{
                        result = "Adulto";
                    }
                    esconderteclas();
                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
                    edtText.setText("");
                }
            }
        });
    }

    public void esconderteclas (){
        InputMethodManager teclado = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        teclado.toggleSoftInput(0,0);
    }

}