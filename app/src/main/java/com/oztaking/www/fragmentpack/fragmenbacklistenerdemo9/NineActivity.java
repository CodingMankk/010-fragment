package com.oztaking.www.fragmentpack.fragmenbacklistenerdemo9;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.oztaking.www.fragmentpack.R;


/**
 * @function: show hide的认识
 * detach;atach的用法
 */

//class继承与FragmentActivity
public class NineActivity extends FragmentActivity implements View.OnClickListener,
        Fragment4.BackHandlerInterface {

    private Fragment4 mSelectFragment;

    private Button mBtnAddFragment1;
    private Button mBtnAddFragment2;
    private Button mBtnAddFragment3;
    private Button mBtnReplaceFragment4;

    private Button mBtnHideFragment2;
    private Button mBtnHideFragment3;
    private Button mBtnShowFragment2;
    private Button mBtnShowFragment3;


    private Button mBtnDetachFragment2;
    private Button mBtnDetachFragment3;
    private Button mBtnAttachFragment2;
    private Button mBtnAttachFragment3;


    private FragmentManager.OnBackStackChangedListener mListener;

    private Button mBtnPopStack;
    private Button mBtnPrintStack;
    private TextView mTv;
    private TextView mTv1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_activity_layout);
        initView();

        //回栈监听；
        FragmentManager fm = getSupportFragmentManager();
        mListener = new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Toast.makeText(getApplicationContext(), "栈内容有改变", Toast.LENGTH_SHORT).show();
                Log.d("FourActivity", "栈内容有改变");
            }
        };
        fm.addOnBackStackChangedListener(mListener);

    }

    private void initView() {
        mBtnAddFragment1 = (Button) findViewById(R.id.btn_add_fragment1);
        mBtnAddFragment2 = (Button) findViewById(R.id.btn_add_fragment2);
        mBtnAddFragment3 = (Button) findViewById(R.id.btn_add_fragment3);
        mBtnReplaceFragment4 = (Button) findViewById(R.id.btn_replace_fragment4);


        mBtnHideFragment2 = (Button) findViewById(R.id.btn_hide_fragment2);
        mBtnHideFragment3 = (Button) findViewById(R.id.btn_hide_fragment3);
        mBtnShowFragment2 = (Button) findViewById(R.id.btn_show_fragment2);
        mBtnShowFragment3 = (Button) findViewById(R.id.btn_show_fragment3);

        mBtnDetachFragment2 = (Button) findViewById(R.id.btn_detach_fragment2);
        mBtnDetachFragment3 = (Button) findViewById(R.id.btn_detach_fragment3);
        mBtnAttachFragment2 = (Button) findViewById(R.id.btn_attach_fragment2);
        mBtnAttachFragment3 = (Button) findViewById(R.id.btn_attach_fragment3);

        mBtnPopStack = (Button) findViewById(R.id.btn_fifth_pop_stack);

        mBtnPrintStack = (Button) findViewById(R.id.btn_fifth_prin_stack);

        mTv1 = (TextView) findViewById(R.id.tv);

        mBtnAddFragment1.setOnClickListener(this);
        mBtnAddFragment2.setOnClickListener(this);
        mBtnAddFragment3.setOnClickListener(this);
        mBtnReplaceFragment4.setOnClickListener(this);

        mBtnHideFragment2.setOnClickListener(this);
        mBtnHideFragment3.setOnClickListener(this);
        mBtnShowFragment2.setOnClickListener(this);
        mBtnShowFragment3.setOnClickListener(this);

        mBtnDetachFragment2.setOnClickListener(this);
        mBtnDetachFragment3.setOnClickListener(this);
        mBtnAttachFragment2.setOnClickListener(this);
        mBtnAttachFragment3.setOnClickListener(this);


        mBtnPopStack.setOnClickListener(this);
        mBtnPrintStack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_fragment1:
                addFragment(R.id.fl_frameLayout, new Fragment1(), "fragment1");
                break;
            case R.id.btn_add_fragment2:
                addFragment(R.id.fl_frameLayout, new Fragment2(), "fragment2");
                break;

            case R.id.btn_add_fragment3:
                addFragment(R.id.fl_frameLayout, new Fragment3(), "fragment3");
                break;

            case R.id.btn_hide_fragment2:
                hideFragment("fragment2");
                break;

            case R.id.btn_hide_fragment3:
                hideFragment("fragment3");
                break;

            case R.id.btn_show_fragment2:
                showFragment("fragment2");
                break;

            case R.id.btn_show_fragment3:
                showFragment("fragment3");
                break;

            case R.id.btn_detach_fragment2:
                detachFragment("fragment2");
                break;

            case R.id.btn_detach_fragment3:
                detachFragment("fragment3");
                break;

            case R.id.btn_attach_fragment2:
                attachFragment("fragment2");
                break;

            case R.id.btn_attach_fragment3:
                attachFragment("fragment3");
                break;

            case R.id.btn_fifth_pop_stack:
                popStack();
                printCurFragmentStack();
                break;
            case R.id.btn_fifth_prin_stack:

                printCurFragmentStack();
                break;

            case R.id.btn_replace_fragment4:
                replaceFragment(R.id.fl_frameLayout,new Fragment4());
                break;

            default:
                break;
        }
    }


    /**
     * @param containor
     * @param fragment
     * @param tag:      与fragment进行关联，在findFragment时候使用；
     */
    private int addFragment(int containor, Fragment fragment, String tag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        tr.add(containor, fragment, tag);
        tr.addToBackStack(tag);//将fragment添加到返回stack中；
        int id = tr.commit(); //生成tr的id；
        return id;
    }

    private void popStack() {
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();
    }

    private void printCurFragmentStack() {
        FragmentManager fm = getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        StringBuilder builder = new StringBuilder("回退栈内容为:\n");
        for (int i = count-1; i >= 0; i--) {
            FragmentManager.BackStackEntry entry = fm.getBackStackEntryAt(i);
            builder.append(entry.getName() + "\n");
        }
        mTv1.setText(builder.toString());

    }


    /**
     * 两种方法：可以使用Tag/Id
     *
     * @param tag
     */
    private void hideFragment(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        //需要找到show的fragment；
        Fragment fragment = fm.findFragmentByTag(tag);
        if (!fragment.isHidden()) {
            FragmentTransaction tr = fm.beginTransaction();
            tr.hide(fragment);
            tr.addToBackStack("hide" + tag);
            tr.commit();
        } else {
            Toast.makeText(getApplicationContext(), tag + "已经被hide", Toast.LENGTH_SHORT).show();
        }
    }

    private void showFragment(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        //需要找到show的fragment；
        Fragment fragment = fm.findFragmentByTag(tag);
        if (!fragment.isVisible()) {
            FragmentTransaction tr = fm.beginTransaction();
            tr.show(fragment);
            tr.addToBackStack("show" + tag);
            tr.commit();
        } else {
            Toast.makeText(getApplicationContext(), tag + "已经被show", Toast.LENGTH_SHORT).show();
        }
    }


    private void detachFragment(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(tag);
        if (!fragment.isDetached()) {
            FragmentTransaction tr = fm.beginTransaction();
            tr.detach(fragment);
            tr.addToBackStack("detach"+tag);
            tr.commit();
        } else {
            Toast.makeText(getApplicationContext(), tag + "已经被detach", Toast.LENGTH_SHORT).show();
        }
    }

    private void attachFragment(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(tag);
        FragmentTransaction tr = fm.beginTransaction();
        tr.addToBackStack("attach"+tag);
        tr.attach(fragment);
        tr.commit();
    }

    /**
     *
     * @param containor
     * @param fragment 替换为的fragment，被替换的是默认的第一层的fragment
     */
    private void replaceFragment(int containor, Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        tr.replace(containor,fragment);
        tr.addToBackStack("replace");
        tr.commit();
    }


    @Override
    public void setSelectFragment(Fragment4 fragment) {
        this.mSelectFragment = fragment;
    }

    @Override
    public void onBackPressed() {
        if (mSelectFragment == null || !mSelectFragment.onBackPress()){
            super.onBackPressed();
        }
    }
}
