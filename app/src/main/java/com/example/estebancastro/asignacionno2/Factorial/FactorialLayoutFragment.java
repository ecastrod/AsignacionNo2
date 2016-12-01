package com.example.estebancastro.asignacionno2.Factorial;

/**
 * Created by ESTEBAN CASTRO on 21/11/2016.
 */


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.example.estebancastro.asignacionno2.R;

public class FactorialLayoutFragment extends Fragment {


    Button buttonCalculate;
    EditText editTextNum;
    EditText editTextResult;

    public FactorialLayoutFragment() {
        // Required empty public constructor
    }

    public static FactorialLayoutFragment newInstance() {
        FactorialLayoutFragment fragment = new FactorialLayoutFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_factorial_layout, container, false);


        buttonCalculate = (Button) view.findViewById(R.id.btnCalcularFactorial);
        editTextNum = (EditText) view.findViewById(R.id.editTextFactorial);
        editTextResult = (EditText) view.findViewById(R.id.editTextFactorialResult);



        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNum.getText().toString().matches("")) {
                    // Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
                    return;
                }

                long num = Long.parseLong(editTextNum.getText().toString());
                FactorialUtil cFacto = new FactorialUtil(num);

                long numResultado = cFacto.calculateFactorial();

                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Resultado");
                alertDialog.setMessage(Long.toString(numResultado));
                editTextResult.setText(Long.toString(numResultado));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                editTextNum.setText("");


                            }
                        });
                alertDialog.show();
            }
        });
        return view;




    }

}
