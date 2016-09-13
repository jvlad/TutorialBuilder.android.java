package com.freeraven.tutorialbuilder.pagecomponent.title;

import com.freeraven.tutorialbuilder.pagecomponent.ComponentContent;
import com.freeraven.tutorialbuilder.pagecomponent.exception.IllegalaContentValueException;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class TitleContent extends ComponentContent{
    private String value;

    @Override
    protected String getValue() {
        return value;
    }

    @Override
    protected void setValue(Object value) {
        if (!(value instanceof String)){
            throw new IllegalaContentValueException();
        }
        this.value = (String) value;
    }
}
