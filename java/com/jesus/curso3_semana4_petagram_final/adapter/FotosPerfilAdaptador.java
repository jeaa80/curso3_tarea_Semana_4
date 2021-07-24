package com.jesus.curso3_semana4_petagram_final.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jesus.curso3_semana4_petagram_final.R;
import com.jesus.curso3_semana4_petagram_final.pojo.Usuarios;

import java.util.List;

public class FotosPerfilAdaptador extends RecyclerView.Adapter<FotosPerfilAdaptador.ViewHolder>{
    private List<Usuarios> usuarioList;
    private Context context;

    public FotosPerfilAdaptador(List<Usuarios> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_foto,parent,false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_likesF.setText(usuarioList.get(position).getLikes());
        holder.imgFotoF.setImageResource(usuarioList.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView   imgFotoF;
        private TextView    tv_likesF;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Enlazar los elementos de la tarjeta
            imgFotoF      = itemView.findViewById(R.id.img_FotoF);
            tv_likesF    = itemView.findViewById(R.id.tv_likesF);

        }
    }

    private void setLikesIcon(){


    }

}
