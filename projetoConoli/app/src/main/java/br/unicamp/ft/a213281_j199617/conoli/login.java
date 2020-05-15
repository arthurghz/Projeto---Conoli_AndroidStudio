package br.unicamp.ft.a213281_j199617.conoli;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class login extends AppCompatActivity {

    private Spinner spinner;
    private EditText editText;

    EditText numero;
    EditText dd;
    String codeSent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        dd = findViewById(R.id.codigo_area);
        numero = findViewById(R.id.numberphone);


        findViewById(R.id.requisitar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendVerificationcode();
                Intent intent1 = new Intent(getApplicationContext(), sms_receiver.class);
                Log.i(codeSent,"codigo");
                intent1.putExtra("Auth", (FirebaseAuth)mAuth );
                intent1.putExtra("Codesent", codeSent);
                startActivity(intent1);
            }
        });

    }

    private void sendVerificationcode() {
        //String phone =
       String  phone = "+55" + dd.getText().toString() + numero.getText().toString();
        Log.i(phone, "Celular");
        if(phone.isEmpty()){
            numero.setError("BOTA O NUMERO POHA");
            return;
        }

        if(phone.length() < 9 ){
            numero.setError("COLOCA CERTO KRLH0");
            return;
        }


        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks );   // OnVerificationStateChangedCallbacks


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
};


