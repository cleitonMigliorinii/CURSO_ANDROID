package br.edu.utfpr.calcularimc_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;

    private TextView tvResultado;

    private Button btnCalcular;

    private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);

        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById((R.id.btnLimpar));

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (  etPeso.getText().toString().equals( "" ) ) {
                    etPeso.setError( "Campo peso deve ser preenchido" );
                    etPeso.requestFocus();
                    return;
                }

                if (  etAltura.getText().toString().equals( "" ) ) {
                    etAltura.setError( "Campo altura deve ser preenchido" );
                    etAltura.requestFocus();
                    return;
                }


                double peso = Double.parseDouble(etPeso.getText().toString());
                double altura = Double.parseDouble(etAltura.getText().toString());

                double imc =  peso /(Math.pow(altura, 2));

                DecimalFormat df = new DecimalFormat("0.0");

                tvResultado.setText(String.valueOf(df.format(imc)));
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etPeso.setText("");
                etAltura.setText("");

                tvResultado.setText("0.0");
                etPeso.requestFocus();
            }
        });

        btnLimpar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(MainActivity.this, "Limpa os componentes", Toast.LENGTH_LONG).show();

                return true;
            }
        });


    }


}