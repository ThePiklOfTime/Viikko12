package com.example.viikko12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        score = findViewById(R.id.PlayerScoreText);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.FightMonstersActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    protected void onResume(){
        super.onResume();
        GameManager gameManager = GameManager.getInstance();
        Player player = gameManager.getPlayer();
        String scoreText = "Pisteet " + player.getScore();
        score.setText(scoreText);
    }
    public void changeToFightMonstersActivity(View view) {
        Intent intent = new Intent(this, FightMonstersActivity.class);
        startActivity(intent);
    }


}