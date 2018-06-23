package com.oztaking.www.fragmentpack.fragmentmethoddemo3;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.oztaking.www.fragmentpack.R;

/**
 * @function: 动态添加fragment；
 */

//class继承与FragmentActivity
public class ThirdActivity extends FragmentActivity implements View.OnClickListener{

    private Button mBtnAddFragment1;
    private Button mBtnAddFragment2;
    private Button mBtnRemoveFragment2;
    private Button mBtnReplaceFragment1;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third_activity_layout);

        initView();

    }

    private void initView() {
        mBtnAddFragment1 = (Button) findViewById(R.id.btn_add_fragment1);
        mBtnAddFragment2 = (Button) findViewById(R.id.btn_add_fragment2);
        mBtnRemoveFragment2 = (Button) findViewById(R.id.btn_remove_fragment2);
        mBtnReplaceFragment1 = (Button) findViewById(R.id.btn_replace_fragment1);

        mBtnAddFragment1.setOnClickListener(this);
        mBtnAddFragment2.setOnClickListener(this);
        mBtnRemoveFragment2.setOnClickListener(this);
        mBtnReplaceFragment1.setOnClickListener(this);

        frameLayout = (FrameLayout) findViewById(R.id.fl_frameLayout);
    }




    @Override
    public void onClick(View v) {
        switch(v.getId()){
             case R.id.btn_add_fragment1:
                 addFragment(R.id.fl_frameLayout,new Fragment1(),"fragment1");
                  break;
            case R.id.btn_add_fragment2:
                addFragment(R.id.fl_frameLayout,new Fragment2(),"fragment2");
                break;

            case R.id.btn_remove_fragment2:
                removeFragment("fragment2");
                break;

            case R.id.btn_replace_fragment1:
                //使用fragment2替换fragment1；
                replaceFragment(R.id.fl_frameLayout,new Fragment2());
                break;
             default:
                  break;
        }
    }


    /**
     *
     * @param containor
     * @param fragment
     * @param tag: 与fragment进行关联，在findFragment时候使用；
     */
    private void addFragment(int containor, Fragment fragment, String tag){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        tr.add(containor,fragment,tag);
        tr.commit();
    }

    //remove fragment
    private void removeFragment(String tag){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        Fragment fragment = fm.findFragmentByTag(tag);
        if (fragment != null){
            tr.remove(fragment);
        }else {
            Toast.makeText(getApplicationContext(),"fragment 不存在，无法移除",Toast.LENGTH_SHORT).show();
        }
        tr.commit();
    }

    //replace fragment

    /**
     *
     * @param containor
     * @param fragment 替换为的fragment，被替换的是默认的第一层的fragment
     */
    private void replaceFragment(int containor, Fragment fragment){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        tr.replace(containor,fragment);
        tr.commit();
    }

}
