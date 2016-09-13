package com.freeraven.tutorialbuilder.pagecomponent;

import android.view.View;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public abstract class PageComponent {
    protected abstract ComponentName getName();
    protected abstract void setName(ComponentName name);
    protected abstract ComponentContent getContent();
    protected abstract void setContent(ComponentContent content);
    protected abstract View getView();
}
