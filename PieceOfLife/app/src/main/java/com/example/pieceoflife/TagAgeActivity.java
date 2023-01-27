package com.example.pieceoflife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class TagAgeActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_age);
        editText = findViewById(R.id.editText_age);

        ImageButton back = (ImageButton) findViewById(R.id.button_back); //뒤로가기
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainIntroActivity.class);
                startActivity(intent); //다음 Tag 화면 띄우기
            }
        });

        Button next = (Button) findViewById(R.id.button_next); //다음
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TagYearActivity.class);
                String input = editText.getText().toString(); //텍스트 입력값 받아옴
                startActivity(intent); //다음 Tag 화면 띄우기
            }
        });

        Button skip = (android.widget.Button) findViewById(R.id.button_skip_question); //이야기 건너뛰기
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TagYearActivity.class);
                startActivity(intent); //다음 화면 띄우기
            }
        });
    }
}