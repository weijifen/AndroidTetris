package com.uestc.androidtetris;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by dell on 2018/3/29.
 */

public class SelectActivity extends AppCompatActivity implements View.OnClickListener {
    Button grade1,grade2,grade3,grade4, grade5;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        grade1 = (Button) findViewById(R.id.grade1);
        grade2 = (Button) findViewById(R.id.grade2);
        grade3 = (Button) findViewById(R.id.grade3);
        grade4 = (Button) findViewById(R.id.grade4);
        grade5 = (Button) findViewById(R.id.grade5);

        grade1.setOnClickListener(this);
        grade2.setOnClickListener(this);
        grade3.setOnClickListener(this);
        grade4.setOnClickListener(this);
        grade5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SelectActivity.this, MainActivity.class);

        switch (v.getId()) {
            case R.id.grade1:
                intent.putExtra("grade", 1);
                break;
            case R.id.grade2:
                intent.putExtra("grade", 2);
                break;
            case R.id.grade3:
                intent.putExtra("grade", 3);
                break;
            case R.id.grade4:
                intent.putExtra("grade", 4);
                break;
            case R.id.grade5:
                intent.putExtra("grade", 5);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
