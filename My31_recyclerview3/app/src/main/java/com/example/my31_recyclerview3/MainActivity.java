package com.example.my31_recyclerview3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CitizenAdapter adapter;
    ArrayList<CitizenDto> dtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dtos = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);

        //리사이클러뷰에서 초기화
        LinearLayoutManager layoutManager = new LinearLayoutManager(
          this, RecyclerView.VERTICAL, false
        );
        recyclerView.setLayoutManager(layoutManager);

        //어댑터 객체 생성
        adapter = new CitizenAdapter(dtos, MainActivity.this);

        adapter.addDto(new CitizenDto("뽀야미", "친절함", "햄스터", R.drawable.citizen1));
        adapter.addDto(new CitizenDto("쭈니", "느끼함", "다람쥐", R.drawable.citizen2));
        adapter.addDto(new CitizenDto("애플", "아이돌", "햄스터", R.drawable.citizen3));
        adapter.addDto(new CitizenDto("패치", "먹보", "아기곰", R.drawable.citizen4));

        //리스트뷰에 붙인다.
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new OnCitizenitemClickListener() {
            @Override
            public void onItemClick(CitizenAdapter.ViewHolder holder, View view, int position) {
                CitizenDto dto = adapter.getItm(position);

                Toast.makeText(MainActivity.this, dto.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}