package com.example.viikko12.fragments;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
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
import com.example.viikko12.Skeleton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShowMonsterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowMonsterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView monsterNameText, monsterLifeText;
    ImageView monsterImage;
    Button attackBtn;

    Monster monster;
    String monsterClass;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShowMonsterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShowMonsterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowMonsterFragment newInstance(String param1, String param2) {
        ShowMonsterFragment fragment = new ShowMonsterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_monster, container, false);
        monsterImage = view.findViewById(R.id.MonsterImage);
        monsterNameText = view.findViewById(R.id.MonsterNameText);
        monsterLifeText = view.findViewById(R.id.MonsterLifeText);
        attackBtn = view.findViewById(R.id.AttackMonsterButton);
        GameManager gameManager = GameManager.getInstance();

        monster = gameManager.generateMonster();

        setMonsterLifeText();
        attackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameManager.getPlayer().attack(monster);
                setMonsterLifeText();
                if (monster.getLife() == 0) {
                    monster = gameManager.generateMonster();
                }
            }
        });
        return view;
    }
    public void setMonsterLifeText() {
        if (monster instanceof Skeleton){
            monsterClass = "Luuranko";
            monsterImage.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.erno_skeleton));
        }
        else {
            monsterClass = "Vampyyri";
            monsterImage.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.erno_vampire));
        }
        monsterNameText.setText(monster.getName());

        String monsterLifeTxt = "Elämä: " + monster.getLife() + "/" + monster.getMaxLife() + "\n" + monsterClass;
        monsterLifeText.setText(monsterLifeTxt);
    }
}