package com.ams.scanner.ui.main;

import android.os.Bundle;
import butterknife.ButterKnife;
import com.ams.scanner.R;
import com.ams.scanner.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityFragmentComponent().inject(this);

        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));

        init();
    }

    @Override
    protected void init() {

    }
}
