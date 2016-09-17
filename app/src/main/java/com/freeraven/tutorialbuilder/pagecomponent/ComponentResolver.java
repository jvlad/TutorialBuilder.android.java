package com.freeraven.tutorialbuilder.pagecomponent;

import com.freeraven.tutorialbuilder.pagecomponent.image.ImageComponent;
import com.freeraven.tutorialbuilder.pagecomponent.text.TextComponent;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/17/16.
 */
public class ComponentResolver {
    public static PageComponent getComponent(String contentType, String rowContentData) {
        switch (contentType) {
            case "text":
                return TextComponent.newInstance(rowContentData);
            case "image":
                return ImageComponent.newInstance(rowContentData);
            default:
                throw new UnsupportedContentTypeException();
        }
    }
}
