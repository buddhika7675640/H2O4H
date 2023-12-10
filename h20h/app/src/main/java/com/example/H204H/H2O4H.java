package com.example.H204H;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.H204H.databinding.ActivityH2O4HBinding;
import com.example.H204H.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class H2O4H extends AppCompatActivity {

    int i =24;

private ActivityH2O4HBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (i<25){
            openDialog2();
        }





        binding = ActivityH2O4HBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);




    }
    public void openDialog2(){

        lpopup ef = new lpopup();
        ef.show(getSupportFragmentManager(),"ex dialog");

    }
}