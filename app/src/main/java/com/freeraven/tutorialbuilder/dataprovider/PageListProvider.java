package com.freeraven.tutorialbuilder.dataprovider;

import android.media.Image;
import android.support.annotation.NonNull;

import com.freeraven.tutorialbuilder.pagecomponent.PageComponent;
import com.freeraven.tutorialbuilder.pagecomponent.TextComponent.TextComponent;
import com.freeraven.tutorialbuilder.pagecomponent.TextComponent.TextContent;
import com.freeraven.tutorialbuilder.pagecomponent.image.ImageComponent;
import com.freeraven.tutorialbuilder.pagecomponent.image.ImageContent;
import com.freeraven.tutorialbuilder.pagecomponent.subtitle.SubtitleComponent;
import com.freeraven.tutorialbuilder.pagecomponent.subtitle.SubtitleContent;
import com.freeraven.tutorialbuilder.pagecomponent.title.TitleComponent;
import com.freeraven.tutorialbuilder.pagecomponent.title.TitleContent;
import com.freeraven.tutorialbuilder.pagemodel.PageListModel;
import com.freeraven.tutorialbuilder.pagemodel.PageModel;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class PageListProvider {
    private int pageCounter = 0;
    private static PageListProvider instance;

    private PageListProvider() {
    }

    public static PageListProvider getInstance() {
        if (instance == null) {
            synchronized (PageListProvider.class) {
                if (instance == null) {
                    instance = new PageListProvider();
                }
            }
        }
        return instance;
    }

    public PageListModel getPageListModel() {
        PageListModel pageListModel = new PageListModel();
        for (int i = 0; i < 2; i++) {
            pageListModel.add(createTextPageModel());
        }
        pageListModel.add(createImagePageModel());
        return pageListModel;
    }

    private PageModel createImagePageModel() {
        PageModel page = new PageModel();
        page.add(stubTitle())
            .add(stubSubtitle())
            .add(stubImage());
        return page;
    }

    private PageComponent stubImage() {
        ImageContent body = new ImageContent();
        body.setUrl("http://goo.gl/gEgYUd");
        ImageComponent component = new ImageComponent();
        component.setContent(body);
        return component;
    }

    private PageModel createTextPageModel() {
        PageModel page = new PageModel();
        page.add(stubTitle())
            .add(stubSubtitle())
            .add(stubText());

        return page;
    }

    @NonNull
    private TitleComponent stubTitle() {
        TitleContent body = new TitleContent();
        body.setValue("Page With Number " + ++pageCounter);
        TitleComponent component = new TitleComponent();
        component.setContent(body);
        return component;
    }

    @NonNull
    private SubtitleComponent stubSubtitle() {
        SubtitleContent titleContent = new SubtitleContent();
        titleContent.setValue("Subtitle Number " + ++pageCounter);
        SubtitleComponent component = new SubtitleComponent();
        component.setContent(titleContent);
        return component;
    }

    @NonNull
    private TextComponent stubText() {
        TextContent body = new TextContent();
        body.setValue(++pageCounter
                      + " Instantiates a layout XML file into its corresponding View objects. It is never used directly. Instead, use getLayoutInflater() or getSystemService(Class) to retrieve a standard LayoutInflater instance that is already hooked up to the current context and correctly configured for the device you are running on. For example:\n"
                      + "\n"
                      + "LayoutInflater inflater = (LayoutInflater)context.getSystemService\n"
                      + "      (Context.LAYOUT_INFLATER_SERVICE);\n"
                      + "To create a new LayoutInflater with an additional LayoutInflater.Factory for your own views, you can use cloneInContext(Context) to clone an existing ViewFactory, and then call setFactory(LayoutInflater.Factory) on it to include your Factory.\n"
                      + "\n"
                      + "For performance reasons, view inflation relies heavily on pre-processing of XML files that is done at build time. Therefore, it is not currently possible to use LayoutInflater with an XmlPullParser over a plain XML file at runtime; it only works with an XmlPullParser returned from a compiled resource (R.something file.) ");
        TextComponent component = new TextComponent();
        component.setContent(body);
        return component;
    }
}
