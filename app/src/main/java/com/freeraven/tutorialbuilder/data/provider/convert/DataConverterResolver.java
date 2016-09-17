package com.freeraven.tutorialbuilder.data.provider.convert;

import com.freeraven.tutorialbuilder.data.DataFormat;
import com.freeraven.tutorialbuilder.data.provider.convert.json.JsonConverter;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/17/16.
 */
public class DataConverterResolver {
    public static PageListDataConverter resolve(DataFormat format) {
        switch (format){
            case JSON: return new JsonConverter();
            default: throw new UnsupportedDataFormatException();
        }
    }
}
