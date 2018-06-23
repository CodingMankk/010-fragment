package com.oztaking.www.fragmentpack.fragmentargsmethod2demo7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.oztaking.www.fragmentpack.R;

/**
 * @function:
 * 第一：在Fragment中如何获得自己控件的引用，比较这里Fragment1里的listview控件。
 * 第二：在Fragment中如何获得其它Fragment页面中控件的引用，比如这里Fragment2里的TextView控件。
 *
 */

public class Fragment7_1 extends Fragment{

    final String[] mStrings = new String[]{
            "百度","新浪","微博","腾讯","网易","凤凰","搜狐"};
    private ListView mListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {

         View rootView = inflater.inflate(R.layout.fragment7_1,container,false);


        //【1】查找到了framgent1中的listview--方法1
        mListView = (ListView) rootView.findViewById(R.id.lv_listview);
        return rootView;



    }

    /**
     * getView:获取的是布局；
     * getActivity：获取的是seventActivity；
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d("onActivityCreated",getView().toString());
        Log.d("onActivityCreated",getActivity().toString());

        Toast.makeText(getContext(),getView().toString()+":"+getActivity().toString(),Toast.LENGTH_LONG).show();

        //【1】查找到了framgent1中的listview--方法2
        mListView = getView().findViewById(R.id.lv_listview);

//        TextView tv = getActivity().findViewById(R.id.tv_fragment2);
        //【2】查找fragment2中的textview；
        final TextView tv = getActivity().findViewById(R.id.tv_fragment2);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout
                .simple_list_item_1, mStrings);
        mListView.setAdapter(arrayAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("onActivityCreated",getView().toString());
                Log.d("onActivityCreated",getActivity().toString());
                Toast.makeText(getContext(),getView().toString()+":"+getActivity().toString(),Toast.LENGTH_LONG).show();
                String s = mStrings[position];
                tv.setText(s);

            }
        });

    }
}
