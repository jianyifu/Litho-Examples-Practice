package com.fjy.demoapp.multitype;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.EventHandler;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;

@LayoutSpec
public class FeedItemComponentSpec {

  @OnCreateLayout
  static Component onCreateLayout(ComponentContext c, @Prop final Artist artist) {
    return Column.create(c)
        .child(
            Column.create(c)
                .child(FeedImageComponent.create(c)
                       .images(artist.images))
                .child(TitleComponent.create(c).title(artist.name))
                .child(ActionsComponent.create(c)
                        .artist(artist)
                ))
        .child(FooterComponent.create(c).text(artist.biography))
        .build();
  }
}
