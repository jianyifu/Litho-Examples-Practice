package com.fjy.demoapp.twochildren;

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

@LayoutSpec
public class TwoChildrenComponent2Spec {
  @OnCreateLayout
  static Component onCreateLayout(
      ComponentContext c,
      @Prop(resType = ResType.COLOR) int textColorRes,
      @Prop String title) {

      return Column.create(c)
              .child(
                      Image.create(c)
                              .drawableRes(R.mipmap.some_big_image)
                              .widthPercent(100)
                              .scaleType(ImageView.ScaleType.CENTER_CROP)
//                              .aspectRatio(5)  //设置图片的长宽比
                              .build()
              )
              .child(
                      Text.create(c)
                              .text(title)
                              .textSizeDip(30)
                              .textColorRes(textColorRes)
                              .positionType(YogaPositionType.ABSOLUTE)// 如果把这一行注释掉，就是垂直方向的线性布局
                              .build()
              )
              .build();
  }
}