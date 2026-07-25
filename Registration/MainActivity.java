package com.example.registration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText a,b,c;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        a=findViewById(R.id.editTextText);
        b=findViewById(R.id.editTextText2);
        c=findViewById(R.id.editTextText3);
        reg=findViewById(R.id.button);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = a.getText().toString();
                String email = b.getText().toString();
                String password = c.getText().toString();

                SharedPreferences sp = getSharedPreferences("UserDetails", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("NAME", name);
                editor.putString("EMAIL", email);
                editor.putString("PASSWORD", password);
                editor.commit();
                Toast.makeText(MainActivity.this,
                        "REGISTRATION SUCCESSFUL",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(" USERNAME", name);
                startActivity(intent);



            }
        });


    }
}
