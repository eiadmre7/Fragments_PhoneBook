package com.example.fragments_phonebook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPersonFrag extends Fragment {
EditText etName,etPhone;
Button btnAdd;
    public AddPersonFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_person, container, false);
        etName=view.findViewById(R.id.etName);
        etPhone=view.findViewById(R.id.etPhone);
        btnAdd=view.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty())
                    Toast.makeText(getContext(), "please fillup all fields !!!", Toast.LENGTH_SHORT).show();
                else {
                    MainActivity.people.add(new Person(etName.getText().toString().trim(), etPhone.getText().toString().trim()));
                    Toast.makeText(getContext(), "New person was added successfuly..", Toast.LENGTH_SHORT).show();
                    etName.setText(null);
                    etPhone.setText(null);
                    listFrag.notifyDataSetChanged();
                }
            }
        });
        return view;

    }
}