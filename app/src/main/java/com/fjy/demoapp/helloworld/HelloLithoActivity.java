package com.fjy.demoapp.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.Text;

public class HelloLithoActivity extends AppCompatActivity {
    private static final String TAG = HelloLithoActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TAG);

        final ComponentContext c = new ComponentContext(this);

        final LithoView lithoView = LithoView.create(
                this /* context */,
                Text.create(c)
                        .text("Hello, World!")
                        .textSizeDip(50)
                        .build());

        setContentView(lithoView);
    }
}
