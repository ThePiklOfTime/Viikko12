package com.example.viikko12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.viikko12.fragments.BossFightFragment;
import com.example.viikko12.fragments.ShowMonsterFragment;

public class FightMonstersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fight_monsters);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.FightMonstersActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void changeToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void showMonster(View view) {
        Fragment fragment = new ShowMonsterFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FightMonstersFrame, fragment)
                .commit();

    }
    public void showBoss(View view) {
        Fragment fragment = new BossFightFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FightMonstersFrame, fragment)
                .commit();

    }
    public void setBossButtonVisible() {
        Button bossButton = findViewById(R.id.BossFightFragmentButton);
        bossButton.setEnabled(true);
    }

}