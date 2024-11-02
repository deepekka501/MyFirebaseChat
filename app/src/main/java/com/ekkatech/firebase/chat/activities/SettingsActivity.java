package com.ekkatech.firebase.chat.activities;

import static com.ekkatech.firebase.chat.activities.constants.IConstants.CLICK_DELAY_TIME;
import static com.ekkatech.firebase.chat.activities.constants.IConstants.FALSE;
import static com.ekkatech.firebase.chat.activities.constants.IConstants.PATH_ABOUT_US;
import static com.ekkatech.firebase.chat.activities.constants.IConstants.PATH_PRIVACY_POLICY;
import static com.ekkatech.firebase.chat.activities.constants.IConstants.TRUE;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import com.ekkatech.firebase.chat.activities.managers.SessionManager;
import com.ekkatech.firebase.chat.activities.managers.Utils;
import com.ekkatech.firebase.chat.activities.settings.PrivacySettingActivity;
import com.ekkatech.firebase.chat.activities.views.SingleClickListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SettingsActivity extends BaseActivity implements View.OnClickListener {

    private SwitchCompat notificationOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        final Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.strSettings);
        mToolbar.setNavigationOnClickListener(new SingleClickListener() {
            @Override
            public void onClickView(View v) {
                onBackPressed();
            }
        });

        final LinearLayout layoutNotification = findViewById(R.id.layoutNotification);
        final LinearLayout layoutPrivacySettings = findViewById(R.id.layoutPrivacySettings);
//        final LinearLayout layoutShare = findViewById(R.id.layoutShare);
//        final LinearLayout layoutAbout = findViewById(R.id.layoutAbout);
//        final LinearLayout layoutPrivacyPolicy = findViewById(R.id.layoutPrivacyPolicy);
        final LinearLayout layoutLogout = findViewById(R.id.layoutLogout);
        final LinearLayout layoutTakeTour = findViewById(R.id.layoutTakeTour);

        final TextView mTxtVersionName = findViewById(R.id.txtAppVersion);
        mTxtVersionName.setText(String.format(getString(R.string.settingVersion), BuildConfig.VERSION_NAME));




        notificationOnOff = findViewById(R.id.notificationOnOff);
        notificationOnOff.setOnCheckedChangeListener((compoundButton, b) -> SessionManager.get().setOnOffNotification(b));

        if (SessionManager.get().isNotificationOn()) {
            notificationOnOff.setChecked(TRUE);
        } else {
            notificationOnOff.setChecked(FALSE);
        }

        layoutNotification.setOnClickListener(this);
        layoutPrivacySettings.setOnClickListener(this);
//        layoutShare.setOnClickListener(this);
//        layoutAbout.setOnClickListener(this);
//        layoutPrivacyPolicy.setOnClickListener(this);
        layoutLogout.setOnClickListener(this);
        layoutTakeTour.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final int id = view.getId();
        if (id == R.id.layoutNotification) {
            if (notificationOnOff.isChecked()) {
                notificationOnOff.setChecked(FALSE);
            } else {
                notificationOnOff.setChecked(TRUE);
            }
        }
        else if (id == R.id.layoutPrivacySettings) {
            screens.showCustomScreen(PrivacySettingActivity.class);
        }
        else if (id == R.id.layoutTakeTour) {
            screens.openOnBoardingScreen(TRUE);
        }
//        else if (id == R.id.layoutShare) {
//            Utils.shareApp(mActivity);
//        }
//        else if (id == R.id.layoutAbout) {
//            new Handler(Looper.getMainLooper()).postDelayed(() -> screens.openWebViewActivity(getString(R.string.lblAboutUs), PATH_ABOUT_US), CLICK_DELAY_TIME);
//        }
//        else if (id == R.id.layoutPrivacyPolicy) {
//            new Handler(Looper.getMainLooper()).postDelayed(() -> screens.openWebViewActivity(getString(R.string.lblPrivacyPolicy), PATH_PRIVACY_POLICY), CLICK_DELAY_TIME);
//        }
        else if (id == R.id.layoutLogout) {
            Utils.logout(mActivity);
        }
    }



}
