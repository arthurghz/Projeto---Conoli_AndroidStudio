package br.unicamp.ft.a213281_j199617.conoli.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import br.unicamp.ft.a213281_j199617.conoli.R;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<Integer> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(R.string.dashboard_bem_vindo);
    }

    public LiveData<Integer> getText() {
        return mText;
    }
}