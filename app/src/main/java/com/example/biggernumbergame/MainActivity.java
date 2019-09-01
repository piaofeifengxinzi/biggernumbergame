package com.example.biggernumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private Button buttonleft;
    private Button buttonright;
    private TextView textView1;

    private Integer num1;
    private Integer num2;

    private Integer point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        buttonleft = (Button)findViewById(R.id.button);
        buttonright = (Button)findViewById(R.id.button2);
        textView1 = (TextView)findViewById(R.id.textView4);
        buttonleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1>num2){
                    point++;
                    textView1.setText("Point:" + String.valueOf(point));
                    Toast.makeText(MainActivity.this, "加一分", Toast.LENGTH_SHORT).show();
                }
                else{
                    point--;
                    textView1.setText("Point:" + String.valueOf(point));
                    Toast.makeText(MainActivity.this, "减一分", Toast.LENGTH_SHORT).show();
                }
                init();

            }
        });
        buttonright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1<num2){
                    point++;
                    textView1.setText("Point:" + String.valueOf(point));
                    Toast.makeText(MainActivity.this, "加一分", Toast.LENGTH_SHORT).show();
                }
                else{
                    point--;
                    textView1.setText("Point:" + String.valueOf(point));
                    Toast.makeText(MainActivity.this, "减一分", Toast.LENGTH_SHORT).show();
                }
                init();
            }
        });
        init();
    }

    //生成随机数，并且设置按钮数值
    private void init(){
        boolean flag = true;
        while(flag){
            num1 = (int)(Math.random()*100);
            num2 = (int)(Math.random()*100);
            if(num1!=num2){
                flag = false;
            }
        }
        buttonleft.setText(String.valueOf(num1));
        buttonright.setText(String.valueOf(num2));
        SetButtonColor();
    }

    private void SetButtonColor(){
        int color1 = Color.rgb((int)(Math.random()*128),(int)(Math.random()*128),(int)(Math.random()*128));
        int color2 = Color.rgb((int)(Math.random()*128),(int)(Math.random()*128),(int)(Math.random()*128));
        buttonleft.setBackgroundColor(color1);
        buttonright.setBackgroundColor(color2);
    }
}
