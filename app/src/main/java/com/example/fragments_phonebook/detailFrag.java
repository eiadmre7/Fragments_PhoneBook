package com.example.fragments_phonebook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class detailFrag extends Fragment {
private TextView tvName;
private TextView tvPhone;
private ImageView ivContact;

    public detailFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detail, container, false);
        //init views in DetailContainerView.
        tvName=view.findViewById(R.id.tvName);
        tvPhone=view.findViewById(R.id.tvPhone);
        ivContact=view.findViewById(R.id.ivContact);
        ivContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNum=tvPhone.getText().toString().trim();
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNum));
                startActivity(intent);
            }
        });
        return view;
    }
    public void updateTexts(String st1,String st2){
       tvName.setText(st1);
       tvPhone.setText(st2);
    }
}