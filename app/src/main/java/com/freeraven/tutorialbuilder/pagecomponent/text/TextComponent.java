package com.freeraven.tutorialbuilder.pagecomponent.text;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.freeraven.tutorialbuilder.R;
import com.freeraven.tutorialbuilder.pagecomponent.PageComponent;
import com.freeraven.tutorialbuilder.pagecomponent.title.TitleComponent;
import com.freeraven.tutorialbuilder.pagecomponent.title.TitleContent;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class TextComponent implements PageComponent {
    private TextContent content;

    public void setContent(TextContent content) {
        this.content = content;
    }

    public static PageComponent newInstance(String rowContentData) {
        TextContent body = new TextContent();
        body.setValue(rowContentData);
        TextComponent component = new TextComponent();
        component.setContent(body);
        return component;
    }

    @Override
    public View render(LayoutInflater inflater, LinearLayout rootView) {
        TextView rendered = (TextView) inflater.inflate(R.layout.text_component, rootView, false);
        rendered.setText(content.getValue());
        return rendered;
    }
}
