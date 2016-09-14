package com.freeraven.tutorialbuilder.pagecomponent;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.freeraven.tutorialbuilder.pagecomponent.title.TitleContent;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public abstract class PageComponent {
    public abstract View render(LayoutInflater inflater, LinearLayout rootView);
}
