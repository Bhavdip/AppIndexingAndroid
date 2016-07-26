package com.android.skillvo.appindexing;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.skillvo.appindexing.databinding.Fragment2DataBinding;


public class Fragment2 extends Fragment {

    private Fragment2DataBinding mFragment2DataBinding;

    public static Fragment getFragment2(Bundle bundle) {
        Fragment2 mFragment2 = new Fragment2();
        mFragment2.setArguments(bundle);
        return mFragment2;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragment2DataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment2_screen, container, false);
        bindMessage();
        return mFragment2DataBinding.getRoot();
    }

    private void bindMessage() {
        if (mFragment2DataBinding != null) {
            if (ExtractHelper.getInstance().isForFragment2()) {
                if (!TextUtils.isEmpty(ExtractHelper.getInstance().getMessageData())) {
                    mFragment2DataBinding.textViewMessage.setText(ExtractHelper.getInstance().getMessageData());
                }
            }

        }
    }
}
