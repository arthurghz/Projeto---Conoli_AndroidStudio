package br.unicamp.ft.a213281_j199617.conoli;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class login extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText numero;
    EditText dd;
    String codeSent;
    EditText codigo;
    PhoneAuthProvider.ForceResendingToken reenviarToken;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //declaracao das variaveis de autenticacao firebase
        mAuth = FirebaseAuth.getInstance();
        //FirebaseUser user = mAuth.getCurrentUser();

        //declaracao das variaveis de validacao do numero com a api firebase
        dd = findViewById(R.id.codigo_area);
        numero = findViewById(R.id.numberphone);
        codigo = findViewById(R.id.codeverify);


        //verificacao do status do usuario, se já está logado
        /*if (user != null) {
            Log.d("AUTH", "ESTÁ LOGADO COMO  - TROCA DE INTENT:" + user.getUid());
        }
        else {
            Log.d("AUTH", "NAO ESTÁ LOGADO ");
        }*/

        //click listener que verifica o clique para gerar um código para o numero
        findViewById(R.id.requisitar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendVerificationCode();
                Toast.makeText(getApplicationContext(),
                        "Seu código foi enviado, aguarde alguns segundos!", Toast.LENGTH_LONG).show();
            }
        });

        //click listener que verifica o codigo inserido com o gerado
        findViewById(R.id.verify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifySignInCode();
            }
        });
    }

    //funcao que verifica o codigo gerado com a credencial gerada pelo firebase
    private void verifySignInCode(){
        String code = codigo.getText().toString();

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signInWithPhoneAuthCredential(credential);
    }

    //funcao que verifica a tentativa de autenticacao com o codigo enviado
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.i("Passou da PhoneAuth", "Passou da PhoneAuth");
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    "LOGIN BEM SUCEDIDO - Seja bem vindo!", Toast.LENGTH_LONG).show();
                            Intent navigation = new Intent(getApplicationContext(), navigationDrawer.class);
                            startActivity(navigation);
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(getApplicationContext(),
                                        "O Código ou o número inserido não verificam", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }


    private void sendVerificationCode(){

        String DDD = dd.getText().toString();
        String  phone = "+55" + dd.getText().toString() + numero.getText().toString().trim();

        if(DDD.isEmpty()){
            Log.i(phone,"dddEmpty");
            numero.setError("Por favor, informar o DDD");
            numero.requestFocus();
            return;
        }
        if(phone.isEmpty()){
            Log.i(phone,"numeroEmpty");
            numero.setError("Por favor, informar o número");
            numero.requestFocus();
            return;
        }
        if(phone.length()<8 ){
            numero.setError("Por favor, informar um número válido");
            numero.requestFocus();
            return;
        }

        Log.i(phone, "numero");

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,                 // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,      // Unit of timeout
                this,          // Activity (for callback binding)
                mCallbacks);           // OnVerificationStateChangedCallbacks

    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken token) {
            super.onCodeSent(s, token);
            codeSent = s;
            reenviarToken = token;
            Log.i("código", s);
        }
    };

}


