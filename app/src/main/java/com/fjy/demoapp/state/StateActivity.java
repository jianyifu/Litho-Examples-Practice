package com.fjy.demoapp.state;


import android.os.Bundle;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.fjy.demoapp.BaseActivity;

public class StateActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentContext context = new ComponentContext(this);
        setContentView(LithoView.create(this,
                CheckBox.create(context).initChecked(true).build())
        );
    }
}
