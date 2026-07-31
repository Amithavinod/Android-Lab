package com.example.gridandlinearlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    EditText e1,e2;
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView2);
        t2=findViewById(R.id.textView8);
        e1=(EditText)findViewById(R.id.editTextText3);
        e2=(EditText)findViewById(R.id.editTextText4);
        b1=findViewById(R.id.button9);
        b2=findViewById(R.id.button10);
        b3=findViewById(R.id.button11);
        b4=findViewById(R.id.button12);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double f1=Double.parseDouble(e1.getText().toString());
                Double f2=Double.parseDouble(e2.getText().toString());
                double cal=f1+f2;
                t2.setText("Addition" +cal);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double f1=Double.parseDouble(e1.getText().toString());
                Double f2=Double.parseDouble(e2.getText().toString());
                double cal=f1-f2;
                t2.setText("Subtraction" +cal);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double f1=Double.parseDouble(e1.getText().toString());
                Double f2=Double.parseDouble(e2.getText().toString());
                double cal=f1*f2;
                t2.setText("Multiplication" +cal);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double f1=Double.parseDouble(e1.getText().toString());
                Double f2=Double.parseDouble(e2.getText().toString());
                double cal=f1/f2;
                t2.setText("Addition" +cal);

            }
        });

    }
}
