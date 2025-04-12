package br.com.fecapccp.q2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private Button btnResultado;
    private RadioGroup radioGroup;
    private RadioButton rbOpcao1, rbOpcao2, rbOpcao3;
    private EditText campoSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);

        rbOpcao1 = findViewById(R.id.rb1);
        rbOpcao2 = findViewById(R.id.rb2);
        rbOpcao3 = findViewById(R.id.rb3);

        textResultado = findViewById(R.id.textResultado);
        btnResultado = findViewById(R.id.button);
        campoSalario = findViewById(R.id.editSalario);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviar();
            }
        });
    }

    public void enviar() {
        String salarioTexto = campoSalario.getText().toString();

        if (salarioTexto.isEmpty()) {
            textResultado.setText("Por favor, insira um salário.");
            return;
        }

        double salario = Double.parseDouble(salarioTexto);
        double novoSalario = 0;

        if (rbOpcao1.isChecked()) {
            novoSalario = salario * 1.40;
        } else if (rbOpcao2.isChecked()) {
            novoSalario = salario * 1.45;
        } else if (rbOpcao3.isChecked()) {
            novoSalario = salario * 1.50;
        } else {
            textResultado.setText("Por favor, selecione uma opção.");
            return;
        }

        textResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
    }
}
