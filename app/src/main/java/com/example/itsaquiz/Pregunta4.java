package com.example.itsaquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pregunta4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pregunta4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Pregunta4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pregunta4.
     */
    // TODO: Rename and change types and number of parameters
    public static Pregunta4 newInstance(String param1, String param2) {
        Pregunta4 fragment = new Pregunta4();
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
        return inflater.inflate(R.layout.fragment_pregunta4, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RadioButton rbtn1 = view.findViewById(R.id.radioButton1);
        RadioButton rbtn2 = view.findViewById(R.id.radioButton2);
        RadioButton rbtn3 = view.findViewById(R.id.radioButton3);
        RadioButton rbtn4 = view.findViewById(R.id.radioButton4);

        final NavController navController = Navigation.findNavController(view);

        rbtn1.setOnClickListener(new View.OnClickListener() {
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

                builder.setNegativeButton("No", null);
                AlertDialog dialog = builder.create();
                dialog.show();

                PuntuacionFinal puntuacionFinal = new PuntuacionFinal();
                puntuacionFinal.setPuntuacion(-2+puntuacionFinal.getPuntuacion());
                puntuacionFinal.comprobarNegatividad();
                Navigation.findNavController(view).navigate(R.id.pregunta5);
            }
        });
        rbtn2.setOnClickListener(new View.OnClickListener() {
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

                builder.setNegativeButton("No", null);
                AlertDialog dialog = builder.create();
                dialog.show();

                PuntuacionFinal puntuacionFinal = new PuntuacionFinal();
                puntuacionFinal.setPuntuacion(-2+puntuacionFinal.getPuntuacion());
                puntuacionFinal.comprobarNegatividad();
                Navigation.findNavController(view).navigate(R.id.pregunta5);
            }
        });
        rbtn3.setOnClickListener(new View.OnClickListener() {
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

                builder.setNegativeButton("No", null);
                AlertDialog dialog = builder.create();
                dialog.show();

                PuntuacionFinal puntuacionFinal = new PuntuacionFinal();
                puntuacionFinal.setPuntuacion(-2+puntuacionFinal.getPuntuacion());
                puntuacionFinal.comprobarNegatividad();
                Navigation.findNavController(view).navigate(R.id.pregunta5);
            }
        });
        rbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PuntuacionFinal puntuacionFinal = new PuntuacionFinal();
                puntuacionFinal.setPuntuacion(3+puntuacionFinal.getPuntuacion());
                Navigation.findNavController(view).navigate(R.id.pregunta5);
            }
        });
    }
}