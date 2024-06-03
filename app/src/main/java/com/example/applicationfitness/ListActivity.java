package com.example.applicationfitness;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applicationfitness.adapters.UsuarioAdapter;
import com.example.applicationfitness.entidades.Usuario;

import java.util.ArrayList;

@SuppressLint("MissingInflatedId")
public class ListActivity extends AppCompatActivity {
    private ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        String[] nomes = getResources().getStringArray(R.array.nomes);
        String[] generos = getResources().getStringArray(R.array.generos);
        String[] metas = getResources().getStringArray(R.array.metas);
        int[] pesos = getResources().getIntArray(R.array.pesos);

        usuarios = new ArrayList<>();
        for (int i = 0; i < nomes.length; i++) {
            usuarios.add(new Usuario(nomes[i], generos[i], metas[i], true, true, true, true, true, true, true, pesos[i]));
        }

        ListView listView = findViewById(R.id.listView);
        UsuarioAdapter adapter = new UsuarioAdapter(this, usuarios);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Usuario usuario = usuarios.get(position);
            Toast.makeText(ListActivity.this, "Clicou em: " + usuario.getNome(), Toast.LENGTH_SHORT).show();
        });
    }
}
