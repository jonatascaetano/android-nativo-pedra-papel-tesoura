package com.jonatas.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void escolherPedra(View view) {
        sortearJogada("Pedra");
    }

    public void escolherPapel(View view) {
        sortearJogada("Papel");
    }

    public void escolherTesoura(View view) {
        sortearJogada("Tesoura");
    }

    public void sortearJogada(String jogada) {
        ImageView imageView = findViewById(R.id.imageView);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int indice = new Random().nextInt(opcoes.length);
        String jogadaApp = opcoes[indice];
        TextView textView = findViewById(R.id.mensagem);
        switch (jogadaApp) {
            case "Pedra":
                imageView.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageView.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageView.setImageResource(R.drawable.tesoura);
                break;
        }
        if (jogadaApp == "Pedra" && jogada == "Tesoura" ||
            jogadaApp == "Papel" && jogada == "Pedra" ||
            jogadaApp == "Tesoura" && jogada == "Papel") {
            textView.setText("Você perdeu!");
        } else if (jogadaApp == "Pedra" && jogada == "Papel" ||
                   jogadaApp == "Papel" && jogada == "Tesoura" ||
                   jogadaApp == "Tesoura" && jogada == "Pedra") {
                   textView.setText("Você ganhou!");
        } else {
            textView.setText("Empate!");

        }
    }


}