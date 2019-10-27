package com.example.encodedecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    byte[] data;
    String text,text2;
    Button button,button2;
    TextView textView,textView2;
    String base64;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       text = "AIzaSyDOBJcr049-D5m0wybgMQsxAWNRSHErikw";
        button=findViewById(R.id.btn);
        button2=findViewById(R.id.btn2);
        textView=findViewById(R.id.text);
        textView2=findViewById(R.id.text2);
        data = new byte[0];

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    data = text.getBytes("UTF-8");
                    textView.setText(base64 = Base64.encodeToString(data, Base64.DEFAULT));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] data = Base64.decode(base64, Base64.DEFAULT);
                try {
                   text2 = new String(data, "UTF-8");
                    textView2.setText(text2);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });



    }
}
