package com.android.skillvo.appindexing;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.skillvo.appindexing.databinding.Fragment3DataBinding;

public class Fragment3 extends Fragment {

    private Fragment3DataBinding mFragment3DataBinding;

    public static Fragment getFragment3(Bundle bundle) {
        Fragment3 mFragment3 = new Fragment3();
        mFragment3.setArguments(bundle);
        return mFragment3;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragment3DataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment3_screen, container, false);
        bindMessage();
        return mFragment3DataBinding.getRoot();
    }

    private void bindMessage() {
        if (mFragment3DataBinding != null) {
            if (ExtractHelper.getInstance().isForFragment3()) {
                if (!TextUtils.isEmpty(ExtractHelper.getInstance().getMessageData())) {
                    mFragment3DataBinding.textViewMessage.setText(ExtractHelper.getInstance().getMessageData());
                }
            }

        }
    }
}
