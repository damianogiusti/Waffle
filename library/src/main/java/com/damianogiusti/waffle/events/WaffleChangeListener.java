package com.damianogiusti.waffle.events;

import com.damianogiusti.waffle.WafflePreference;

/**
 * Created by Damiano Giusti on 24/05/17.
 */
public interface WaffleChangeListener {

    boolean onWafflePrefenceChanging(WafflePreference preference);

    boolean onWafflePreferenceChanged(WafflePreference preference);
}
