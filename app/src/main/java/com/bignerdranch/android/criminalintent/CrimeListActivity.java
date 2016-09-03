package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by user on 8/25/16.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
