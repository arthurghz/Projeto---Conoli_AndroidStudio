package br.unicamp.ft.a213281_j199617.aula04_inicioprojeto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BiografiaFragment extends Fragment {

    public BiografiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_biografia, container, false);
        //Recebendo valores
        Bundle bundle = getArguments();
        if (bundle != null) {
            String msg = bundle.getString("msg", "ASDF");
            String dst = bundle.getString("dst", "ASDF");

            TextView txtMsg = view.findViewById(R.id.msg);
            TextView txtDst = view.findViewById(R.id.dst);

            txtMsg.setText(msg);
            txtDst.setText(dst);
        }
        return view;
    }
}
