package com.example.my07_alllayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1,imageView2,imageView3, image1;
    Button ImgBtn,btnImg;
    int cnt = 2;
    boolean selImg = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImgBtn = findViewById(R.id.ImgBtn);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);

        imageView1.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.GONE);
        imageView3.setVisibility(View.GONE);

        ImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cnt == 1){
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.GONE);
                    imageView3.setVisibility(View.GONE);
                    cnt=2;
                }else if (cnt ==2) {
                    imageView1.setVisibility(View.GONE);
                    imageView2.setVisibility(View.VISIBLE);
                    imageView3.setVisibility(View.GONE);
                    cnt=3;
                }else if (cnt == 3){
                    imageView1.setVisibility(View.GONE);
                    imageView2.setVisibility(View.GONE);
                    imageView3.setVisibility(View.VISIBLE);
                    cnt=1;
                }
            }
        });//ImgBtn.setOnClickListener

        image1 = findViewById(R.id.image1);
        btnImg = findViewById(R.id.btnImg);
        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selImg == true){
                    image1.setImageResource(R.drawable.image02);
                    selImg = false;
                }else{
                    image1.setImageResource(R.drawable.image01);
                    selImg = true;
                }



            }
        });

    }
}