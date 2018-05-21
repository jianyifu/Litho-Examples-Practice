package com.fjy.demoapp.twochildren;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.fjy.demoapp.BaseActivity;
import com.fjy.demoapp.R;

public class TwoChildrenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ComponentContext c = new ComponentContext(this);

        final LithoView lithoView = LithoView.create(
                this /* context */,
                TwoChildrenComponent1.create(c)
                        .build());

//        final LithoView lithoView = LithoView.create(
//                this /* context */,
//                TwoChildrenComponent2.create(c)
//                        .title("Overlaid layer text !!!")
//                        .textColorRes(R.color.overlay_text_color)
//                        .build());
        setContentView(lithoView);
    }

}
