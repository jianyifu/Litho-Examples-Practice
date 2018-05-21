package com.fjy.demoapp.state;

import android.util.Log;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.StateValue;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.OnUpdateState;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;

@LayoutSpec
public class CheckBoxSpec {
    private static final String TAG = "CheckBoxSpec";

    @OnCreateInitialState
    static void createInitialState(
            ComponentContext c,
            StateValue<Boolean> isChecked,
            @Prop boolean initChecked) {
        Log.d(TAG, "createInitialState() called with: c = [" + c + "], isChecked = [" + isChecked + "], initChecked = [" + initChecked + "]");
        isChecked.set(initChecked);
    }
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @State boolean isChecked) {
        Log.d(TAG, "onCreateLayout() called with: c = [" + c + "], isChecked = [" + isChecked + "]");
        return Column.create(c)
                .alignItems(YogaAlign.CENTER)
                .child(Image.create(c)
                        .widthDip(40)
                        .heightDip(40)
                        .drawableRes(isChecked ? android.R.drawable.checkbox_on_background : android.R.drawable.checkbox_off_background)
                        .build()
                )
                .child(Text.create(c)
                .text("Submit")
                .textSizeDip(30)
                        .clickHandler(CheckBox.onClickText(c))
                .build())
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onClickText(ComponentContext c,@State boolean isChecked){
        Log.d(TAG, "onClickText() called with: c = [" + c + "], isChecked = [" + isChecked + "]");
        CheckBox.updateCheckBox(c);
    }

    @OnUpdateState
    static void updateCheckBox(StateValue<Boolean> isChecked){
        isChecked.set(!isChecked.get());
    }
}
