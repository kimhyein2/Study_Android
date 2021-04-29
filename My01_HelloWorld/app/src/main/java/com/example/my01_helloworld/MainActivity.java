package com.example.my01_helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etPhoneNum;
    Button btnCall, btnSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml에 디자인한 위젯을 찾는다.
        etPhoneNum = findViewById(R.id.editText);
        btnCall = findViewById(R.id.BtnCall);
        btnSub = findViewById(R.id.BtnSub);
        // 찾은 위젯에 클릭리스너를 달아준다.
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNum = "tel:" + etPhoneNum.getText().toString();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNum));
                startActivity(intent);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                            //MainActivity.this, getApplicationContext() , this
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });



    }

    public void onBtn1Clicked(View view){
        Toast.makeText(this, "버튼을 클릭했다", Toast.LENGTH_SHORT).show();
    }

    public void onBtnNaverClicked(View view){
        //창을 새로 열려면 intent를 만들어 줘야함 내가만든 activity는 명시적intent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));

        startActivity(intent);

    }




}