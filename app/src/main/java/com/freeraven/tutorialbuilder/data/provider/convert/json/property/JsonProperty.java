package com.freeraven.tutorialbuilder.data.provider.convert.json.property;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/17/16.
 */
public interface JsonProperty {

    String getName();

    Class getType();

    boolean isMandatory();

    boolean isProhibited();
}
