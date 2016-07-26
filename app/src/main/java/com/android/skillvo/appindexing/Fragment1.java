package com.android.skillvo.appindexing;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.skillvo.appindexing.databinding.Fragment1DataBinding;


public class Fragment1 extends Fragment {

    private Fragment1DataBinding mFragment1DataBinding;

    public static Fragment getFragment1(Bundle bundle) {
        Fragment1 mFragment1 = new Fragment1();
        mFragment1.setArguments(bundle);
        return mFragment1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragment1DataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment1_screen, container, false);
        bindMessage();
        return mFragment1DataBinding.getRoot();
    }

    private void bindMessage() {
        if (mFragment1DataBinding != null) {
            if (ExtractHelper.getInstance().isForFragment1()) {
                if (!TextUtils.isEmpty(ExtractHelper.getInstance().getMessageData())) {
                    mFragment1DataBinding.textViewMessage.setText(ExtractHelper.getInstance().getMessageData());
                }
            }

        }
    }
}
