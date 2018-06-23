package com.oztaking.www.fragmentpack.fragmentbacktostackdemo4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oztaking.www.fragmentpack.R;

/**
 * @function:
 */

public class Fragment4 extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        //        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment4,container,false);
    }

}
