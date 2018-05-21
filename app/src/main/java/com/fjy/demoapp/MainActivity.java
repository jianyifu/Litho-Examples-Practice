package com.fjy.demoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.fjy.demoapp.helloworld.HelloLithoActivity;
import com.fjy.demoapp.list.PlainListActivity;
import com.fjy.demoapp.multitype.MutiTypeActivity;
import com.fjy.demoapp.state.StateActivity;
import com.fjy.demoapp.twochildren.TwoChildrenActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {
    static final List<DataModel> DATA_MODELS =
            Arrays.asList(
                    new DataModel("Hello World !!", HelloLithoActivity.class),
                    new DataModel("Custom Component", TwoChildrenActivity.class),
                    new DataModel("A plain list", PlainListActivity.class),
                    new DataModel("Muti-type list",MutiTypeActivity.class),
                    new DataModel("State Management",StateActivity.class)
            );

    static final class DataModel {
        final String name;
        final Class klass;

        public DataModel(String name, Class klass) {
            this.name = name;
            this.klass = klass;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ComponentContext c = new ComponentContext(this);

        setContentView(LithoView
                .create(c,
                        DemoListComponent.create(c)
                                .modelList(DATA_MODELS).build()));
    }

}
