package com.example.helloconstraint;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int mCount;
    private Button btnToast;
    private Button btnCount;
    private Button btnZero;
    private TextView txtCount;
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
        btnToast = (Button) findViewById(R.id.button_toast);
        btnCount = (Button) findViewById(R.id.button_count);
        btnZero = (Button) findViewById(R.id.button_zero);
        txtCount = (TextView) findViewById(R.id.show_count);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(MainActivity.this, R.string.toast_message, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++mCount;
                btnZero.setBackgroundColor(Color.parseColor("#E91E63"));
                if (mCount % 2 == 0) {
                    view.setBackgroundColor(Color.parseColor("#4CAF50"));
                } else {
                    view.setBackgroundColor(Color.parseColor("#F44336"));
                }
                if (txtCount != null) {
                    txtCount.setText(Integer.toString(mCount));
                }
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setBackgroundColor(Color.parseColor("#ABABAB"));
                btnCount.setBackgroundColor(Color.parseColor("#4CAF50"));
                mCount = 0;
                txtCount.setText(Integer.toString(mCount));
            }
        });


    }
}