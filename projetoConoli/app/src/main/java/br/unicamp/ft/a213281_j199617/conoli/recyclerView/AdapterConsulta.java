package br.unicamp.ft.a213281_j199617.conoli.recyclerView;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Objects;

import br.unicamp.ft.a213281_j199617.conoli.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterConsulta extends RecyclerView.Adapter {

    private static final String TAG = "Status consulta";

    private ArrayList<Imovel> imoveis;
    public AdapterConsulta(ArrayList imoveis){
        this.imoveis = imoveis;
    }

    public void getImoveis(){
        FirebaseAuth mAuth = FirebaseAuth.getInstance(); //verificação do usuário corrente

        // Accessar a cloud firestore a partir da classe que possuirá objetos no recyclerview
        FirebaseFirestore db = FirebaseFirestore.getInstance(); // objeto Firestore

        //Cria uma referencia a coleção de imóveis
        CollectionReference referenciaImoveis = db.collection("imoveis");

        //Criação da query para consultar os documentos do usuário atual
        Query consultaPorUsuario = referenciaImoveis.whereEqualTo("user_owner", Objects.requireNonNull(mAuth.getCurrentUser()).getUid());

        consultaPorUsuario.
                get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Imovel imovel = document.toObject(Imovel.class);
                        imoveis.add(imovel);
                    }
                    notifyDataSetChanged();

                } else {
                    Log.d(TAG, "Erro ao receber documentos: ", task.getException());
                }
            }
        });
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout, parent, false);

        return new MyFirstViewHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull RecyclerView.ViewHolder holder, int position){
        ((MyFirstViewHolder)holder).bind(imoveis.get(position));
    }

    @Override
    public int getItemCount() {
        return imoveis.size();
    }

    class MyFirstViewHolder extends RecyclerView.ViewHolder {
        private TextView userId;
        private TextView admImovel;
        private TextView tipoImovel;
        private TextView tipoVaga;

        public MyFirstViewHolder(@NonNull View itemView){
            super (itemView);
            userId = itemView.findViewById(R.id.textView_userId);
            admImovel = itemView.findViewById(R.id.admImovel);
            tipoImovel = itemView.findViewById(R.id.tipoImovel);
            tipoVaga = itemView.findViewById(R.id.tipoVaga);
        }

        public void bind (Imovel imovel){
            userId.setText(imovel.getUsuario_dono());
            admImovel.setText(imovel.getAdministracao());
            tipoImovel.setText(imovel.getTipo_imovel());
            tipoVaga.setText(imovel.getTipo_vaga());
        }

    }

}
