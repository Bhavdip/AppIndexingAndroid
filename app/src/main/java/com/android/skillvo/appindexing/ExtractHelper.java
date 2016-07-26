package com.android.skillvo.appindexing;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ExtractHelper {
    public interface ExtractCallback {
        void loadViewPagerAtPosition(int position);
    }

    public static ExtractHelper mExtractHelper = new ExtractHelper();
    private String intentData;
    private boolean isFragment1;
    private boolean isFragment2;
    private boolean isFragment3;

    private ExtractHelper() {
    }

    public static ExtractHelper getInstance() {
        return mExtractHelper;
    }

    public void setIntent(Intent intent, ExtractCallback extractCallback) {
        String action = intent.getAction();
        Uri data = intent.getData();
        if (Intent.ACTION_VIEW.equals(action) && data != null) {
            intentData = data.getLastPathSegment();
            if (data.toString().contains("1")) {
                isFragment1 = true;
                isFragment2 = false;
                isFragment3 = false;
                extractCallback.loadViewPagerAtPosition(0);
            } else if (data.toString().contains("2")) {
                isFragment1 = false;
                isFragment2 = true;
                isFragment3 = false;
                extractCallback.loadViewPagerAtPosition(1);
            } else if (data.toString().contains("3")) {
                isFragment1 = false;
                isFragment2 = false;
                isFragment3 = true;
                extractCallback.loadViewPagerAtPosition(2);
            }
        }
    }

    public boolean isForFragment1() {
        return isFragment1;
    }

    public boolean isForFragment2() {
        return isFragment2;
    }

    public boolean isForFragment3() {
        return isFragment3;
    }

    public String getMessageData() {
        return intentData;
    }
}
