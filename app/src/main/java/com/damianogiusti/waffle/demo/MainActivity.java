package com.damianogiusti.waffle.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.damianogiusti.waffle.WafflePreference;
import com.damianogiusti.waffle.preferences.CheckBoxWaffle;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        WafflePreference checkBoxPreference = new CheckBoxWaffle(this);
        linearLayout.addView(checkBoxPreference);
    }
}
