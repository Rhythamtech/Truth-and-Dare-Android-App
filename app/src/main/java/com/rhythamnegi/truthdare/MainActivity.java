package com.rhythamnegi.truthdare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
 Button button;
 Random random = new Random();
 ImageView imageView;
 int lastdirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newdirection ;
                newdirection = random.nextInt(360);
                float pivotx = imageView.getPivotX();
                float pivoty = imageView.getPivotY();
           Animation rotate = new RotateAnimation( lastdirection , newdirection + 7200,pivotx,pivoty );
            rotate.setFillAfter(true);
            rotate.setDuration(3000);
           /*
            This Statement is use for evaluate correct angle
             button.setText(""+newdirection);
            */
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    button.setEnabled(false);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    button.setEnabled(true);

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
             lastdirection = newdirection;
                imageView.startAnimation(rotate);
            }
        });
    }


}