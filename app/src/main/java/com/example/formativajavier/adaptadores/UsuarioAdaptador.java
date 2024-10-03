package com.example.formativajavier.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formativajavier.R;
import com.example.formativajavier.clases.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.viewHolder> {

    private List<Usuario> datos;
    private OnUsuarioClickListener listener;

    public UsuarioAdaptador(List<Usuario> datos, OnUsuarioClickListener listener) {
        this.datos = datos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UsuarioAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new viewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdaptador.viewHolder holder, int position) {
        Usuario dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView txt_nombre_usuario, txt_curso_usuario;
        ImageView img_usuario;

        public viewHolder(@NonNull View itemView, OnUsuarioClickListener listener) {
            super(itemView);
            txt_nombre_usuario = itemView.findViewById(R.id.txt_nombre_usuario);
            txt_curso_usuario = itemView.findViewById(R.id.txt_curso_usuario);
            img_usuario = itemView.findViewById(R.id.img_usuario);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onUsuarioClick((Usuario) v.getTag());
                    }
                }
            });
        }

        public void bind(Usuario dato) {
            txt_nombre_usuario.setText(dato.getNombre());
            txt_curso_usuario.setText(dato.getCurso());
            Picasso.get().load(dato.getImagen()).into(img_usuario);
            itemView.setTag(dato);
        }
    }
}