package com.example.q5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class resumoPedido extends AppCompatActivity {
    private TextView resultadoPagamento,resultadoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_pedido);

        resultadoPagamento = findViewById(R.id.resultadoPagamento);
        resultadoPedido = findViewById(R.id.resultadoPedido);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ArrayList<String> sabores = extras.getStringArrayList("SABORES");
            String tamanho = extras.getString("TAMANHO");
            String pagamento = extras.getString("PAGAMENTO");
            double valorFinal = extras.getDouble("VALOR_FINAL");

            StringBuilder pedidoFinal = new StringBuilder();
            for (String s : sabores) {
                pedidoFinal.append(s).append("\n");
            }

            resultadoPedido.setText("Pedido:\n" + pedidoFinal.toString() + "\nTamanho: " + tamanho);
            resultadoPagamento.setText("Forma de pagamento: " + pagamento + "\nTotal: R$ " + String.format("%.2f", valorFinal));
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