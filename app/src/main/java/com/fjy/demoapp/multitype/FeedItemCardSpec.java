package com.fjy.demoapp.multitype;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Card;

import static com.facebook.yoga.YogaEdge.HORIZONTAL;
import static com.facebook.yoga.YogaEdge.VERTICAL;

@LayoutSpec
public class FeedItemCardSpec {

  @OnCreateLayout
  static Component onCreateLayout(ComponentContext c, @Prop final Artist artist) {
    return Column.create(c)
        .paddingDip(VERTICAL, 8)
        .paddingDip(HORIZONTAL, 16)
        .child(Card.create(c).content(FeedItemComponent.create(c).artist(artist)))
        .build();
  }
}