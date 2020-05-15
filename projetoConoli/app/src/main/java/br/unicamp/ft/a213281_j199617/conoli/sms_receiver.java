package br.unicamp.ft.a213281_j199617.conoli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;


public class sms_receiver extends AppCompatActivity{

    String codeSent;
    EditText resposta;
    FirebaseAuth mAuth;
    String CodeSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent it = getIntent();

        //Recuperei a string da outra activity
        CodeSent = it.getStringExtra("Codesent");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_receiver);
        findViewById(R.id.requisitar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resposta = findViewById(R.id.codeverify);
                Log.i(codeSent, "Celular");
                Log.i(String.valueOf(resposta), "Celular");

                verifyCode();

            }
        });
    };


    private void verifyCode(){
            String code = resposta.getText().toString();
        Log.i(code, "Celular");
        Log.i(codeSent, "Celular2");
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
            signInWithPhoneAuthCredential(credential);
        }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //here you can open new activity
                                Toast.makeText(getApplicationContext(),
                                        "Login Successfull", Toast.LENGTH_LONG).show();
                            } else {
                                if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                    Toast.makeText(getApplicationContext(),
                                            "Incorrect Verification Code ", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    });

}



}
