package com.example.navigationcomponentsexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Parcel;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.math.BigDecimal;
import java.util.Objects;

public class SpecifyAmountFragment extends Fragment implements View.OnClickListener {

    private NavController navController = null;

    private TextInputEditText inputAmount;
    private String recipientText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle data = getArguments();

        recipientText = data.getString("recipient");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        view.findViewById(R.id.send_btn).setOnClickListener(this);
        view.findViewById(R.id.cancel_btn).setOnClickListener(this);

        inputAmount = view.findViewById(R.id.input_amount);

        String message = "Sending money to " + recipientText;

        TextView recipientTextView;
        recipientTextView = view.findViewById(R.id.recipient);
        recipientTextView.setText(message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_btn:

                if (!inputAmount.getText().toString().isEmpty()) {
                    String moneyAmount = (inputAmount.getText().toString());
                    Bundle bundle = new Bundle();

                    bundle.putString("recipient", recipientText);
                    bundle.putString("money",moneyAmount);

                    navController.navigate(R.id.action_specifyAmountFragment_to_viewBalanceFragment, bundle);
                }else {
                    Toast.makeText(getContext(), "Please enter a number!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.cancel_btn:
                requireActivity().onBackPressed();
                break;
        }
    }
}