package com.android.skillvo.appindexing;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.skillvo.appindexing.databinding.HomeDataBinding;


public class HomeActivity extends AppCompatActivity {

    private static final int SIZE = 3;
    private HomeDataBinding mHomeDataBinding;
    private FragmentPagerAdapter mFragmentPagerAdapter;


    public static void startHomeActivity(Context activityContext) {
        if (activityContext != null) {
            Intent mIntent = new Intent(activityContext, HomeActivity.class);
            activityContext.startActivity(mIntent);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHomeDataBinding = DataBindingUtil.setContentView(HomeActivity.this, R.layout.activity_home_screen);
        setUpViewPager();
        setUpTabLayout();
        onNewIntent(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        ExtractHelper.getInstance().setIntent(intent, new ExtractHelper.ExtractCallback() {
            @Override
            public void loadViewPagerAtPosition(int position) {
                mHomeDataBinding.fragmentViewPager.setCurrentItem(position);
                mFragmentPagerAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setUpViewPager() {
        mFragmentPagerAdapter = new FragmentAdapter(getSupportFragmentManager());
        mHomeDataBinding.fragmentViewPager.setAdapter(mFragmentPagerAdapter);
        mHomeDataBinding.fragmentViewPager.setCurrentItem(0);
    }

    private void setUpTabLayout() {
        mHomeDataBinding.fragmentTabs.setTabGravity(TabLayout.GRAVITY_FILL);
        mHomeDataBinding.fragmentTabs.post(new Runnable() {
            @Override
            public void run() {
                mHomeDataBinding.fragmentTabs.setupWithViewPager(mHomeDataBinding.fragmentViewPager);
            }
        });

    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: {
                    return Fragment1.getFragment1(null);
                }
                case 1: {
                    return Fragment2.getFragment2(null);
                }

                case 2: {
                    return Fragment3.getFragment3(null);
                }
                default: {
                    return null;
                }
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: {
                    return "Fragment 1";
                }
                case 1: {
                    return "Fragment 2";
                }
                case 2: {
                    return "Fragment 3";
                }
                default: {
                    return "";
                }
            }
        }

        @Override
        public int getCount() {
            return SIZE;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }
}
