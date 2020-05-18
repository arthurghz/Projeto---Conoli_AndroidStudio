package br.unicamp.ft.a213281_j199617.conoli.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.unicamp.ft.a213281_j199617.conoli.R;
import br.unicamp.ft.a213281_j199617.conoli.cadastro_imovel;

/**
 * A simple {@link Fragment} subclass.
 */
public class Imoveis extends Fragment {

    public Imoveis() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imoveis, container, false);

    }


    public void cadastro(View View){
        Intent intent1 = new Intent(getContext(), cadastro_imovel.class);
        startActivity(intent1);
    }

}
