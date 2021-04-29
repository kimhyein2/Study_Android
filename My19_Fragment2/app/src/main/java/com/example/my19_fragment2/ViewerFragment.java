package com.example.my19_fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewerFragment extends Fragment {
    ImageView imageView;
    MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_viewer,
                                                container, false);

        activity = (MainActivity) getActivity();
        imageView = viewGroup.findViewById(R.id.imageView);




        return viewGroup;

    }
    public void ImgChanged(int resId){

        imageView.setImageResource(resId);

    }
}
