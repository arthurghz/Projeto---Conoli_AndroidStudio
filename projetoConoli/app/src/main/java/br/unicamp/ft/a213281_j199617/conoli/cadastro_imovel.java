package br.unicamp.ft.a213281_j199617.conoli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.firestore.FirebaseFirestore;

import br.unicamp.ft.a213281_j199617.conoli.ui.home.HomeFragment;


public class cadastro_imovel extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance(); // objeto Firestore

    private RadioGroup admImovel, tipoImovel, tipoVaga, tipoQuarto;
    private EditText   preco;
    private CheckBox geladeira, maquinadelavar, fogao, microondas, televisao, wifi,
            garagem, mobilia, utensilio, interfone, arcondicionado, varanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_imovel);

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
        RadioButton selectedRadioButtonTipoImovel = (RadioButton) findViewById(idAdmImovel);
        valorTipoImovel = (String) selectedRadioButtonTipoImovel.getText();

        int idTipoVaga = tipoVaga.getCheckedRadioButtonId();
        RadioButton selectedRadioButtonTipoVaga = (RadioButton) findViewById(idAdmImovel);
        valorTipoVaga = (String) selectedRadioButtonTipoVaga.getText();

        int idTipoQuarto = tipoQuarto.getCheckedRadioButtonId();
        RadioButton selectedRadioButtonTipoQuarto = (RadioButton) findViewById(idAdmImovel);
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

    }

}
