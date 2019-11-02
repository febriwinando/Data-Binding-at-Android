package com.example.recyclerviewdatawithdatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.recyclerviewdatawithdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding activityMainBinding;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerView.setHasFixedSize(true);

        recyclerAdapter = new RecyclerAdapter(this, prepareUser());
        activityMainBinding.recyclerView.setAdapter(recyclerAdapter);

    }

    private List<User> prepareUser(){
        List<String> names = Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> email = Arrays.asList(getResources().getStringArray(R.array.rmail));
        int[] imageId = {R.drawable.people, R.drawable.people, R.drawable.people, R.drawable.people,
                R.drawable.people, R.drawable.people, R.drawable.people, R.drawable.people, R.drawable.people,
        };

        List<User> Names = new ArrayList<>();
        int count = 0;

        for (String name : names){
            Names.add(new User(name, email.get(count), imageId[count]));
            count++;
        }

        return Names;

    }
}
