package com.freeraven.tutorialbuilder.data.provider.convert.json.property;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/17/16.
 */
public class SubtitleJsonProperty implements JsonProperty {
    public static JsonProperty getInstance() {
        return new SubtitleJsonProperty();
    }

    @Override
    public String getName() {
        return "subtitle";
    }

    @Override
    public Class getType() {
        return String.class;
    }

    @Override
    public boolean isMandatory() {
        return false;
    }

    @Override
    public boolean isProhibited() {
        return false;
    }
}
