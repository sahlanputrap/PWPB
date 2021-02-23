package com.latihan.sqllite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class homeActivity extends AppCompatActivity implements RecyclerviewAdapter.OnUserClickListener {
    FloatingActionButton fab;
    ActionBar actionBar;
    RecyclerView recyclerView;
    DatabaseHelper db;
    List<PersonBean> listPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Notes");
        db = new DatabaseHelper(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(homeActivity.this));


        fab = findViewById(R.id.floatingActionButton2);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity.this, insertActivity.class));
            }
        });
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        listPersonInfo=db.selectData();
        RecyclerviewAdapter adapter=new RecyclerviewAdapter(homeActivity.this, listPersonInfo,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onUserClick(PersonBean currentPerson, String action) {
        if(action.equals("Edit")){
            Intent intent = new Intent(homeActivity.this, updateActivity.class);
            intent.putExtra("judul", currentPerson.getJudul());
            intent.putExtra("deskripsi", currentPerson.getDeskripsi());

            startActivity(intent);
        }
        if(action.equals("Delete")){
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Yakin Menghapus Data?");
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    DatabaseHelper db=new DatabaseHelper(homeActivity.this);
                    db.delete(currentPerson.getJudul());
                    dialogInterface.dismiss();
                    setupRecyclerView();
                }
            });
            builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }
    }
}