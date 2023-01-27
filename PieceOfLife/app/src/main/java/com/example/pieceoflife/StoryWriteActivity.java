package com.example.pieceoflife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class StoryWriteActivity extends AppCompatActivity {
    //private TextView age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_write);

        /*age=findViewById(R.id.textView48);
        Intent intent_data = getIntent();
        String input=intent_data.getStringExtra("age");
        if (input!=null)
            age.setText(input);*/

        //이 파트가 api 이용해서 답변 저장, 질문 새로고침 해야함. 일단 skip.
        /*Button next = (Button) findViewById(R.id.button_next); //다음 질문 새로고침
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), );
                startActivity(intent); //다음 화면 띄우기
            }
        });*/

        ImageButton back = (ImageButton) findViewById(R.id.button_back); //뒤로가기
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TagPersonActivity.class);
                startActivity(intent); //다음 Tag 화면 띄우기
            }
        });

        Button stop = (Button) findViewById(R.id.button_finish); //이야기 그만하기
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SaveTitleActivity.class);
                startActivity(intent); //다음 화면 띄우기
            }
        });

        Button skip = (Button) findViewById(R.id.button_skip_question); //이야기 건너뛰기
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SaveTitleActivity.class);
                startActivity(intent); //다음 화면 띄우기
            }
        });
    }
}