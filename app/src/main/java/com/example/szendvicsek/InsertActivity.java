package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private Button visszaGomb, felvetelGomb;
    private EditText nev, leiras, elkeszit, ar;
    private DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();

        felvetelGomb.setOnClickListener(v->{
            if (!nev.getText().toString().isEmpty()&&!leiras.getText().toString().isEmpty()&&!elkeszit.getText().toString().isEmpty()&&!ar.getText().toString().isEmpty()){
                if(db.rogzites(nev.getText().toString(),elkeszit.getText().toString(),ar.getText().toString(),leiras.getText().toString())){
                    Toast.makeText(this, "Sikeres a szendvics felvétel", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Sikertelen a szendvics felvétel", Toast.LENGTH_SHORT).show();
                }
            }
        });

        visszaGomb.setOnClickListener(v->{
            Intent toMain = new Intent(this, MainActivity.class);
            startActivity(toMain);
            finish();
        });

    }
    public void init(){
        nev = findViewById(R.id.nevSzoveg);
        leiras = findViewById(R.id.leirasSzoveg);
        elkeszit = findViewById(R.id.elkeszitSzoveg);
        ar = findViewById(R.id.arSzoveg);
        visszaGomb = findViewById(R.id.visszaGomb);
        felvetelGomb = findViewById(R.id.felvetelGomb);
        db = new DBHelper(this);
    }
}