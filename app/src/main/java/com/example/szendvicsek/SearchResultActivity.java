package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultActivity extends AppCompatActivity {
    private Button visszaGomb;
    private TextView lista;
    private DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        init();

        Cursor adatok = db.listaz();
        if (adatok.getCount() == 0){
            Toast.makeText(this, "Nincs semmi az adatbázisban", Toast.LENGTH_SHORT).show();
        } else {
            StringBuilder bobTheBuilder = new StringBuilder();
            while (adatok.moveToNext()){
                bobTheBuilder.append("nev: ").append(adatok.getInt(0));
                bobTheBuilder.append(System.lineSeparator());
                bobTheBuilder.append("Leiras: ").append(adatok.getString(1));
                bobTheBuilder.append(System.lineSeparator());
                bobTheBuilder.append("Elkészülésidő (perc): ").append(adatok.getString(2));
                bobTheBuilder.append(System.lineSeparator());
                bobTheBuilder.append("Ár(ft): ").append(adatok.getInt(3));
                bobTheBuilder.append(System.lineSeparator());
                bobTheBuilder.append(System.lineSeparator());
            }
            lista.setText(bobTheBuilder.toString());
        }


        visszaGomb.setOnClickListener(v -> {
            Intent vissza = new Intent(SearchResultActivity.this, MainActivity.class);
            startActivity(vissza);
            finish();
        });
    }

    private void init() {
        visszaGomb = findViewById(R.id.searchVisszaGomb);
        lista = findViewById(R.id.lista);
        db = new DBHelper(this);
    }
}