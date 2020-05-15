package br.unicamp.ft.a213281_j199617.projetoconoli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;


public class sms_receiver extends AppCompatActivity{

    String codeSent;
    EditText resposta;
    FirebaseAuth mAuth;
    private String CodeSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        resposta = findViewById(R.id.resposta_sms);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_receiver);

        findViewById(R.id.requisitar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyCode();
            }
        });

    };


    private void verifyCode(){
            String code = resposta.getText().toString();
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


     PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {

            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                CodeSent = s;
            }


    };

}
