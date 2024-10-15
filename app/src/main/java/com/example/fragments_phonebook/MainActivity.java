package com.example.fragments_phonebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemSelected {
    TextView tvName,tvPhone,tvDate;
    EditText etName,etPhone;
    ImageView ivContact;
    Button btnAdd;
    String CurrentDate;
    Calendar calendar=Calendar.getInstance();
    FragmentManager fragmentManager;
    listFrag listFrag;
    FragmentContainerView containerViewPerson, containerViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //sets the current date
        CurrentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        tvDate.setText(CurrentDate);
        listFrag =(listFrag)fragmentManager.findFragmentById(R.id.listFrag);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "please fillup all fields !!!", Toast.LENGTH_SHORT).show();
                else {
                    ApplicationClass.people.add(new Person(etName.getText().toString().trim(), etPhone.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "New person was added successfuly..", Toast.LENGTH_SHORT).show();
                    etName.setText(null);
                    etPhone.setText(null);
                    listFrag.notifyDataSetChanged();
                }
            }
        });
        onItemClicked(0);
        ivContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone=tvPhone.getText().toString().trim();
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        tvDate=findViewById(R.id.tvdate);
        fragmentManager=this.getSupportFragmentManager();
        //init views in PersonContainerView.
        containerViewPerson=findViewById(R.id.addPersonFrag);
        etName=containerViewPerson.findViewById(R.id.etName);
        etPhone=containerViewPerson.findViewById(R.id.etPhone);
        btnAdd=containerViewPerson.findViewById(R.id.btnAdd);
        //init views in DetailContainerView.
        containerViewDetail=findViewById(R.id.detailFrag);
        tvName=containerViewDetail.findViewById(R.id.tvName);
        tvPhone=containerViewDetail.findViewById(R.id.tvPhone);
        ivContact=containerViewDetail.findViewById(R.id.ivContact);
    }

    @Override
    public void onItemClicked(int Index) {
        if(ApplicationClass.people.size()==0)
            return;
        tvName.setText(ApplicationClass.people.get(Index).getName());
        tvPhone.setText(ApplicationClass.people.get(Index).getPhone());
    }
}