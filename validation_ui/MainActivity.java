package com.example.validation_ui;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText eName,eEmail,ePassword;

    RadioGroup rgGender;

    Spinner spCountry;

    CheckBox ChkTerms;

    Button btnSubmit;

    String[] country = {"select conuntry","india","USA","UK","canada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        eName=findViewById(R.id.editTextText);
        eEmail=findViewById(R.id.editTextText2);
        ePassword=findViewById(R.id.editTextText3);
        rgGender=findViewById(R.id.radioGroup);
        spCountry=findViewById(R.id.spinner2);
        ChkTerms=findViewById(R.id.checkBox3);
        btnSubmit=findViewById(R.id.button2);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                country
        );

        spCountry.setAdapter(adapter);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=eName.getText().toString().trim();
                String email=eEmail.getText().toString().trim();
                String password=ePassword.getText().toString().trim();

                if (name.isEmpty()) {
                    eName.setError("enter name");
                    return;
                }

                if (email.isEmpty()) {
                    eEmail.setError("Enter email");
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    eEmail.setError("invalid email");
                    return;
                }

                if (password.length()<8){
                    ePassword.setError("password must be at 8 characters");
                    return;
                }

                if (rgGender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity.this,
                    "select gender",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (spCountry.getSelectedItemPosition()==0){
                    Toast.makeText(MainActivity.this,
                            "select country",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!ChkTerms.isChecked()) {
                    Toast.makeText(MainActivity.this,
                            "accept terms and conditions",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this,
                        "validation successfull",
                        Toast.LENGTH_SHORT).show();

            }
        });

    }
}
