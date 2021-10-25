package com.example.itsaquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pregunta5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pregunta5 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Pregunta5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pregunta5.
     */
    // TODO: Rename and change types and number of parameters
    public static Pregunta5 newInstance(String param1, String param2) {
        Pregunta5 fragment = new Pregunta5();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pregunta5, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton btn1 = view.findViewById(R.id.imageButton);
        ImageButton btn2 = view.findViewById(R.id.imageButton2);

        final NavController navController = Navigation.findNavController(view);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("¡Correcto!");
                builder.setMessage("¡Enhorabuena has acertado!. ¡Sigue así!.");
                builder.setPositiveButton("Continuar", null);
                AlertDialog dialog = builder.create();
                dialog.show();
                PuntuacionFinal puntuacionFinal = new PuntuacionFinal();
                puntuacionFinal.setPuntuacion(3+puntuacionFinal.getPuntuacion());
                Intent intent = new Intent(getContext(),PuntuacionFinal.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Fallaste");
                builder.setMessage("Te has equivocado. ¿Quieres salir?");

                Intent intent = new Intent(getContext(),Menu.class);

                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getContext(),Menu.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PuntuacionFinal puntuacionFinal = new PuntuacionFinal();
                        puntuacionFinal.setPuntuacion(-2+puntuacionFinal.getPuntuacion());
                        puntuacionFinal.comprobarNegatividad();
                        Intent intent = new Intent(getContext(),PuntuacionFinal.class);
                        startActivity(intent);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });


    }
}