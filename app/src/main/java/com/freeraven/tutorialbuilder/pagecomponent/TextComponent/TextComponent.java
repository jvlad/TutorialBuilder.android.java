package com.freeraven.tutorialbuilder.pagecomponent.TextComponent;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.freeraven.tutorialbuilder.R;
import com.freeraven.tutorialbuilder.pagecomponent.PageComponent;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class TextComponent extends PageComponent {
    private TextContent content;

    public void setContent(TextContent content) {
        this.content = content;
    }

    @Override
    public View render(LayoutInflater inflater, LinearLayout rootView) {
        TextView rendered = (TextView) inflater.inflate(R.layout.text_component, rootView, false);
        rendered.setText(content.getValue());
        return rendered;
    }
}
