package com.example.drago.food;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by drago on 2016-01-21.
 */
public class Fragment6 extends Fragment
{
    public Fragment6() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle savedInStanceState){
        View rootView = inflater.inflate(R.layout.frag6, containter, false);
        return rootView;
    }

}