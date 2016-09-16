package com.freeraven.tutorialbuilder.pagecomponent.title;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.freeraven.tutorialbuilder.R;
import com.freeraven.tutorialbuilder.pagecomponent.PageComponent;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class TitleComponent extends PageComponent {
    private TitleContent content;

    public void setContent(TitleContent content) {
        this.content = content;
    }

    // We can abstract from Android-specific mechanism of getting the view.
    // E. g. by introducing
    // 1. our own View type,
    // 2. renderMechanism type
    // 3. ViewSkinURI type
    // But because of I am building Android app, it seems like overhead.
    @Override
    public View render(LayoutInflater inflater, LinearLayout rootView) {
        TextView rendered = (TextView) inflater.inflate(R.layout.title_component, rootView, false);
        rendered.setText(content.getValue());
        return rendered;
    }
}
