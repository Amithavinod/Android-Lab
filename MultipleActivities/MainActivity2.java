package com.example.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView a1,a2;
    Button b1;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a1=findViewById(R.id.textView);
        a2=findViewById(R.id.textView2);
        b1=findViewById(R.id.button2);
        Bundle extra=getIntent().getExtras();
        String text=extra.getString("name");
        String text1=extra.getString("age");
        a1.setText(text);
        a2.setText(text1);

    }
    public void Click (View view) {
            Intent i = new Intent(MainActivity2.this, ThirdActivity.class);
            startActivity(i);
    }

}
