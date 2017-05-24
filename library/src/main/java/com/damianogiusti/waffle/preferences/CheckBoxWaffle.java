package com.damianogiusti.waffle.preferences;

import android.content.Context;
import android.widget.CheckBox;

import com.damianogiusti.waffle.WafflePreference;

/**
 * Created by Damiano Giusti on 24/05/17.
 */
public class CheckBoxWaffle extends WafflePreference {

    private CheckBox checkBox;

    public CheckBoxWaffle(Context context) {
        super(context);
    }

    @Override
    protected void setupView(Context context) {
        super.setupView(context);
        checkBox = new CheckBox(context);
        controlContainer.addView(checkBox);
    }

    @Override
    protected void onPreferenceClicked() {
        checkBox.toggle();
    }
}
