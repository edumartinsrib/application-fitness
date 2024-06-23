package com.example.applicationfitness;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.applicationfitness.adapters.UsuarioAdapter;
import com.example.applicationfitness.entidades.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mNomeInput;
    private Button mSalvar, mLimpar;
    private RadioGroup mGeneroRadio;
    private Spinner mMetaValue;
    private CheckBox mDiaTreinoDomingo, mDiaTreinoSegunda, mDiaTreinoTerca, mDiaTreinoQuarta,
            mDiaTreinoQuinta, mDiaTreinoSexta, mDiaTreinoSabado;
    private EditText mPesoInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Certifique-se de que está apontando para o layout correto

        mNomeInput = findViewById(R.id.nomeInput);
        mGeneroRadio = findViewById(R.id.generoRadio);
        mMetaValue = findViewById(R.id.metaValue);

        List<String> metaValues = new ArrayList<>();
        metaValues.add("Selecione a meta");
        metaValues.add("Perder peso");
        metaValues.add("Manter peso");
        metaValues.add("Ganhar peso");
        metaValues.add("Ganhar massa muscular");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, metaValues);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMetaValue.setAdapter(adapter);

        mDiaTreinoDomingo = findViewById(R.id.diaTreinoDomingo);
        mDiaTreinoSegunda = findViewById(R.id.diaTreinoSegunda);
        mDiaTreinoTerca = findViewById(R.id.diaTreinoTerca);
        mDiaTreinoQuarta = findViewById(R.id.diaTreinoQuarta);
        mDiaTreinoQuinta = findViewById(R.id.diaTreinoQuinta);
        mDiaTreinoSexta = findViewById(R.id.diaTreinoSexta);
        mDiaTreinoSabado = findViewById(R.id.diaTreinoSabado);
        mPesoInput = findViewById(R.id.peso);

        mSalvar = findViewById(R.id.salvar);
        mLimpar = findViewById(R.id.limpar);

        mSalvar.setOnClickListener(v -> salvar());
        mLimpar.setOnClickListener(v -> limparCampos());
    }

    public void salvar() {
        String nome = mNomeInput.getText().toString();
        String genero = mGeneroRadio.getCheckedRadioButtonId() == R.id.generoMasculino ? "Masculino" : "Feminino";
        String meta = mMetaValue.getSelectedItem().toString();
        boolean diaTreinoDomingoValue = mDiaTreinoDomingo.isChecked();
        boolean diaTreinoSegundaValue = mDiaTreinoSegunda.isChecked();
        boolean diaTreinoTercaValue = mDiaTreinoTerca.isChecked();
        boolean diaTreinoQuartaValue = mDiaTreinoQuarta.isChecked();
        boolean diaTreinoQuintaValue = mDiaTreinoQuinta.isChecked();
        boolean diaTreinoSextaValue = mDiaTreinoSexta.isChecked();
        boolean diaTreinoSabadoValue = mDiaTreinoSabado.isChecked();
        float peso = mPesoInput.getText().toString().isEmpty() ? 0 : Float.parseFloat(mPesoInput.getText().toString());

        String mensagemValidacao = validarCampos();
        if (mensagemValidacao.isEmpty()) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("nome", nome);
            resultIntent.putExtra("genero", genero);
            resultIntent.putExtra("meta", meta);
            resultIntent.putExtra("diaTreinoDomingo", diaTreinoDomingoValue);
            resultIntent.putExtra("diaTreinoSegunda", diaTreinoSegundaValue);
            resultIntent.putExtra("diaTreinoTerca", diaTreinoTercaValue);
            resultIntent.putExtra("diaTreinoQuarta", diaTreinoQuartaValue);
            resultIntent.putExtra("diaTreinoQuinta", diaTreinoQuintaValue);
            resultIntent.putExtra("diaTreinoSexta", diaTreinoSextaValue);
            resultIntent.putExtra("diaTreinoSabado", diaTreinoSabadoValue);
            resultIntent.putExtra("peso", peso);

            setResult(RESULT_OK, resultIntent);
            finish();
        } else {
            Toast.makeText(this, mensagemValidacao, Toast.LENGTH_SHORT).show();
        }
    }

    private String validarCampos() {
        StringBuilder mensagemErro = new StringBuilder();
        if (mNomeInput.getText().toString().isEmpty()) {
            mNomeInput.setError("Campo obrigatório");
            mensagemErro.append("Nome é obrigatório\n");
        }
        if (mGeneroRadio.getCheckedRadioButtonId() == -1) {
            mensagemErro.append("Gênero é obrigatório\n");
        }
        if (mMetaValue.getSelectedItemPosition() == 0) {
            mensagemErro.append("Meta é obrigatória\n");
        }
        if (!mDiaTreinoDomingo.isChecked() && !mDiaTreinoSegunda.isChecked() && !mDiaTreinoTerca.isChecked()
                && !mDiaTreinoQuarta.isChecked() && !mDiaTreinoQuinta.isChecked() && !mDiaTreinoSexta.isChecked()
                && !mDiaTreinoSabado.isChecked()) {
            mensagemErro.append("Dia de treino é obrigatório\n");
        }
        if (mPesoInput.getText().toString().isEmpty()) {
            mensagemErro.append("Peso é obrigatório\n");
        }
        return mensagemErro.toString();
    }

    public void limparCampos() {
        mNomeInput.setText("");
        mGeneroRadio.clearCheck();
        mMetaValue.setSelection(0);
        mDiaTreinoDomingo.setChecked(false);
        mDiaTreinoSegunda.setChecked(false);
        mDiaTreinoTerca.setChecked(false);
        mDiaTreinoQuarta.setChecked(false);
        mDiaTreinoQuinta.setChecked(false);
        mDiaTreinoSexta.setChecked(false);
        mDiaTreinoSabado.setChecked(false);
        mPesoInput.setText("");
        Toast.makeText(this, "Limpo", Toast.LENGTH_SHORT).show();
    }
}