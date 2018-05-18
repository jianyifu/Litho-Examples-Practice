package com.fjy.demoapp;

import android.util.Log;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.common.DataDiffSection;
import com.facebook.litho.sections.common.RenderEvent;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.RenderInfo;

import java.util.List;

@LayoutSpec
public class DemoListComponentSpec {
    private static final String TAG = "DemoListComponentSpec";

    @OnCreateLayout
    static Component createLayout(final ComponentContext c,
                                  @Prop List<MainActivity.DataModel> modelList) {
        return RecyclerCollectionComponent.create(c)
                .section(DataDiffSection.<MainActivity.DataModel>
                        create(new SectionContext(c))
                        .data(modelList)
                        .renderEventHandler(DemoListComponent.onRender(c)))
                .disablePTR(true)
                .build();
    }


    @OnEvent(RenderEvent.class)
    static RenderInfo onRender(
            final ComponentContext context,
            @FromEvent MainActivity.DataModel model,
            @FromEvent int index) {
        Log.d(TAG, "onRender() called with: context = [" + context + "], model = [" + model + "], index = [" + index + "]");
        return ComponentRenderInfo.
                create().
                component(DemoListItemComponent.create(context)
                        .dataModel(model)
                        .build())
                .build();
    }

}
