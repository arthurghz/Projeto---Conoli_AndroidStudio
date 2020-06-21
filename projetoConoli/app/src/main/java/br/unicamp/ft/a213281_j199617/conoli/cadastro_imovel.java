package br.unicamp.ft.a213281_j199617.conoli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;

import br.unicamp.ft.a213281_j199617.conoli.ui.home.HomeFragment;


public class cadastro_imovel extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_imovel);
    }

    public void navigationDrawer (View View){
        Intent intent2 = new Intent(getApplicationContext(), navigationDrawer.class);
        startActivity(intent2);
    }



}
