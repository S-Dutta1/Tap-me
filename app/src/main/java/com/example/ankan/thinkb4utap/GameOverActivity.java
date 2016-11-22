package com.example.ankan.thinkb4utap;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import org.w3c.dom.Text;

public class GameOverActivity extends Activity {

    TextView tv;
    Button gob;
    Animation slide_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in);
        setContentView(R.layout.activity_game_over);
//        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gali);
//        mp.start();
        TextView tt=(TextView) findViewById(R.id.disp_score);
        tt.setText("SCORE: "+GameActivity.score+"\n");
        tt.setTypeface(EasyFonts.ostrichBold(this));

        String txts[]={"Game Over Loser", "You Are Hopeless", "Better Luck Next Time","Are You Using Your Nose to Play",
                "Concentrate Hard", "Nah! Not Ready Yet", "Work Hard Man"};
        String txts2[]={"Pretty Good", "Impressing", "Well Played", "Okay Now You Are In Top 10%"};
        tv = (TextView) findViewById(R.id.gameovertext);
        int j=(int)(Math.random()*7);
        int k=(int)(Math.random()*4);
        if(GameActivity.score<10) {
            tv.setText(txts[j] + "\n");
        }
        else {
            tv.setText(txts2[k] + "\n");
        }
        tv.setTypeface(EasyFonts.ostrichBold(this));

        gob = (Button) findViewById(R.id.playagain);

        gob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MenuActivity.flag == 5) {
                    Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), MathGameActivity.class);
                    startActivity(intent);
                }
            }

        });


    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }
}
