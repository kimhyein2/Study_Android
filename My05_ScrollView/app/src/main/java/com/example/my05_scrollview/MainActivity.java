package com.example.my05_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnImg;                                      //전역변수 선언
    ImageView imageView;
    Boolean setImg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImg = findViewById(R.id.btnImg);                         //이미지 바꾸기 버튼 찾기
        imageView = findViewById(R.id.imageView);                   // 이미지 뷰 찾기

        btnImg.setOnClickListener(new View.OnClickListener() {      //이미지 바꾸기 버튼 클릭했을때
            @Override
            public void onClick(View v) {
                if(setImg == true){
                    imageView.setImageResource(R.drawable.image02);
                    setImg = false;
                }else{
                    imageView.setImageResource(R.drawable.image01);
                    setImg = true;
                }



            }
        });

    }//onCreate

}//MainActivity