package br.unicamp.ft.a213281_j199617.conoli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText editText;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void login(View View){
        Intent intent1 = new Intent(getApplicationContext(), cadastro_imovel.class);
        startActivity(intent1);
    }
}
