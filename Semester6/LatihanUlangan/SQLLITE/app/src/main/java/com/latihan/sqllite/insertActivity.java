package com.latihan.sqllite;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class insertActivity extends AppCompatActivity implements View.OnClickListener {
    ActionBar actionBar;
    EditText edtJudul, edtDeskripsi;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Ubah");

        edtJudul = findViewById(R.id.edtjdl);
        edtDeskripsi = findViewById(R.id.edtdesk);
        btnSubmit = findViewById(R.id.buttadd);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttadd){
            DatabaseHelper db = new DatabaseHelper(this);
            PersonBean currentPerson = new PersonBean();
            currentPerson.setJudul(edtJudul.getText().toString());
            currentPerson.setDeskripsi(edtDeskripsi.getText().toString());
            db.insert(currentPerson);
            edtJudul.setText("");
            edtDeskripsi.setText("");
            edtJudul.setFocusable(true);
            startActivity(new Intent(insertActivity.this, homeActivity.class));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}