package com.oztaking.www.fragmentpack.fragmentbacktostackdemo4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.oztaking.www.fragmentpack.R;

/**
 * @function: 动态添加fragment；
 */

//class继承与FragmentActivity
public class FourActivity extends FragmentActivity implements View.OnClickListener{

    private Button mBtnAddFragment1;
    private Button mBtnAddFragment2;

    private Button mBtnBackToFragment2;
    private Button mBtnBackToFragment2Inclusive;
    private Button mBtnAddFragment3;
    private Button mBtnAddFragment4;
    private Button mBtnAddFragment234;

    private Button mBtnPopStack;

    int mFragmentId1, mFragmentId2,mFragmentId3,mFragmentId4;
    private FragmentManager.OnBackStackChangedListener mListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_activity_layout);
        initView();

        //回栈监听；
        FragmentManager fm = getFragmentManager();
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
        mBtnAddFragment3 = (Button)findViewById(R.id.btn_add_fragment3);
        mBtnAddFragment4 = (Button)findViewById(R.id.btn_add_fragment4);
        mBtnAddFragment234 = (Button)findViewById(R.id.btn_add_fragment234);

        mBtnPopStack = (Button)findViewById(R.id.btn_pop_stack);
        mBtnBackToFragment2 = (Button)findViewById(R.id.btn_back_to_fragment2);
        mBtnBackToFragment2Inclusive = (Button)findViewById(R.id.btn_back_to_fragment2_inclusive);

        mBtnAddFragment1.setOnClickListener(this);
        mBtnAddFragment2.setOnClickListener(this);
        mBtnAddFragment3.setOnClickListener(this);
        mBtnAddFragment4.setOnClickListener(this);
        mBtnAddFragment234.setOnClickListener(this);

        mBtnPopStack.setOnClickListener(this);

        mBtnBackToFragment2.setOnClickListener(this);
        mBtnBackToFragment2Inclusive.setOnClickListener(this);


    }




    @Override
    public void onClick(View v) {
        switch(v.getId()){
             case R.id.btn_add_fragment1:
                 mFragmentId1 = addFragment(R.id.fl_frameLayout, new Fragment1(), "fragment1");
                 break;
            case R.id.btn_add_fragment2:
                mFragmentId2 =  addFragment(R.id.fl_frameLayout,new Fragment2(),"fragment2");
                break;

            case R.id.btn_add_fragment3:
                mFragmentId3 = addFragment(R.id.fl_frameLayout,new Fragment3(),"fragment3");
                break;

            case R.id.btn_add_fragment4:
                mFragmentId4 = addFragment(R.id.fl_frameLayout,new Fragment4(),"fragment4");
                break;

            case R.id.btn_add_fragment234:
                addMultiFragment(R.id.fl_frameLayout,new Fragment2(),new Fragment3(),new Fragment4(),
                        "fragment2","fragment3","fragment4");
               break;

            case R.id.btn_pop_stack:
                popStack();
                break;
            case R.id.btn_back_to_fragment2:
//                backStackToFragmentByTag("fragment2",0);
                backStackToFragmentById(mFragmentId2,0);
                break;

            case R.id.btn_back_to_fragment2_inclusive:
                backStackToFragmentByTag("fragment2",FragmentManager.POP_BACK_STACK_INCLUSIVE);
                backStackToFragmentById(mFragmentId2,FragmentManager.POP_BACK_STACK_INCLUSIVE);
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
    private int addFragment(int containor, Fragment fragment, String tag){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        tr.add(containor,fragment,tag);
        tr.addToBackStack(tag);//将fragment添加到返回stack中；
        int id = tr.commit(); //生成tr的id；
        return id;
    }

    private void addMultiFragment(int containor, Fragment fragment1,Fragment fragment2,Fragment fragment3,
                                 String tag1,String tag2,String tag3){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        tr.add(containor,fragment1,tag1);
        tr.add(containor,fragment2,tag2);
        tr.add(containor,fragment3,tag3);

        tr.addToBackStack(tag1);//将fragment添加到返回stack中；
        tr.addToBackStack(tag2);//将fragment添加到返回stack中；
        tr.addToBackStack(tag3);//将fragment添加到返回stack中；

        tr.commit();

    }

    private void popStack(){
        FragmentManager fm = getFragmentManager();
        fm.popBackStack();
    }

    //此处是通过tag返回；也同样可以通过Tr.add时生成的id返回
    private void backStackToFragmentByTag(String tag,int flag){
        FragmentManager fm = getFragmentManager();
        fm.popBackStack(tag,flag);
    }

    //此处是通过tag返回；也同样可以通过Tr.add时生成的id返回
    private void backStackToFragmentById(int id,int flag){
        FragmentManager fm = getFragmentManager();
        fm.popBackStack(id,flag);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放栈的监听
        FragmentManager fm = getFragmentManager();
        fm.removeOnBackStackChangedListener(mListener);
    }
}
