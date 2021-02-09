package com.latihan.jumlahbilangan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private EditText bill;
    private EditText bill2;
    private EditText jumlah;
    private Button btnhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initEvent();
    }

    private void initUI(){
        bill = (EditText) findViewById(R.id.txtBill);
        bill2 = (EditText) findViewById(R.id.txtBill2);
        jumlah = (EditText) findViewById(R.id.hasil);
        btnhasil = (Button) findViewById(R.id.btnCekBil);
    }
    private void  initEvent(){
        btnhasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungJumalh();
            }
        });
    }

    private void hitungJumalh(){
        int angka1 = Integer.parseInt(bill.getText().toString());
        int angka2 = Integer.parseInt(bill2.getText().toString());
        int total = angka1 - angka2;
        jumlah.setText(total+"");
    }
}