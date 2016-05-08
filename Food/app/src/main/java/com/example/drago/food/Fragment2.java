package com.example.drago.food;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by drago on 2016-01-21.
 */
public class Fragment2 extends Fragment
{
    public Fragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle savedInStanceState){
        View rootView = inflater.inflate(R.layout.frag2, containter, false);
        return rootView;
    }

}