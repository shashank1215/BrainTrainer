package com.codewithshashank.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView timer,score,ques;
    Button op1,op2,op3,op4,play;
    int x,y;int crctindex;boolean gameon=false;
    int totalques=0;int totalcorrectans=0;CountDownTimer countDownTimer;
    public void checkans(View view)
    {
        if(gameon==true) {
            totalques++;
            Button clicked = (Button) view;
            if (Integer.parseInt(clicked.getTag().toString()) == crctindex) {
                totalcorrectans++;
                score.setText(Integer.toString(totalcorrectans) + "/" + Integer.toString(totalques));
            } else
                score.setText(Integer.toString(totalcorrectans) + "/" + Integer.toString(totalques));
            generator();
        }
    }
    void generator()
    {
        Random rnd=new Random();
        x=rnd.nextInt(90)+10;
        y=rnd.nextInt(90)+10;
        ques.setText(Integer.toString(x)+"*"+Integer.toString(y)+"=?");
         crctindex=rnd.nextInt(3)+1;
        if(Integer.parseInt(op1.getTag().toString())!=crctindex)
        op1.setText(Integer.toString(rnd.nextInt(9701)+100));
         else  op1.setText(Integer.toString(x*y));
        if(Integer.parseInt(op2.getTag().toString())!=crctindex)
            op2.setText(Integer.toString((x+10)*(y+10)));
        else  op2.setText(Integer.toString(x*y));
        if(Integer.parseInt(op3.getTag().toString())!=crctindex)
            op3.setText(Integer.toString(rnd.nextInt(9701)+100));
        else  op3.setText(Integer.toString(x*y));
        if(Integer.parseInt(op4.getTag().toString())!=crctindex)
            op4.setText(Integer.toString(rnd.nextInt(9701)+100));
        else  op4.setText(Integer.toString(x*y));


    }
    public void start(View view)
    {
        score.setText("0/0");
        play.setVisibility(View.INVISIBLE);
        gameon=true;
        generator();
        countDownTimer=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int t=(int)(millisUntilFinished/1000);
                timer.setText(Integer.toString(t)+"s");
            }

            @Override
            public void onFinish() {
                    play.setVisibility(View.VISIBLE);
                    play.setText("Play Again");
                    totalcorrectans=0;totalques=0;
                    gameon=false;
            }
        }.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=findViewById(R.id.textView);
        score=findViewById(R.id.textView1);
        ques=findViewById(R.id.textView2);
       op1=findViewById(R.id.op1);
        op2=findViewById(R.id.op2);
       op3=findViewById(R.id.op3);
        op4=findViewById(R.id.op4);
        play=findViewById(R.id.button);



    }
}
