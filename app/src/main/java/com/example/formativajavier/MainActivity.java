package com.example.formativajavier;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formativajavier.adaptadores.OnUsuarioClickListener;
import com.example.formativajavier.adaptadores.UsuarioAdaptador;
import com.example.formativajavier.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnUsuarioClickListener {

    RecyclerView rcv_usuarios;
    List<Usuario> listaUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_usuarios = findViewById(R.id.rcv_usuarios);

        Usuario usuario1 = new Usuario("https://randomuser.me/api/portraits/men/1.jpg", "Carlos Hernández", "Movil");
        Usuario usuario2 = new Usuario("https://randomuser.me/api/portraits/men/2.jpg", "Julio Voltio", "Música");
        Usuario usuario3 = new Usuario("https://randomuser.me/api/portraits/men/3.jpg", "Felipe Quintero", "Ingeniería");
        Usuario usuario4 = new Usuario("https://randomuser.me/api/portraits/men/4.jpg", "Juan David", "Física");

        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);
        listaUsuarios.add(usuario4);

        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));
        rcv_usuarios.setAdapter(new UsuarioAdaptador(listaUsuarios, this));
    }

    @Override
    public void onUsuarioClick(Usuario usuario) {
        Intent intent = new Intent(this, DetalleUsuarioActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}