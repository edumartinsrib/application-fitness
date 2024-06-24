package com.example.applicationfitness;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.applicationfitness.adapters.UsuarioAdapter;
import com.example.applicationfitness.entidades.Usuario;

import java.util.ArrayList;

@SuppressLint("MissingInflatedId")
public class ListActivity extends AppCompatActivity {
    private ArrayList<Usuario> usuarios;
    private UsuarioAdapter adapter;
    private int selectedPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        usuarios = new ArrayList<>();
        ListView listView = findViewById(R.id.listView);
        adapter = new UsuarioAdapter(this, usuarios);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            selectedPosition = position;
            return false;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_adicionar) {
            Intent intent = new Intent(ListActivity.this, MainActivity.class);
            startActivityForResult(intent, 1);
            return true;
        } else if (id == R.id.menu_sobre) {
            Intent intentSobre = new Intent(ListActivity.this, AutoriaActivity.class);
            startActivity(intentSobre);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.context_editar) {
            Usuario usuario = usuarios.get(selectedPosition);
            Intent intent = new Intent(ListActivity.this, MainActivity.class);
            intent.putExtra("usuario", usuario);
            startActivityForResult(intent, 2);
            return true;
        } else if (id == R.id.context_excluir) {
            usuarios.remove(selectedPosition);
            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
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
