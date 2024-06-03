package com.example.applicationfitness.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.applicationfitness.R;
import com.example.applicationfitness.entidades.Usuario;

import java.util.List;

public class UsuarioAdapter extends ArrayAdapter<Usuario> {
    private Context context;
    private List<Usuario> usuarios;

    public UsuarioAdapter(Context context, List<Usuario> usuarios) {
        super(context, 0, usuarios);
        this.context = context;
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Usuario usuario = usuarios.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.usuario_item, parent, false);
        }

        TextView nome = convertView.findViewById(R.id.nome);
        TextView genero = convertView.findViewById(R.id.genero);
        TextView meta = convertView.findViewById(R.id.meta);
        TextView peso = convertView.findViewById(R.id.peso);

        nome.setText(usuario.getNome());
        genero.setText(usuario.getGenero());
        meta.setText(usuario.getMeta());
        peso.setText(String.valueOf(usuario.getPeso()));

        return convertView;
    }
}
