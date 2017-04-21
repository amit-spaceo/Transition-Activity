package com.spaceo.transitionanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import static com.spaceo.transitionanimation.MainActivity.TRANSITION_TYPE;

public class NextAcitivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transition_activity);

        ((Button)findViewById(R.id.exit_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        int type = getIntent().getIntExtra(TRANSITION_TYPE,1);

        switch (type){
            case 1:
                Explode explodeTransition = new Explode();
                explodeTransition.setDuration(500);
                getWindow().setEnterTransition(explodeTransition);
                break;
            case 2:
                Transition explodeWithBounce = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                getWindow().setEnterTransition(explodeWithBounce);
                break;
            case 3:
                Slide slideTransition = new Slide();
                slideTransition.setDuration(500);
                slideTransition.setSlideEdge(Gravity.RIGHT);
                getWindow().setEnterTransition(slideTransition);
                break;
            case 4:
                Transition slideFromTop = TransitionInflater.from(this).inflateTransition(R.transition.slide_from_top);
                getWindow().setEnterTransition(slideFromTop);
                break;
            default:
                break;
        }


    }


}
