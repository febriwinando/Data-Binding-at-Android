package com.example.recyclerviewdatawithdatabinding;

import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class User {
    public String name, email;
    public int imgId;

    public User(String name, String email, int imgId) {
        this.name = name;
        this.email = email;
        this.imgId = imgId;
    }

    @BindingAdapter("android:imageUrl")
    public static void loadImage(View view, int ImgId){
        CircleImageView circleImageView = (CircleImageView) view;
        circleImageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), ImgId));
    }
}
