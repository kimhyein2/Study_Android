package com.example.my19_fragment2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    MainActivity activity;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_list,
                                                        container,false);

            viewGroup.findViewById(R.id.btnimg1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //메인 메소드에 접근
                    activity.onImageSelected(R.drawable.dream01);
                }
            });

            viewGroup.findViewById(R.id.btnimg2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //메인 메소드에 접근
                    activity.onImageSelected(R.drawable.dream02);
                }
            });
        return viewGroup;
    }
}
