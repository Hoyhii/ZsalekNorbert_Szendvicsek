package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button keresesGomb, ujGomb;
    private EditText arSzoveg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ujGomb.setOnClickListener(v -> {
            Intent atlepInsert = new Intent(this, InsertActivity.class);
            startActivity(atlepInsert);
            finish();
        });
        keresesGomb.setOnClickListener(v->{
            Intent atlepSearch = new Intent(this, SearchResultActivity.class);
            if (!arSzoveg.getText().toString().isEmpty()){
                startActivity(atlepSearch);
                finish();
            }
            else Toast.makeText(this, "A mező nem maradhat üresen!", Toast.LENGTH_SHORT).show();
        });
    }

    private void init() {
        keresesGomb = findViewById(R.id.keresesGomb);
        ujGomb = findViewById(R.id.ujGomb);
        arSzoveg = findViewById(R.id.arSzoveg);
    }
}