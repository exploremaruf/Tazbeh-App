package com.penguinlabs.digitaltazbeh;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    AppCompatButton add, sub, reset;
    int count = 0;

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

        tv = findViewById(R.id.tv);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        reset = findViewById(R.id.reset);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count + 1;
                tv.setText("" + count);

            }
        });


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (count>0){
                   count = count - 1;
                   tv.setText("" + count);
               }
               else {
                   count = 0;
                   tv.setText("" + count);
               }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count>0){
                    count = 0;
                    tv.setText("" + count);
                }
                else {
                    Toast.makeText(MainActivity.this, "Counter is already at zero", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}