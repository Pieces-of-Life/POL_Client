package com.example.pieceoflife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SaveIntroActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_intro);

        ImageButton back = (ImageButton) findViewById(R.id.button_back); //뒤로가기
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SaveTitleActivity.class);
                startActivity(intent); //다음 Tag 화면 띄우기
            }
        });
        Button next = (Button) findViewById(R.id.button_next); //다음
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SaveColorActivity.class);
                startActivity(intent); //다음 화면 띄우기
            }
        });
    }
}