package com.fjy.demoapp.multitype;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.RenderInfo;

public class Artist implements Datum {

  public final String name;
  public final String biography;
  public final String[] images;
  public final int year;

  public final boolean favourited;



  public Artist(String name, String biography, int year, boolean favourited, String... images) {
    this.name = name;
    this.biography = biography;
    this.year = year;
    this.favourited = favourited;
    this.images = images;
  }

  @Override
  public RenderInfo createComponent(ComponentContext c) {
    return ComponentRenderInfo.create()
        .component(FeedItemCard.create(c).artist(this).build())
        .build();
  }
}
