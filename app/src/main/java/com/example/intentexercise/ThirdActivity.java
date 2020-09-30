package com.example.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvTampilNama;
    Button btnActivitySatu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvTampilNama = findViewById(R.id.tv_tampil_nama);
        btnActivitySatu = findViewById(R.id.btn_activity_satu);

        btnActivitySatu.setOnClickListener(this);

        String nama = getIntent().getStringExtra(MainActivity.EXTRA_NAMA);

        if (TextUtils.isEmpty(nama)) {
            tvTampilNama.setText("Nama saya ");
        } else {
            tvTampilNama.setText("Nama saya " + nama);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_activity_satu) {
            ActivitySatu();
        }
    }

    private void ActivitySatu() {
        Intent activitySatu = new Intent(ThirdActivity.this, MainActivity.class);

        startActivity(activitySatu);
    }
}