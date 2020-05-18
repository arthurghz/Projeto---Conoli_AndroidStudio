package br.unicamp.ft.a213281_j199617.conoli.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.unicamp.ft.a213281_j199617.conoli.R;
import br.unicamp.ft.a213281_j199617.conoli.cadastro_imovel;

public class imoveis_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imoveis_1);
    }

    public void cadastro(View View){
        Intent intent1 = new Intent(getApplicationContext(), cadastro_imovel.class);
        startActivity(intent1);
    }

}
