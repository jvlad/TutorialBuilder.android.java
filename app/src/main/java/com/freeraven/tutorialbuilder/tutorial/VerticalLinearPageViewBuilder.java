package com.freeraven.tutorialbuilder.tutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.freeraven.tutorialbuilder.R;
import com.freeraven.tutorialbuilder.pagecomponent.PageComponent;
import com.freeraven.tutorialbuilder.pagemodel.PageModel;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class VerticalLinearPageViewBuilder {

    public View buildPage(PageModel pageModel, ViewGroup container, LayoutInflater inflater) {
        ViewGroup parentView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        LinearLayout linearLayout = (LinearLayout) parentView.getChildAt(0);
        for (PageComponent component : (Iterable<PageComponent>) pageModel) {
            View rendered = component.render(inflater, linearLayout);
            linearLayout.addView(rendered);
        }
        return parentView;
    }
}
