package com.example.my31_recyclerview3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CitizenAdapter extends RecyclerView.Adapter<CitizenAdapter.ViewHolder> implements OnCitizenitemClickListener{

    private static final String TAG = "main: CitizenAdapter";

    //1.리스너 선언
    OnCitizenitemClickListener listener;

    //메인에서 넘겨받는 것
    ArrayList<CitizenDto> dtos;
    Context context;

    LayoutInflater inflater;

    public CitizenAdapter(ArrayList<CitizenDto> dtos, Context context){
        this.dtos = dtos;
        this.context = context;

        inflater = LayoutInflater.from(this.context);
    }

    //화면을 인플레이트
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.citizenview,
                parent,false);
        return new ViewHolder(itemView);
    }

    //화면에 데이터 셋팅
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);

        CitizenDto dto = dtos.get(position);
        holder.setDto(dto);

        holder.ivTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeDto(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dtos.size();
    }

    public void addDto(CitizenDto dto){dtos.add(dto);}

    //6. 메인에서 클릭한 위치에 있는 dto 가져오기
    public CitizenDto getItm(int position){
        return dtos.get(position);
    }

    //4. 메인에서 클릭리스너를 클릭했을 때 어댑터의 리스너와 연결해준다.
    public void setOnClickListener(OnCitizenitemClickListener listener){
        this.listener = listener;
    }


    public void removeDto(int position){
        dtos.remove(position);
    }

    //5. 뷰홀더의 클릭리스너를 실행해 클릭한 위치를 메인에게 알려준다.


    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //CitizenView에 있는 위젯을 정의
        TextView tvName, tvCharacter,tvSpecies;
        ImageView ivImage, ivTrash;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.parentLayout);
            tvName = itemView.findViewById(R.id.tvName);
            tvCharacter = itemView.findViewById(R.id.tvCharacter);
            tvSpecies = itemView.findViewById(R.id.tvSpecies);
            ivImage = itemView.findViewById(R.id.ivImage);
            ivTrash = itemView.findViewById(R.id.ivTrash);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int postion = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this,
                                view, postion);
                    }
                }
            });

        }

        public void setDto(CitizenDto dto){
            tvName.setText(dto.getName());
            tvCharacter.setText(dto.getCharacter());
            tvSpecies.setText(dto.getSpecies());
            ivImage.setImageResource(dto.getResId());
        }
    }
}
