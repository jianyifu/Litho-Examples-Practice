package com.fjy.demoapp.twochildren;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.fjy.demoapp.R;

public class TwoChildrenActivity extends AppCompatActivity {
    private static final String TAG = TwoChildrenActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TAG);
        final ComponentContext c = new ComponentContext(this);

        final LithoView lithoView = LithoView.create(
                this /* context */,
                TwoChildrenComponent.create(c)
                        .title("Overlaid layer text !!!")
                        .textColor(R.color.overlay_text_color)
                        .build());

        setContentView(lithoView);
    }

}
