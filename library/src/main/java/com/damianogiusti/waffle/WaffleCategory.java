package com.damianogiusti.waffle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damiano Giusti on 24/05/17.
 */
public class WaffleCategory {

    private List<WafflePreference> wafflePreferences;

    public static class Builder {
        private WaffleCategory category;

        public Builder() {
            this.category = new WaffleCategory();
        }

        public Builder add(WafflePreference wafflePreference) {
            this.category.wafflePreferences.add(wafflePreference);
            return this;
        }

        public WaffleCategory build() {
            return this.category;
        }
    }

    private WaffleCategory() {
        this.wafflePreferences = new ArrayList<>();
    }
}
