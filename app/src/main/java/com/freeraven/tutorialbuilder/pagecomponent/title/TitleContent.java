package com.freeraven.tutorialbuilder.pagecomponent.title;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
// TODO: 9/19/16 consider to make all componentContent classes not public
public class TitleContent{
    private String value;

    String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = (String) value;
    }
}
