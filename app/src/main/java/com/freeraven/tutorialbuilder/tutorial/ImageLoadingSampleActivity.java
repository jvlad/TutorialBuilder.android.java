package com.freeraven.tutorialbuilder.tutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.freeraven.tutorialbuilder.R;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/16/16.
 */
public class ImageLoadingSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_sample_activity);
        ImageView rendered = (ImageView) findViewById(R.id.image);
    }
}
