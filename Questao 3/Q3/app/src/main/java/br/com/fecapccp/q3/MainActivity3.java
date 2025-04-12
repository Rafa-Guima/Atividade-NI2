package br.com.fecapccp.q3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private TextView msgWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        msgWelcome = findViewById(R.id.textNome);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String nome = bundle.getString("NOME_CLIENTE");
            if (nome != null) {
                msgWelcome.setText("Bem vindo/a, " + nome + " .Muito obrigado por fazer o cadastro! ");
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void voltarParaPrimeiraPagina(View view) {
        finish();
    }
}
