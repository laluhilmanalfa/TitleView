package com.laluhilman.titlescroolview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.laluhilman.titlescroolview.customview.TitleAdapter;
import com.laluhilman.titlescroolview.customview.TitleSelectedListener;
import com.laluhilman.titlescroolview.customview.TitleView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private TitleView titleViewDemo;
    private TitleAdapter adapter;

    private TitleSelectedListener listener = new TitleSelectedListener() {
        @Override
        public void onClick(int position) {
//            titleViewDemo.setActiveItem(position);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        titleViewDemo = (TitleView) findViewById(R.id.demo_title_view);
        titleViewDemo.setAdapter(generateAdapter());




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private TitleAdapter generateAdapter(){
        adapter = new TitleAdapter(getApplicationContext(), generateTitleList(), listener, getWindowManager().getDefaultDisplay().getWidth()/3);
        return adapter;
    }

    private ArrayList<String> generateTitleList(){
        ArrayList<String> titleList = new ArrayList<>();
        titleList.add("Demo 1");
        titleList.add("Demo 2");
        titleList.add("Demo 3");
        titleList.add("Demo 4");
        titleList.add("Demo 5");

        return titleList;

    }
}
