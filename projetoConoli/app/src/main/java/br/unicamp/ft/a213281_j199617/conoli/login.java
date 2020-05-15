package br.unicamp.ft.a213281_j199617.conoli;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class login extends AppCompatActivity {

    private Spinner spinner;
    private EditText editText;
    FirebaseAuth mAuth;
    EditText numero;
    EditText dd;
    String codeSent;
    EditText codigo;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        dd = findViewById(R.id.codigo_area);
        codigo = findViewById(R.id.codeverify);
        numero = findViewById(R.id.numberphone);
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            Log.d("AUTH", "ESTÁ LOGADO COMO  - TROCA DE INTENT:" + user.getUid());
            //troca DE INTENT SE JA TIVER LOGADO
        } else {
            Log.d("AUTH", "NAO ESTÁ LOGADO ");
        }
        findViewById(R.id.requisitar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendVerificationCode();
                Toast.makeText(getApplicationContext(),
                        "Seu código foi enviado, aguarde alguns segundos!", Toast.LENGTH_LONG).show();
            }
        });


        findViewById(R.id.verify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifySignInCode();
            }
        });
    }

    private void verifySignInCode(){
        String code = codigo.getText().toString();

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    "LOGIN BEM SUCEDIDOD POHAAAAAAAA", Toast.LENGTH_LONG).show();
                            Intent welcome = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(welcome);
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(getApplicationContext(),
                                        "COLOCA CERTO O BAGULHO KRLH0 ", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }

    private void sendVerificationCode(){

      String DDD = dd.getText().toString();
      String  phone = "+55" + dd.getText().toString() + numero.getText().toString();
        if(DDD.isEmpty()){
            Log.i(phone,"numero");
            numero.setError("Por favor, informar o DDD");
            numero.requestFocus();
            return;
        }
        if(phone.isEmpty()){
            Log.i(phone,"numero");
            numero.setError("Por favor, informar o número");
            numero.requestFocus();
            return;
        }

        if(phone.length()<8 ){
            numero.setError("Por favor, informar um número váldio");
            numero.requestFocus();
            return;
        }

        Log.i("entrou","numro");
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }



    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            codeSent = s;
        }
    };


}


