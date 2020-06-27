package br.unicamp.ft.a213281_j199617.conoli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.JsonArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import br.unicamp.ft.a213281_j199617.conoli.ui.home.HomeFragment;


public class cadastro_imovel extends AppCompatActivity {

    private static final String TAG = "STATUS_INSERT";
    FirebaseAuth mAuth;

    // Accessar a cloud firestore a partir do formulário de cadastro
    FirebaseFirestore db = FirebaseFirestore.getInstance(); // objeto Firestore

    private RadioGroup admImovel, tipoImovel, tipoVaga, tipoQuarto;
    private EditText   preco;
    private CheckBox geladeira, maquinadelavar, fogao, microondas, televisao, wifi,
            garagem, mobilia, utensilio, interfone, arcondicionado, varanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_imovel);

        mAuth = FirebaseAuth.getInstance();

        admImovel      = findViewById(R.id.radioGroupAdmImovel);
        tipoImovel     = findViewById(R.id.radioGroupTipoImovel);
        tipoVaga       = findViewById(R.id.radioGroupTipoVaga);
        tipoQuarto     = findViewById(R.id.radioGroupTipoQuarto);
        preco          = findViewById(R.id.preco);
        geladeira      = findViewById(R.id.checkBox_geladeira);
        maquinadelavar = findViewById(R.id.checkBox_maquinadelavar);
        fogao          = findViewById(R.id.checkBox_fogao);
        microondas     = findViewById(R.id.checkBox_microondas);
        televisao      = findViewById(R.id.checkBox_televisao);
        wifi           = findViewById(R.id.checkBox_wifi);
        garagem        = findViewById(R.id.checkBox_garagem);
        mobilia        = findViewById(R.id.checkBox_mobilia);
        utensilio      = findViewById(R.id.checkBox_utensilio);
        interfone      = findViewById(R.id.checkBox_interfone);
        arcondicionado = findViewById(R.id.checkBox_arcondicionado);
        varanda        = findViewById(R.id.checkBox_varanda);

    }

    public void registrarImovel (View View){ //função do botão que coleta os dados do formulario

        String valorAdmImovel, valorTipoImovel, valorTipoVaga, valorTipoQuarto;
        String valorPreco = preco.getText().toString();

        int idAdmImovel = admImovel.getCheckedRadioButtonId();
        RadioButton selectedRadioButtonAdm = (RadioButton) findViewById(idAdmImovel);
        valorAdmImovel = (String) selectedRadioButtonAdm.getText();

        int idTipoImovel = tipoImovel.getCheckedRadioButtonId();
        RadioButton selectedRadioButtonTipoImovel = (RadioButton) findViewById(idTipoImovel);
        valorTipoImovel = (String) selectedRadioButtonTipoImovel.getText();

        int idTipoVaga = tipoVaga.getCheckedRadioButtonId();
        RadioButton selectedRadioButtonTipoVaga = (RadioButton) findViewById(idTipoVaga);
        valorTipoVaga = (String) selectedRadioButtonTipoVaga.getText();

        int idTipoQuarto = tipoQuarto.getCheckedRadioButtonId();
        RadioButton selectedRadioButtonTipoQuarto = (RadioButton) findViewById(idTipoQuarto);
        valorTipoQuarto = (String) selectedRadioButtonTipoQuarto.getText();

        boolean checkboxGeladeira = geladeira.isChecked();
        boolean checkboxMaquinaDeLavar = maquinadelavar.isChecked();
        boolean checkboxFogao = fogao.isChecked();
        boolean checkboxMicroondas = microondas.isChecked();
        boolean checkboxTelevisao = televisao.isChecked();
        boolean checkboxWifi = wifi.isChecked();
        boolean checkboxGaragem = garagem.isChecked();
        boolean checkboxMobilia = mobilia.isChecked();
        boolean checkboxUtensilio = utensilio.isChecked();
        boolean checkboxInterfone = interfone.isChecked();
        boolean checkboxArCondicionado = arcondicionado.isChecked();
        boolean checkboxVaranda = varanda.isChecked();

        Map<String, Object> imovel = new HashMap<>();
        imovel.put("usuario_dono", Objects.requireNonNull(mAuth.getCurrentUser()).getUid());
        imovel.put("administracao", valorAdmImovel);
        imovel.put("tipo_imovel", valorTipoImovel);
        imovel.put("tipo_vaga", valorTipoVaga);
        imovel.put("tipo_quarto", valorTipoQuarto);
        imovel.put("preco", valorPreco);
        imovel.put("geladeira", checkboxGeladeira);
        imovel.put("maquina_de_lavar", checkboxMaquinaDeLavar);
        imovel.put("fogao", checkboxFogao);
        imovel.put("microondas", checkboxMicroondas);
        imovel.put("televisao", checkboxTelevisao);
        imovel.put("wifi", checkboxWifi);
        imovel.put("garagem", checkboxGaragem);
        imovel.put("mobilia", checkboxMobilia);
        imovel.put("utensilio", checkboxUtensilio);
        imovel.put("interfone", checkboxInterfone);
        imovel.put("ar_condicionado", checkboxArCondicionado);
        imovel.put("varanda", checkboxVaranda);


        // Add a new document with a generated ID
        db.collection("imoveis")
                .add(imovel)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "Documento adicionado com o ID: " + documentReference.getId());

                        Toast.makeText(getApplicationContext(),
                                "Imóvel cadastrado com sucesso!", Toast.LENGTH_LONG).show();

                        Intent navigation = new Intent(getApplicationContext(), navigationDrawer.class);
                        startActivity(navigation);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);

                        Toast.makeText(getApplicationContext(),
                                "Por favor, verifique os campos e tente novamente", Toast.LENGTH_LONG).show();
                    }
                });

    }

}
