package br.unicamp.ft.a213281_j199617.conoli.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import br.unicamp.ft.a213281_j199617.conoli.R;
import br.unicamp.ft.a213281_j199617.conoli.cadastro_imovel;
import br.unicamp.ft.a213281_j199617.conoli.recyclerView.AdapterConsulta;
import br.unicamp.ft.a213281_j199617.conoli.recyclerView.Imovel;

/**
 * A simple {@link Fragment} subclass.
 */
public class Imoveis extends Fragment {

    private RecyclerView recyclerView;
    private AdapterConsulta adapter;

    public Imoveis() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_imoveis, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new AdapterConsulta(
                new ArrayList(Arrays.asList(Imovel.getImoveis(getContext())))
        );

        recyclerView.setAdapter (adapter);
        return view;
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
