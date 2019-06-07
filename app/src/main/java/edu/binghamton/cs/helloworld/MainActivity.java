package edu.binghamton.cs.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn;
    boolean check;
    int counter;
    TextView counterText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting button to make "hello world" appear on click
        txt = findViewById(R.id.textView);
        counterText = findViewById(R.id.clickCounter);
        btn = findViewById(R.id.buttonHello);
        check = true;
        counter = 0;

        final AlphaAnimation animation = new AlphaAnimation(1.0f,0.0f);
        animation.setStartOffset(400);
        animation.setDuration(400);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                txt.setVisibility(View.GONE);
                txt.setAlpha(1.0f);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setVisibility(View.VISIBLE);
                txt.setAnimation(animation);
                counter++;
                counterText.setText("Hello Worlds created: " + counter);
            }
        });
    }
}
