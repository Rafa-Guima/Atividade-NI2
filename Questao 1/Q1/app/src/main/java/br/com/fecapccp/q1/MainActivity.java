package br.com.fecapccp.q1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox produto1,produto2,produto3,produto4,produto5;
    private TextView textResultado;
    private Button btnResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        produto1 = findViewById(R.id.checkBox);
        produto2 = findViewById(R.id.checkBox2);
        produto3 = findViewById(R.id.checkBox3);
        produto4 = findViewById(R.id.checkBox4);
        produto5 = findViewById(R.id.checkBox5);

        textResultado = findViewById(R.id.textResultado);

        btnResultado = findViewById(R.id.button);





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void enviar (View view) {
        checkBox();
    }

    public void checkBox() {
        float resultado = 0;  // Inicia o resultado como 0

        if (produto1.isChecked()) {
            float produtoSelecionado = 2.69f;
            resultado += produtoSelecionado;
        }
        if (produto2.isChecked()) {
            float produtoSelecionado = 2.70f;
            resultado += produtoSelecionado;
        }
        if (produto3.isChecked()) {
            float produtoSelecionado = 16.70f;
            resultado += produtoSelecionado;
        }
        if (produto4.isChecked()) {
            float produtoSelecionado = 3.38f;
            resultado += produtoSelecionado;
        }
        if (produto5.isChecked()) {
            float produtoSelecionado = 3.00f;
            resultado += produtoSelecionado;
        }
        textResultado.setText("Total: R$ " + String.format("%.2f", resultado));
    }
}