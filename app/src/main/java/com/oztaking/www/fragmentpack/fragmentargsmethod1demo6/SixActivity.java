package com.oztaking.www.fragmentpack.fragmentargsmethod1demo6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.oztaking.www.fragmentpack.R;


/**
 * @function:参数的传递；
 */
public class SixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_layout);
        argsTrans1();
    }


    /**
     *方法1：直接在activity中传递；
     *说明：此时的fragment都是静态生成的，可以直接获取id；
     */
    private void argsTrans1() {
        final String[] mStrings = new String[]{
                "百度","新浪","微博","腾讯","网易","凤凰","搜狐"};
        //【1】查找到了framgent1中的listview
        ListView listView = (ListView) findViewById(R.id.lv_listview);
        //【2】查找fragment2；
        final TextView tv = (TextView) findViewById(R.id.tv_fragment2);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SixActivity.this, android.R.layout
                .simple_list_item_1, mStrings);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(mStrings[position]);
            }
        });

    }

    /**
     * 方法2：
     */
    private void argsTrans2(){

    }

}
