package com.damianogiusti.waffle.preferences;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;

import com.damianogiusti.waffle.WafflePreference;

/**
 * Created by Damiano Giusti on 24/05/17.
 */
public class CheckBoxWaffle extends WafflePreference {

    public CheckBoxWaffle(Context context) {
        super(context);
    }

    @Override
    protected void setupView(Context context) {
        super.setupView(context);
        controlContainer.addView(new AppCompatCheckBox(context));
    }
}
