package com.liangke.comprehensive.splash;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityTestBinding;

/**
 * Created by LK on 2017/12/12.
 */

public class TestActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState,PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.activity_test);

        ActivityTestBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_test);

        Toast.makeText(this,"你好",Toast.LENGTH_SHORT).show();

     }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_test);
        Toast.makeText(this,"你好",Toast.LENGTH_SHORT).show();



    }
}
