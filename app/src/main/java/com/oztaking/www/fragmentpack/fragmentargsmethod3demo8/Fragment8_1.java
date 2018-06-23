package com.oztaking.www.fragmentpack.fragmentargsmethod3demo8;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oztaking.www.fragmentpack.R;

/**
 * @function:
 */

public class Fragment8_1 extends Fragment {

    private titleSelectInterface mTitleSelectInterface;

    private String[] mString = new String[]{
            "乔峰", "无崖子", "星宿", "阿朱", "阿紫"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {

        return inflater.inflate(R.layout.fragment8_1, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {

            //            接口是给activity用的，所以要在activity中给这里的接口变量赋值，可以有很多方法，当然可以选择写一个setXXX()
            // 函数来赋值，但如果用户忘了怎么办？所以我们要强制用户赋
            //            值。所以采用强转的方式，在fragment与activity相关联时，进行强转赋值
            mTitleSelectInterface = (titleSelectInterface) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + "必须实现" +
                    "titleSelectInterface");

        }

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView listview = getView().findViewById(R.id.lv_listview_8_1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R
                .layout.simple_list_item_1,
                mString);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mTitleSelectInterface.onTitleSelect(mString[position]);
            }
        });
    }

    public interface titleSelectInterface {
        public void onTitleSelect(String title);
    }
}
