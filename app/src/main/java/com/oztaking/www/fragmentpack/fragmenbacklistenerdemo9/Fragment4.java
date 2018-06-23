package com.oztaking.www.fragmentpack.fragmenbacklistenerdemo9;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oztaking.www.fragmentpack.R;

/**
 * @function: 返回事件的写法
 */

public class Fragment4 extends Fragment {

    private BackHandlerInterface mBakcHandlerFragmentInterface;
    private boolean mIsBackPressed = false;
    private TextView mTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        //        return super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment4,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //实例转换
        if (!(getActivity() instanceof BackHandlerInterface)){
            throw new ClassCastException("必须implement接口setFragmentInterface");
        } else{
            mBakcHandlerFragmentInterface = (BackHandlerInterface) getActivity();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        //将实例传递出去
        mBakcHandlerFragmentInterface.setSelectFragment(this);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTv = getView().findViewById(R.id.tv_fragment9_4);
    }

    //被调用的方法
    public boolean onBackPress(){
        if (!mIsBackPressed){
            mIsBackPressed = true;
            mTv.setText("fragment4中的onBackPress()方法被调用了");
            return true;
        }

        return false;
    }



    public interface BackHandlerInterface {
        public  void setSelectFragment(Fragment4 fragment);
    }

}
