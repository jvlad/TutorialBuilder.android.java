package com.freeraven.tutorialbuilder.data.provider.convert.json;

import com.freeraven.tutorialbuilder.data.RowData;
import com.freeraven.tutorialbuilder.data.provider.convert.RowPageListDataConvertException;
import com.freeraven.tutorialbuilder.data.provider.convert.PageListDataConverter;
import com.freeraven.tutorialbuilder.data.provider.convert.json.property.JsonProperty;
import com.freeraven.tutorialbuilder.pagecomponent.ComponentResolver;
import com.freeraven.tutorialbuilder.pagecomponent.subtitle.SubtitleComponent;
import com.freeraven.tutorialbuilder.pagecomponent.title.TitleComponent;
import com.freeraven.tutorialbuilder.pagemodel.PageListModel;
import com.freeraven.tutorialbuilder.pagemodel.PageModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/17/16.
 */
public class JsonConverter implements PageListDataConverter {

    private JSONArray pageListJson;

    @Override
    public PageListModel convert(RowData rowData) throws RowPageListDataConvertException {
        String data = rowData.getValue();
        pageListJson = getPageListJson(data);
        PageListModel pageListModel = new PageListModel();
        for (int i = 0; i < pageListJson.length(); i++) {
            JSONObject pageItemJson = getPageItemJson(i);
            PageModel pageModel = convertPageItem(pageItemJson);
            pageListModel.add(pageModel);
        }
        return pageListModel;
    }

    private PageModel convertPageItem(JSONObject pageItemJson) throws RowPageListDataConvertException {
        String title = getPropertyValue(pageItemJson, JsonAPI.Page.TITLE);
        String contentType = getPropertyValue(pageItemJson, JsonAPI.Page.CONTENT_TYPE);
        String rowContentData = getPropertyValue(pageItemJson, JsonAPI.Page.CONTENT);
        String subtitle = getPropertyValue(pageItemJson, JsonAPI.Page.SUBTITLE);
        PageModel pageModel = new PageModel();
        pageModel.add(TitleComponent.newInstance(title))
                 .add(SubtitleComponent.newInstance(subtitle))
                 .add(ComponentResolver.getComponent(contentType, rowContentData));
        return pageModel;
    }

    private String getPropertyValue(JSONObject pageItemJson, JsonProperty property) throws RowPageListDataConvertException {
        String value = "";
        try {
            value = pageItemJson.getString(property.getName());
        } catch (JSONException e) {
            if (property.isMandatory()) {
                throwException("check if \"" + property.getName()
                               + "\" tutorial_page_property is present in json", e);
            } else {
                return value;
            }
        }
        return value;
    }

    private JSONArray getPageListJson(String data) throws RowPageListDataConvertException {
        JSONObject obj = null;
        try {
            obj = new JSONObject(data);
        } catch (JSONException cause) {
            throwException("Check if your data has a valid JSON format.", cause);
        }

        JSONArray pageListJson = null;
        String pageListPropertyName = JsonAPI.PAGE_LIST_ROOT.getName();
        try {
            pageListJson = obj.getJSONArray(pageListPropertyName);
        } catch (JSONException e) {
            throwException("Check if json root object contains \"" + pageListPropertyName + "\" property"
                           + " and this property has type of JSON Array.", e);
        }
        return pageListJson;
    }

    private void throwException(String primaryMessage, JSONException cause) throws RowPageListDataConvertException {
        throw new RowPageListDataConvertException(primaryMessage + "\n Exception occurred in\n    " + this.getClass().getCanonicalName() + " class",
                                                  cause);
    }

    private JSONObject getPageItemJson(int i) throws RowPageListDataConvertException {
        String pageListPropertyName = JsonAPI.PAGE_LIST_ROOT.getName();
        JSONObject pageItem = null;
        try {
            pageItem = pageListJson.getJSONObject(i);
            return pageItem;
        } catch (JSONException e) {
            throwException("Check if \"" + pageListPropertyName + "\" content "
                           + "is non-empty json array"
                    , e);
        }
        return pageItem;
    }
}
