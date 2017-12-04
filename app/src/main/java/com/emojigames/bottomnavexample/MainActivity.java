package com.emojigames.bottomnavexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            selectFragment(item);
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        selectFragment(menu.getItem(0));

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




    }

    protected void selectFragment(MenuItem item){
        item.setChecked(true);

        switch (item.getItemId()) {
        case R.id.navigation_home:
            pushFragment(new HomeFragment());
            break;
        case R.id.navigation_dashboard:
            pushFragment(new FragmentTwo());
            break;
        case R.id.navigation_notifications:
            pushFragment(new FragmentThree());
            break;

        }
    }


    protected void pushFragment(Fragment fragment) {
        if(fragment == null)
            return;


        FragmentManager fm = getFragmentManager();
        if(fm != null) {
            FragmentTransaction ft = fm.beginTransaction();

            if(ft != null) {
                ft.replace(R.id.root_layout, fragment);
                ft.commit();
            }
        }
    }
}
