package com.spaceo.transitionanimation;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button transition1;
    private Button transition2;
    private Button transition3;
    private Button transition4;

    public static final String TRANSITION_TYPE="transition_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initControls();


    }

    private void initControls() {

        transition1=(Button)findViewById(R.id.transition1);
        transition2=(Button)findViewById(R.id.transition2);
        transition3=(Button)findViewById(R.id.transition3);
        transition4=(Button)findViewById(R.id.transition4);


        transition1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mIntent=new Intent(MainActivity.this, NextAcitivity.class);
                mIntent.putExtra(TRANSITION_TYPE,1);
                transitionTo(mIntent);

            }
        });

        transition2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent=new Intent(MainActivity.this, NextAcitivity.class);
                mIntent.putExtra(TRANSITION_TYPE,2);
                transitionTo(mIntent);

            }
        });

        transition3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent=new Intent(MainActivity.this, NextAcitivity.class);
                mIntent.putExtra(TRANSITION_TYPE,3);
                transitionTo(mIntent);
            }
        });

        transition4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent=new Intent(MainActivity.this, NextAcitivity.class);
                mIntent.putExtra(TRANSITION_TYPE,4);
                transitionTo(mIntent);
            }
        });

    }

    @SuppressWarnings("unchecked")
    void transitionTo(Intent i) {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(i, transitionActivityOptions.toBundle());
    }
}
