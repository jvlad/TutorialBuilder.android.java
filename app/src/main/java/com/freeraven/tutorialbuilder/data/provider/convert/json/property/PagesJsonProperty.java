package com.freeraven.tutorialbuilder.data.provider.convert.json.property;

import org.json.JSONArray;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/17/16.
 */
public class PagesJsonProperty implements JsonProperty {
    public static JsonProperty getInstance() {
        return new PagesJsonProperty();
    }

    @Override
    public String getName() {
        return "pages";
    }

    @Override
    public Class getType() {
        return JSONArray.class;
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
