package com.example.estebancastro.asignacionno2.Fibonacci;

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


public class FibonacciLayoutFragment extends Fragment{

    Button buttonCalculate;
    EditText editTextResultado;
    EditText editTextResult;

    public FibonacciLayoutFragment() {
        // Required empty public constructor
    }

    public static FibonacciLayoutFragment newInstance() {
        FibonacciLayoutFragment fragment = new FibonacciLayoutFragment();
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
        final View view = inflater.inflate(R.layout.fragment_fibonacci_layout, container, false);

        buttonCalculate = (Button) view.findViewById(R.id.btnCalcularFibonacci);
        editTextResultado = (EditText) view.findViewById(R.id.editTextNumeroFibonacci);
        editTextResult = (EditText) view.findViewById(R.id.editTextFibonacciResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextResultado.getText().toString().matches("")) {
                    // Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
                    return;
                }

                long numeroacalcular = Long.parseLong(editTextResultado.getText().toString());
                FibonacciUtil cFibo = new FibonacciUtil(numeroacalcular);

                long numResultado = cFibo.calculateFibonacci();

                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Resultado es:");
                alertDialog.setMessage(Long.toString(numResultado));
                editTextResult.setText(Long.toString(numResultado));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                editTextResultado.setText("");
                            }
                        });
                alertDialog.show();
            }
        });
        return view;


    }
}