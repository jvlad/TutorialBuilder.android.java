package com.freeraven.tutorialbuilder.data.provider.convert.json;

import com.freeraven.tutorialbuilder.data.provider.convert.json.property.ContentJsonProperty;
import com.freeraven.tutorialbuilder.data.provider.convert.json.property.ContentTypeJsonProperty;
import com.freeraven.tutorialbuilder.data.provider.convert.json.property.JsonProperty;
import com.freeraven.tutorialbuilder.data.provider.convert.json.property.PagesJsonProperty;
import com.freeraven.tutorialbuilder.data.provider.convert.json.property.SubtitleJsonProperty;
import com.freeraven.tutorialbuilder.data.provider.convert.json.property.TitleJsonProperty;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/17/16.
 */
public class JsonAPI {
    public static final JsonProperty PAGE_LIST_ROOT = PagesJsonProperty.getInstance();

    public static final class Page {
        public static final JsonProperty TITLE = TitleJsonProperty.getInstance();
        public static final JsonProperty SUBTITLE = SubtitleJsonProperty.getInstance();
        public static final JsonProperty CONTENT_TYPE = ContentTypeJsonProperty.getInstance();
        public static final JsonProperty CONTENT = ContentJsonProperty.getInstance();
    }
}
