package com.damianogiusti.waffle;

import android.content.Context;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.CallSuper;
import android.support.annotation.DimenRes;
import android.support.annotation.IdRes;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.damianogiusti.waffle.events.WaffleChangeListener;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by Damiano Giusti on 24/05/17.
 */
public abstract class WafflePreference extends RelativeLayout {

    @IdRes protected static final int TITLE_ID = 10;
    @IdRes protected static final int SUBTITLE_ID = 20;
    @IdRes protected static final int CONTAINER_ID = 30;

    protected TextView titleTextView;
    protected TextView subtitleTextView;
    protected LinearLayout controlContainer;

    protected WaffleChangeListener waffleChangeListener;

    public WafflePreference(Context context) {
        super(context);
        setupView(context);
    }

    @CallSuper
    protected void setupView(Context context) {
        LayoutParams layoutParams = new LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        setLayoutParams(layoutParams);
        setMinimumHeight(dimen(R.dimen.list_item_height));
        setBackgroundResource(resIdFromTypedValue(android.R.attr.selectableItemBackground));

        int horizontalPadding = dimen(R.dimen.list_item_padding_horizontal);
        int verticalPadding = dimen(R.dimen.list_item_padding_vertical);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setPaddingRelative(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
        } else {
            setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
        }

        titleTextView = defaultTextView(context);
        titleTextView.setId(TITLE_ID);
        subtitleTextView = defaultTextView(context);
        subtitleTextView.setId(SUBTITLE_ID);
        controlContainer = new LinearLayout(context);
        controlContainer.setId(CONTAINER_ID);
        controlContainer.setOrientation(LinearLayout.VERTICAL);

        // control container
        LayoutParams controlContainerLayoutParams = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        controlContainerLayoutParams.addRule(CENTER_VERTICAL, TRUE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            controlContainerLayoutParams.addRule(ALIGN_PARENT_END, RelativeLayout.TRUE);
            controlContainerLayoutParams.setMarginStart(horizontalPadding);
        } else {
            controlContainerLayoutParams.addRule(ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            controlContainerLayoutParams.leftMargin = horizontalPadding;
        }
        controlContainer.setLayoutParams(controlContainerLayoutParams);
        addView(controlContainer);

        // title
        LinearLayout.LayoutParams titleLayoutParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        titleTextView.setLayoutParams(titleLayoutParams);
        titleTextView.setText("Title");

        // subtitle
        LinearLayout.LayoutParams subtitleLayoutParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        subtitleTextView.setLayoutParams(subtitleLayoutParams);
        subtitleTextView.setText("Subtitle");

        LinearLayout linearLayout = new LinearLayout(context);
        LayoutParams linearLayoutLayoutParams = new LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        linearLayoutLayoutParams.addRule(ALIGN_PARENT_TOP, TRUE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            linearLayoutLayoutParams.addRule(ALIGN_PARENT_START, TRUE);
            linearLayoutLayoutParams.setMarginStart(horizontalPadding);

            linearLayoutLayoutParams.addRule(START_OF, CONTAINER_ID);
        } else {
            linearLayoutLayoutParams.addRule(ALIGN_PARENT_LEFT, TRUE);
            linearLayoutLayoutParams.leftMargin = horizontalPadding;

            linearLayoutLayoutParams.addRule(LEFT_OF, CONTAINER_ID);
        }
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(CENTER_VERTICAL);

        linearLayout.addView(titleTextView);
        linearLayout.addView(subtitleTextView);
        addView(linearLayout);
    }

    public void setWaffleChangeListener(WaffleChangeListener waffleChangeListener) {
        this.waffleChangeListener = waffleChangeListener;
    }

    protected int dimen(@DimenRes int resId) {
        return getResources().getDimensionPixelSize(resId);
    }

    protected int resIdFromTypedValue(@AttrRes int id) {
        TypedValue outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(id, outValue, true);
        return outValue.resourceId;
    }

    protected TextView defaultTextView(Context context) {
        TextView textView = new TextView(context);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, dimen(R.dimen.font_16sp));
        return textView;
    }
}
