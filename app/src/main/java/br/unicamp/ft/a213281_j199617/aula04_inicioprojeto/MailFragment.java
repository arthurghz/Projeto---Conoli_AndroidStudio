package br.unicamp.ft.a213281_j199617.aula04_inicioprojeto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MailFragment extends Fragment {

    private EditText mensagem;
    private EditText destinatario;

    public MailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mail, container, false);

        mensagem = view.findViewById(R.id.mensagem);
        destinatario = view.findViewById(R.id.destinatario);
        Button enviar = view.findViewById(R.id.btn_send);
        Button action = view.findViewById(R.id.btn_send_action);

        enviar.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    String msg = mensagem.getText().toString();
                    String dst = destinatario.getText().toString();

                    //NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                    NavController navController = NavHostFragment.findNavController(MailFragment.this);

                    Bundle bundle = new Bundle();
                    bundle.putString("msg", msg);
                    bundle.putString("dst", dst);

                    navController.navigate(R.id.biografiaFragment, bundle);
                }
            }
        );

        action.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavController navController = NavHostFragment.findNavController(MailFragment.this);
                    navController.navigate(R.id.minhaAresta);
                }
            }
        );
        return view;
    }
}
