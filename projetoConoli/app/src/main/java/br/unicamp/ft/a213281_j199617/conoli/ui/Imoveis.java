package br.unicamp.ft.a213281_j199617.conoli.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;

import br.unicamp.ft.a213281_j199617.conoli.R;
import br.unicamp.ft.a213281_j199617.conoli.cadastro_imovel;

/**
 * A simple {@link Fragment} subclass.
 */
public class Imoveis extends Fragment {

    FirebaseAuth mAuth; //possivel verificação do usuário corrente

    // Accessar a cloud firestore a partir do formulário de cadastro
    FirebaseFirestore db = FirebaseFirestore.getInstance(); // objeto Firestore

    private RecyclerView recyclerView;
    private AdapterConsulta adapter;

    public Imoveis() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imoveis, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new AdapterConsulta(
                new ArrayList(Arrays.asList(Aluno.getAlunos(getContext())))
        );

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getView().findViewById(R.id.batataCadastro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getContext(), cadastro_imovel.class);
                startActivity(intent1);
            }
        });

    }
}
