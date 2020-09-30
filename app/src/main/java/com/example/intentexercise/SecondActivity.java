package com.example.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvNama, tvInstitusi;
    String nama, institusi;
    Button btnActivityTiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvNama = findViewById(R.id.tv_nama);
        tvInstitusi = findViewById(R.id.tv_institusi);

        btnActivityTiga = findViewById(R.id.btn_activity_tiga);

        btnActivityTiga.setOnClickListener(this);

        nama = getIntent().getStringExtra(MainActivity.EXTRA_NAMA);
        institusi = getIntent().getStringExtra(MainActivity.EXTRA_INSTITUSI);

        if (TextUtils.isEmpty(nama)) {
            tvNama.setText("Nama : ");
        } else {
            tvNama.setText("Nama : " + nama);
        }

        if (TextUtils.isEmpty(institusi)) {
            tvInstitusi.setText("Institusi : ");
        } else {
            tvInstitusi.setText("Institusi : " + institusi);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_activity_tiga) {
            ActivityTiga();
        }
    }

    private void ActivityTiga() {
        Intent activityTiga = new Intent(SecondActivity.this, ThirdActivity.class);

        activityTiga.putExtra(MainActivity.EXTRA_NAMA, nama);

        startActivity(activityTiga);
    }
}