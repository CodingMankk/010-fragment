package com.oztaking.www.fragmentpack.fragmentargsmethod3demo8;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.oztaking.www.fragmentpack.R;


/**
 * @function:参数的传递-所有的参数传递的方法的实现都是在fragment1中；
 */
public class EightActivity extends AppCompatActivity implements Fragment8_1.titleSelectInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_layout);
    }

    @Override
    public void onTitleSelect(String title) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment8_2 fragment = (Fragment8_2)fm.findFragmentById(R.id.fg8_2);
        fragment.setTextView(title);
    }
}
