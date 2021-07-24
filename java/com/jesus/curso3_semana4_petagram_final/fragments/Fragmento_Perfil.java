package com.jesus.curso3_semana4_petagram_final.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jesus.curso3_semana4_petagram_final.R;
import com.jesus.curso3_semana4_petagram_final.adapter.FotosPerfilAdaptador;
import com.jesus.curso3_semana4_petagram_final.adapter.UsuariosAdaptador;
import com.jesus.curso3_semana4_petagram_final.pojo.BaseDatos;
import com.jesus.curso3_semana4_petagram_final.pojo.BaseDatosFotosPerfil;
import com.jesus.curso3_semana4_petagram_final.pojo.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class Fragmento_Perfil extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerFotosPerfil;
    FotosPerfilAdaptador fotosPerfilAdaptador;
    List<Usuarios> usuariosListFotos;

    FloatingActionButton fab;

    public Fragmento_Perfil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmento_Principal newInstance(String param1, String param2) {
        Fragmento_Principal fragment = new Fragmento_Principal();
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
        View vista = inflater.inflate(R.layout.fragment_perfil, container, false);

        fab = (FloatingActionButton) vista.findViewById(R.id.fab_perfil);
        fab.setOnClickListener((view) -> {
            Toast.makeText(getContext(),"FAB", Toast.LENGTH_SHORT).show();
        });

        usuariosListFotos = new ArrayList<>();
        recyclerFotosPerfil = (RecyclerView) vista.findViewById(R.id.recyclerFoto);
        recyclerFotosPerfil.setLayoutManager(new GridLayoutManager(getContext(),3));

        BaseDatosFotosPerfil obj = new BaseDatosFotosPerfil();
        List<Usuarios> usuariosListFotos = obj.baseDatos();
        fotosPerfilAdaptador   = new FotosPerfilAdaptador (usuariosListFotos);
        recyclerFotosPerfil.setAdapter(fotosPerfilAdaptador);

        return vista;
    }

}