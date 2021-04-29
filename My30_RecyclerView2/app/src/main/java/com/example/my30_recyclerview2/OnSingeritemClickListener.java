package com.example.my30_recyclerview2;

import android.view.View;

public interface OnSingeritemClickListener {
    public void onItemClick(SingerAdapter.ViewHolder holder,
                            View view, int position);
}
