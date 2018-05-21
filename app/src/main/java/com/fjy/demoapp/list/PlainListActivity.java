package com.fjy.demoapp.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.fjy.demoapp.BaseActivity;

public class PlainListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentContext context = new ComponentContext(this);
        final Component component =
                RecyclerCollectionComponent.create(context)
                        .disablePTR(true)
//                        .section(ListSection.create(new SectionContext(context)).build())
                        .section(ListSection2.create(new SectionContext(context)).build())
                        .build();

        setContentView(LithoView.create(context,component));
    }
}
