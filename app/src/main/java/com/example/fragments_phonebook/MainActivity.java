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
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemSelected {
    public static ArrayList<Person> people;
    TextView tvDate;
    String CurrentDate;
    Calendar calendar=Calendar.getInstance();
    FragmentManager fragmentManager;
    listFrag listFrag;
    detailFrag detailFrag;
    FragmentContainerView containerViewPerson, containerViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDate=findViewById(R.id.tvdate);
        fragmentManager=this.getSupportFragmentManager();
        //sets the current date
        CurrentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        tvDate.setText(CurrentDate);
        listFrag =(listFrag)fragmentManager.findFragmentById(R.id.listFrag);
        initPeople();
        detailFrag = (detailFrag) fragmentManager.findFragmentById(R.id.detailFrag);
        //detailFrag.updateTexts(people.get(0).getName(), people.get(0).getPhone());
    }

    private void initPeople() {
        people=new ArrayList<>();
        people.add(new Person("Adil Emam","0526487952"));
        people.add(new Person("Ahmad Zake","0526487666"));
        people.add(new Person("Yonis Shalaby","0526487333"));
        people.add(new Person("Saeed Salih","0526487111"));
        people.add(new Person("Adel Emam","0526487952"));
        people.add(new Person("Ahmad Zake","0526487666"));
        people.add(new Person("Yonis Shalaby","0526487333"));
        people.add(new Person("Saeed Salih","0526487111"));
    }

    @Override
    public void onItemClicked(int Index) {
        if(!people.isEmpty()) {
            detailFrag.updateTexts(people.get(Index).getName(), people.get(Index).getPhone());
        }
        else
            return ;
    }
}