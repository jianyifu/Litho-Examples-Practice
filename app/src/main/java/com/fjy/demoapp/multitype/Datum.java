package com.fjy.demoapp.multitype;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.widget.RenderInfo;

public interface Datum {
    RenderInfo createComponent(ComponentContext context);
}
