package com.example.navigationcomponentsexample;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class ChooseRecipientFragment extends Fragment implements View.OnClickListener {

    private NavController navController = null;
    private TextInputEditText inputEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        view.findViewById(R.id.next_btn).setOnClickListener(this);
        view.findViewById(R.id.cancel_btn).setOnClickListener(this);

        inputEditText = view.findViewById(R.id.input_recipient);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.next_btn:

                if (!inputEditText.getText().toString().isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("recipient", inputEditText.getText().toString());
                    navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment,bundle);
                }else {
                    Toast.makeText(getContext(), "PLEASE enter a name!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cancel_btn:
                requireActivity().onBackPressed();
                break;

        }

    }
}