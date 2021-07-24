package com.jesus.curso3_semana4_petagram_final.pojo;

import com.jesus.curso3_semana4_petagram_final.R;

import java.util.ArrayList;
import java.util.List;

public class BaseDatosFotosPerfil {

    List<Usuarios> usuariosListFotos= new ArrayList<>();

    public List<Usuarios> baseDatos() {

       // List<Usuarios> usuariosListFotos= new ArrayList<>();
        usuariosListFotos.add(new Usuarios(1,"Albert","1", R.drawable.dog_1));
        usuariosListFotos.add(new Usuarios(1,"Albert","5", R.drawable.dog_1));
        usuariosListFotos.add(new Usuarios(1,"Albert","20", R.drawable.dog_1));
        usuariosListFotos.add(new Usuarios(1,"Albert","8", R.drawable.dog_1));
        usuariosListFotos.add(new Usuarios(1,"Albert","5", R.drawable.dog_1));
        usuariosListFotos.add(new Usuarios(1,"Albert","2", R.drawable.dog_1));
         usuariosListFotos.add(new Usuarios(1,"Albert","0", R.drawable.dog_1));
        usuariosListFotos.add(new Usuarios(1,"Albert","21", R.drawable.dog_1));
        usuariosListFotos.add(new Usuarios(1,"Albert","32", R.drawable.dog_1));
        usuariosListFotos.add(new Usuarios(1,"Albert","15", R.drawable.dog_1));
        usuariosListFotos.add(new Usuarios(1,"Albert","18", R.drawable.dog_1));
        usuariosListFotos.add(new Usuarios(1,"Albert","12", R.drawable.dog_1));
        usuariosListFotos.add(new Usuarios(1,"Albert","9", R.drawable.dog_1));


        return usuariosListFotos;
    }


}
