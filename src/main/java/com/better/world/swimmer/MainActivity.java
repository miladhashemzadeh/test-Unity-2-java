package com.better.world.swimmer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText x = findViewById(R.id.x);
        final EditText y = findViewById(R.id.y);
        final EditText z = findViewById(R.id.z);
        final CheckBox l = findViewById(R.id.leftcb);
        final CheckBox r = findViewById(R.id.rightcb);

        findViewById(R.id.swim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String s = String.format("%s,%s,%s",
                        x.getText().toString(), y.getText().toString(), z.getText().toString());

                findViewById(R.id.swim)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity.this, UnityPlayerActivity.class);

                                if (l.isChecked())
                                    intent.putExtra("leftaxies", s);
                                if (r.isChecked())
                                    intent.putExtra("rightaxies", s);

                                startActivity(intent);
                            }
                        });

            }
        });

    }

}