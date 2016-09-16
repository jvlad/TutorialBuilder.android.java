package com.freeraven.tutorialbuilder.pagecomponent.image;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.freeraven.tutorialbuilder.R;
import com.freeraven.tutorialbuilder.pagecomponent.PageComponent;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class ImageComponent extends PageComponent {
    private ImageContent content;

    public void setContent(ImageContent content) {
        this.content = content;
    }

    @Override
    public View render(LayoutInflater inflater, LinearLayout rootView) {
        ImageView rendered = (ImageView) inflater.inflate(R.layout.image_component, rootView, false);
//        ImageView image = (ImageView) rendered.findViewById(R.id.image);
        return rendered;
    }
}
