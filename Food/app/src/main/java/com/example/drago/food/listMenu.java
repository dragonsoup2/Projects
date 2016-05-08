package com.example.drago.food;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.MapFragment;

import java.util.ArrayList;
import java.util.List;

public class listMenu extends AppCompatActivity {
    //Toolbar tb;
    private List<SlideMenu> lslide;
    private MenuAdapter ma;
    private ListView lv;
    private DrawerLayout dl;
    private RelativeLayout rl;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        //initiate components
        lv = (ListView) findViewById(R.id.left_drawer);
        dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        rl = (RelativeLayout) findViewById(R.id.main_content);
        lslide = new ArrayList<>();
        lslide.add(new SlideMenu(R.drawable.user_info, "User info"));
        lslide.add(new SlideMenu(R.drawable.current_order_list,"Current order list"));
        lslide.add(new SlideMenu(R.drawable.previous_order_list,"Previous order list"));
        lslide.add(new SlideMenu(R.drawable.payment,"Payment"));
        lslide.add(new SlideMenu(R.drawable.ranking,"Cook rankings"));
        lslide.add(new SlideMenu(R.drawable.settings,"Settings"));
        lslide.add(new SlideMenu(R.drawable.map,"Map"));
        lslide.add(new SlideMenu(R.drawable.app_info, "Application info"));

        ma = new MenuAdapter(this, lslide);
        lv.setAdapter(ma);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Menu");
        lv.setItemChecked(0, true);
        dl.closeDrawer(lv);

        replaceFragment(0);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setTitle(lslide.get(position).getTitle());
                lv.setItemChecked(position, true);
                replaceFragment(position);
                dl.closeDrawer(lv);
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, dl, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                invalidateOptionsMenu();
            }
        };

        dl.setDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    private void addMapFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment7 fragment = new Fragment7();
        transaction.add(R.id.f7, fragment);
        transaction.commit();
    }

    private void replaceFragment(int pos)
    {
        int num = 0;
        Fragment fragment = new Fragment1();
        switch (pos){
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;
            case 3:
                fragment = new Fragment4();
                break;
            case 4:
                fragment = new Fragment5();
                break;
            case 5:
                fragment = new Fragment6();
                break;
            case 6:
                fragment = new Fragment7();
                num = 6;
                break;
            case 7:
                fragment = new Fragment8();
                break;
            default:
                fragment = new Fragment1();
                break;
        }

        if(null != fragment)
        {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.main_content, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }


    }

}