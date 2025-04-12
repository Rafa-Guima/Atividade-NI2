package br.com.fecapccp.q3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText editNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        editNome = findViewById(R.id.editNome);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void cadastroPessoa(View view) {
        String nome = editNome.getText().toString();

        if (!nome.isEmpty()) {
            Intent intent = new Intent(this, MainActivity3.class);
            Bundle bundle = new Bundle();
            intent.putExtra("NOME_CLIENTE", nome);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } else {
            editNome.setError("Por favor, digite seu nome!");
        }
    }
}
