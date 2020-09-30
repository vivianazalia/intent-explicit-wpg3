package com.example.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edName, edInstitusi;
    Button btnPindahTanpaData, btnPindahData;

    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_INSTITUSI = "extra_institusi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.ed_nama);
        edInstitusi = findViewById(R.id.ed_institusi);

        btnPindahData = findViewById(R.id.btn_pindah_data);
        btnPindahTanpaData = findViewById(R.id.btn_pindah_tanpa_data);

        btnPindahTanpaData.setOnClickListener(this);
        btnPindahData.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pindah_data:
                PindahActivityData();
                break;
            case R.id.btn_pindah_tanpa_data:
                PindahActivityTanpaData();
                break;
            default:
                break;
        }
    }

    private void PindahActivityTanpaData() {
        Intent moveIntent = new Intent(MainActivity.this, SecondActivity.class);

        startActivity(moveIntent);
    }

    private void PindahActivityData() {
        String nama = edName.getText().toString().trim();
        String institusi = edInstitusi.getText().toString().trim();
        Intent moveIntentWithData = new Intent(MainActivity.this, SecondActivity.class);

        moveIntentWithData.putExtra(this.EXTRA_NAMA, nama);
        moveIntentWithData.putExtra(this.EXTRA_INSTITUSI, institusi);

        startActivity(moveIntentWithData);
    }
}