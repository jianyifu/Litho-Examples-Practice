package com.fjy.demoapp.list;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Text;

import static com.facebook.yoga.YogaEdge.ALL;

@LayoutSpec
public class ListItem2Spec {

    @OnCreateLayout
    static Component onCreateLayout(
            ComponentContext c,
            @Prop DataModel dataModel) {

        return Column.create(c)
                .paddingDip(ALL, 16)
                .backgroundColor(dataModel.color)
                .child(
                        Text.create(c)
                                .text(dataModel.title)
                                .textSizeSp(40))
                .child(
                        Text.create(c)
                                .text(dataModel.subtitle)
                                .textSizeSp(20))
                .build();
    }
}
