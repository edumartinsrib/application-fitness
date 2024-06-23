package com.example.applicationfitness;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applicationfitness.adapters.UsuarioAdapter;
import com.example.applicationfitness.entidades.Usuario;

import java.util.ArrayList;

@SuppressLint("MissingInflatedId")
public class ListActivity extends AppCompatActivity {
    private ArrayList<Usuario> usuarios;
    private UsuarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        usuarios = new ArrayList<>();
        ListView listView = findViewById(R.id.listView);
        adapter = new UsuarioAdapter(this, usuarios);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Usuario usuario = usuarios.get(position);
            Toast.makeText(ListActivity.this, "Clicou em: " + usuario.getNome(), Toast.LENGTH_SHORT).show();
        });

        Button btnAdicionar = findViewById(R.id.btn_adicionar);
        btnAdicionar.setOnClickListener(v -> {
            Intent intent = new Intent(ListActivity.this, MainActivity.class);
            startActivityForResult(intent, 1);
        });

        Button btnSobre = findViewById(R.id.btn_sobre);
        btnSobre.setOnClickListener(v -> {
            Intent intent = new Intent(ListActivity.this, AutoriaActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String nome = data.getStringExtra("nome");
            String genero = data.getStringExtra("genero");
            String meta = data.getStringExtra("meta");
            boolean diaTreinoDomingo = data.getBooleanExtra("diaTreinoDomingo", false);
            boolean diaTreinoSegunda = data.getBooleanExtra("diaTreinoSegunda", false);
            boolean diaTreinoTerca = data.getBooleanExtra("diaTreinoTerca", false);
            boolean diaTreinoQuarta = data.getBooleanExtra("diaTreinoQuarta", false);
            boolean diaTreinoQuinta = data.getBooleanExtra("diaTreinoQuinta", false);
            boolean diaTreinoSexta = data.getBooleanExtra("diaTreinoSexta", false);
            boolean diaTreinoSabado = data.getBooleanExtra("diaTreinoSabado", false);
            float peso = data.getFloatExtra("peso", 0);

            Usuario novoUsuario = new Usuario(nome, genero, meta, diaTreinoDomingo, diaTreinoSegunda, diaTreinoTerca, diaTreinoQuarta, diaTreinoQuinta, diaTreinoSexta, diaTreinoSabado, peso);
            usuarios.add(novoUsuario);
            adapter.notifyDataSetChanged();
        }
    }
}
