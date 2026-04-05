package com.example.viikko12.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viikko12.GameManager;
import com.example.viikko12.Monster;
import com.example.viikko12.R;


public class BossFightFragment extends Fragment {
    TextView bossText;
    Button attackBoss;
    Monster bossMonster;
    GameManager gameManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boss_fight, container, false);;
        bossText = view.findViewById(R.id.BossText);
        attackBoss = view.findViewById(R.id.AttackBossButton);
        gameManager = GameManager.getInstance();
        bossMonster = new Monster("Boss", 150) {
            boolean isFirstTime;

            @Override
            public void takeDamage(int Damage) {
                this.life -= Damage;
                if (!isFirstTime && this.life <=75) {
                    this.life = 150;
                    isFirstTime = true;

                }

                if (this.life < 0) {
                    this.life = 0;
                }


            }
        };
        setBossText();

        attackBoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameManager.getPlayer().attack(bossMonster);
                setBossText();

            }
        });
        return view;
    }
    private void setBossText() {
        String bossTxt = bossMonster.getName() + ": " + bossMonster.getLife() + "/" + bossMonster.getMaxLife();
        bossText.setText(bossTxt);
    }
}
