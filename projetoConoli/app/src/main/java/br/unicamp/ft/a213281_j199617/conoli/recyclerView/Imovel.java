package br.unicamp.ft.a213281_j199617.conoli.recyclerView;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import br.unicamp.ft.a213281_j199617.conoli.R;

public class Imovel {


    static ArrayList<Imovel> imoveis = new ArrayList<>();
    private static final String TAG = "Status consulta";

    private String usuario_dono, administracao, tipo_imovel, tipo_vaga, tipo_quarto, preco;
    private Boolean geladeira, maquina_de_lavar, fogao, microondas, televisao, wifi, garagem, mobilia,
    utensilio, interfone, ar_condicionado, varanda;

    public Imovel() {
        // Não é definido um construtor pelo fato do POJO object que é retornado na conversão do
        // documento (firebase) para o objeto (Imovel) não possuir argumentos
    }

    public static Imovel[] getImoveis(Context context){

        readData(new FirestoreCallback() {
            @Override
            public void onCallback(ArrayList<Imovel> imoveis) {
                Imovel [] imoveisArray = imoveis.toArray(new Imovel[imoveis.size()]);
                Log.d("StatusInnerCallBack", Arrays.toString(imoveisArray));
            }
        });

        Log.d("StatusOutter", String.valueOf(imoveis));
        return imoveis.toArray(new Imovel[imoveis.size()]);

    }

    public static void readData(final FirestoreCallback firestoreCallback){

        FirebaseAuth mAuth = FirebaseAuth.getInstance(); //verificação do usuário corrente

        // Accessar a cloud firestore a partir da classe que possuirá objetos no recyclerview
        FirebaseFirestore db = FirebaseFirestore.getInstance(); // objeto Firestore

        //Cria uma referencia a coleção de imóveis
        CollectionReference referenciaImoveis = db.collection("imoveis");

        //Criação da query para consultar os documentos do usuário atual
        Query consultaPorUsuario = referenciaImoveis.whereEqualTo("usuario_dono", Objects.requireNonNull(mAuth.getCurrentUser()).getUid());

        consultaPorUsuario.
                get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {

                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        Imovel imovel = document.toObject(Imovel.class);
                        imoveis.add(imovel);
                    }
                    firestoreCallback.onCallback(imoveis);

                }   else {
                    Log.d(TAG, "Erro ao receber documentos: ", task.getException());
                }
            }
        });
    }

    private interface FirestoreCallback {
        void onCallback(ArrayList<Imovel> imoveis);
    }

    //métodos usuario
    public String getUsuario_dono() {
        return usuario_dono;
    }
    public void setUsuario_dono(String usuario_dono) {
        this.usuario_dono = usuario_dono;
    }

    //métodos adm
    public String getAdministracao() {
        return administracao;
    }
    public void setAdministracao(String administracao) {
        this.administracao = administracao;
    }

    //métodos tipoImovel
    public String getTipo_imovel() {
        return tipo_imovel;
    }
    public void setTipo_imovel(String tipo_imovel) {
        this.tipo_imovel = tipo_imovel;
    }

    //métodos tipoVaga
    public String getTipo_vaga() {
        return tipo_vaga;
    }
    public void setTipo_vaga(String tipo_vaga) {
        this.tipo_vaga = tipo_vaga;
    }

    //métodos tipoQuarto
    public String getTipo_quarto() {
        return tipo_quarto;
    }
    public void setTipo_quarto(String tipo_quarto) {
        this.tipo_quarto = tipo_quarto;
    }

    //métodos preco
    public String getPreco() {
        return preco;
    }
    public void setPreco(String preco) {
        this.preco = preco;
    }

    //métodos geladeira
    public Boolean getGeladeira() {
        return geladeira;
    }
    public void setGeladeira(Boolean geladeira) {
        this.geladeira = geladeira;
    }

    //métodos maquina_de_lavar
    public Boolean getMaquina_de_lavar() {
        return maquina_de_lavar;
    }
    public void setMaquina_de_lavar(Boolean maquina_de_lavar) {
        this.maquina_de_lavar = maquina_de_lavar;
    }

    //métodos fogao
    public Boolean getFogao() {
        return fogao;
    }
    public void setFogao(Boolean fogao) {
        this.fogao = fogao;
    }

    //métodos microondas
    public Boolean getMicroondas() {
        return microondas;
    }
    public void setMicroondas(Boolean microondas) {
        this.microondas = microondas;
    }

    //métodos televisao
    public Boolean getTelevisao() {
        return televisao;
    }
    public void setTelevisao(Boolean televisao) {
        this.televisao = televisao;
    }

    //métodos wifi
    public Boolean getWifi() {
        return wifi;
    }
    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    //métodos garagem
    public Boolean getGaragem() {
        return garagem;
    }
    public void setGaragem(Boolean garagem) {
        this.garagem = garagem;
    }

    //métodos mobilia
    public Boolean getMobilia() {
        return mobilia;
    }
    public void setMobilia(Boolean mobilia) {
        this.mobilia = mobilia;
    }

    //métodos utensilio
    public Boolean getUtensilio() {
        return utensilio;
    }
    public void setUtensilio(Boolean utensilio) {
        this.utensilio = utensilio;
    }

    //métodos interfone
    public Boolean getInterfone() {
        return interfone;
    }
    public void setInterfone(Boolean interfone) {
        this.interfone = interfone;
    }

    //métodos ar_condicionado
    public Boolean getAr_condicionado() {
        return ar_condicionado;
    }
    public void setAr_condicionado(Boolean ar_condicionado) {
        this.ar_condicionado = ar_condicionado;
    }

    //métodos varanda
    public Boolean getVaranda() {
        return varanda;
    }
    public void setVaranda(Boolean varanda) {
        this.varanda = varanda;
    }


}
