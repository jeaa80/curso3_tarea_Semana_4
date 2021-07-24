package com.jesus.curso3_semana4_petagram_final.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jesus.curso3_semana4_petagram_final.R;
import com.jesus.curso3_semana4_petagram_final.adapter.UsuariosAdaptador;
import com.jesus.curso3_semana4_petagram_final.pojo.BaseDatos;
import com.jesus.curso3_semana4_petagram_final.pojo.Usuarios;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento_Principal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerUsuarios;
    UsuariosAdaptador usuariosAdaptador;
    List<Usuarios> usuariosList;
    FloatingActionButton fab;

    public Fragmento_Principal() {
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
        View vista = inflater.inflate(R.layout.fragment_principal, container, false);
        fab = (FloatingActionButton) vista.findViewById(R.id.fab_perfil);
        fab.setOnClickListener((view) -> {
            Toast.makeText(getContext(),"FAB", Toast.LENGTH_SHORT).show();
        });
        usuariosList = new ArrayList<>();
        recyclerUsuarios = (RecyclerView) vista.findViewById(R.id.recycler);
        recyclerUsuarios.setLayoutManager(new LinearLayoutManager(getContext()));
        //llenarLista();
        BaseDatos obj = new BaseDatos();
        List<Usuarios> usuariosList = obj.baseDatos();
        usuariosAdaptador   = new UsuariosAdaptador(usuariosList);
        recyclerUsuarios.setAdapter(usuariosAdaptador);

        //UsuariosAdaptador adapter = new UsuariosAdaptador(usuariosList);
        //recyclerUsuarios.setAdapter(adapter);

        return vista;
    }

    /*private void llenarLista() {
        usuariosList.add(new Usuarios(1,"Albert","1", R.drawable.dog_1));
        usuariosList.add(new Usuarios(2,"Bruno","4", R.drawable.dog_2));
        usuariosList.add(new Usuarios(3,"Beto","3", R.drawable.dog_3));
        usuariosList.add(new Usuarios(4,"Chiribiko","5", R.drawable.dog_4));
        usuariosList.add(new Usuarios(5,"Perry Bones","2", R.drawable.dog_5));
        usuariosList.add(new Usuarios(6,"Michy","6", R.drawable.dog_6));
    }*/

}