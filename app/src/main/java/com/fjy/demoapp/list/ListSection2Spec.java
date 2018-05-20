package com.fjy.demoapp.list;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.DataDiffSection;
import com.facebook.litho.sections.common.RenderEvent;
import com.facebook.litho.sections.common.SingleComponentSection;
import com.facebook.litho.sections.widget.GridRecyclerConfiguration;
import com.facebook.litho.sections.widget.ListRecyclerConfiguration;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.RenderInfo;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.litho.sections.widget.ListRecyclerConfiguration.SNAP_TO_CENTER;

@GroupSectionSpec
public class ListSection2Spec {


    @OnCreateChildren
    static Children onCreateChildren(final SectionContext c) {
        return Children.create()
                .child(
                        SingleComponentSection.create(c)
                                .component(
                                        RecyclerCollectionComponent.create(c)
                                                .disablePTR(true)
                                                .recyclerConfiguration(new ListRecyclerConfiguration(LinearLayoutManager.HORIZONTAL,/*reverse layout*/ false,SNAP_TO_CENTER))
                                                .section(
                                                        DataDiffSection.<DataModel>create(c)
                                                                .data(generateData(32))
                                                                .renderEventHandler(ListSection2.onRender(c))
                                                )
                                                .canMeasureRecycler(true)
                                )
//                                .sticky(true)
                                .build()
                )
                .child(
                        DataDiffSection.<DataModel>create(c)
                                .data(generateData(32))
                                .renderEventHandler(ListSection2.onRender(c)))
                .build();
    }


    @OnEvent(RenderEvent.class)
    static RenderInfo onRender(final SectionContext c, @FromEvent DataModel model,@FromEvent int index) {
        return ComponentRenderInfo.create()
                .component(
                        ListItem2.create(c)
                                .dataModel(model)
                                .build())
                .build();
    }

    private static List<DataModel> generateData(int count) {
        final List<DataModel> data = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            DataModel model = new DataModel();
            model.color = (i % 2 == 0 ? Color.WHITE : Color.LTGRAY);
            model.title = i + ". Hello, world!";
            model.subtitle = "Litho tutorial";
            data.add(model);
         }
        return data;
    }
}
