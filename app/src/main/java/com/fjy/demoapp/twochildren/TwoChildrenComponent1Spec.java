package com.fjy.demoapp.twochildren;

import android.graphics.Color;
import android.widget.ImageView;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.ResType;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaPositionType;
import com.fjy.demoapp.R;

import static com.facebook.yoga.YogaEdge.ALL;

@LayoutSpec
public class TwoChildrenComponent1Spec {

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c) {

        return Column.create(c)
                .paddingDip(ALL, 16)
                .backgroundColor(Color.WHITE)
                .child(
                        Text.create(c)
                                .text("Hello world")
                                .textSizeSp(40))
                .child(
                        Text.create(c)
                                .text("Litho tutorial")
                                .textSizeSp(20))
                .build();
    }

}
