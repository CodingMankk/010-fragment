package com.oztaking.www.fragmentpack.fragmentdynamicdemo2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.oztaking.www.fragmentpack.R;

/**
 * @function: 动态添加fragment；
 */

//class继承与FragmentActivity
public class SecondActivity extends FragmentActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second_activity_layout);


        Button mBtnFragment1 = (Button) findViewById(R.id.btn_fragment1);
        mBtnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction tr = fm.beginTransaction();
                tr.add(R.id.frameLayout,new Fragment1());
                tr.commit();
            }
        });


        Button mBtnFragment2 = (Button) findViewById(R.id.btn_fragment2);
        mBtnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction tr = fm.beginTransaction();
                tr.add(R.id.frameLayout,new Fragment2());
                tr.commit();
            }
        });
    }
}
