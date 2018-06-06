package com.example.aa.jinjikk_proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button test = (Button) findViewById(R.id.testButton);
        Button memory = (Button) findViewById(R.id.memoryButton);
        Button pitch = (Button) findViewById(R.id.pithButton);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),testcode.class);
                startActivity(intent);
            }
        });
     }

}
