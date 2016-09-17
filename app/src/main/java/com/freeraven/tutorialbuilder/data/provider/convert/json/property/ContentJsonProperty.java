package com.freeraven.tutorialbuilder.data.provider.convert.json.property;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/17/16.
 */
public class ContentJsonProperty implements JsonProperty {
    public static JsonProperty getInstance() {
        return new ContentJsonProperty();
    }

    @Override
    public String getName() {
        return "content";
    }

    @Override
    public Class getType() {
        return String.class;
    }

    @Override
    public boolean isMandatory() {
        return true;
    }

    @Override
    public boolean isProhibited() {
        return false;
    }
}
