package com.example.formativajavier;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.formativajavier.clases.Usuario;
import com.squareup.picasso.Picasso;

public class DetalleUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        ImageView img_usuario = findViewById(R.id.img_usuario);
        TextView txt_nombre_usuario = findViewById(R.id.txt_nombre_usuario);
        TextView txt_curso_usuario = findViewById(R.id.txt_curso_usuario);

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        if (usuario != null) {
            txt_nombre_usuario.setText(usuario.getNombre());
            txt_curso_usuario.setText(usuario.getCurso());
            Picasso.get().load(usuario.getImagen()).into(img_usuario);
        }
    }
}