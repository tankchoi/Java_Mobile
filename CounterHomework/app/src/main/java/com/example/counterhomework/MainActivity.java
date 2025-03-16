package com.example.counterhomework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnCount;
    private TextView txtCount;
    private int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnCount = findViewById(R.id.btn_count);
        txtCount = findViewById(R.id.txt_count);
        if (savedInstanceState != null) {
            number = savedInstanceState.getInt("number");
        }
        txtCount.setText(Integer.toString(number));
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                txtCount.setText(Integer.toString(number));
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("number",number);
    }

}