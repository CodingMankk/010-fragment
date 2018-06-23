package com.oztaking.www.fragmentpack.fragmentargsmethod3demo8;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oztaking.www.fragmentpack.R;

/**
 * @function:
 */

public class Fragment8_2 extends Fragment{
    private TextView mTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        //        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment8_2,container,false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTv = (TextView) getView().findViewById(R.id.tv_fragment8_2);
    }

    //设置textVie的文本内容
    public void setTextView(String s){
        mTv.setText(s);
    }





}
