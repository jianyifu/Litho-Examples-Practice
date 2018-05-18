package com.fjy.demoapp;


import android.content.Intent;
import android.graphics.Color;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;

@LayoutSpec
public class DemoListItemComponentSpec {
    @OnCreateLayout
    static Component createLayout(
            ComponentContext c,
            @Prop MainActivity.DataModel dataModel) {
        return
            Card.create(c)
                .content(
                        Text.create(c)
                                .text(dataModel.name)
                                .textSizeDip(30)
                                .marginDip(YogaEdge.ALL,15)
                                .build()
                )
                .cardBackgroundColor(Color.WHITE)
                .clickHandler(DemoListItemComponent.onClick(c))
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onClick(ComponentContext context, @Prop MainActivity.DataModel dataModel) {
        Intent intent = new Intent(context, dataModel.klass);
        context.startActivity(intent);
    }
}
