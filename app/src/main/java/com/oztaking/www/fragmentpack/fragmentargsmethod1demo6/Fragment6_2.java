package com.oztaking.www.fragmentpack.fragmentargsmethod1demo6;

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

public class Fragment6_2 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        //        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment6_2,container,false);
    }
}
