package br.unicamp.ft.a213281_j199617.conoli.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import br.unicamp.ft.a213281_j199617.conoli.R;


public class BiografiaFragment extends Fragment {

    public BiografiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biografia, container, false);

    }
}
