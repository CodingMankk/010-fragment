package com.oztaking.www.fragmentpack.fragmentreplacedatasavedemo10;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oztaking.www.fragmentpack.R;

/**
 * @function:
 */

public class Fragment1 extends Fragment {

    //用于保存fragment视图；
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        //        return super.onCreateView(inflater, container, savedInstanceState);

        //        return inflater.inflate(R.layout.fragment2,container,false);


        //增加对视图的保存，直接使用变量进行了保存；
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment1, container, false);
        } else {
            //如果应存在则需要移除，同一个视图不能保存两次；
            ((ViewGroup) mRootView.getParent()).removeView(mRootView);
        }
        return mRootView;


    }

}
