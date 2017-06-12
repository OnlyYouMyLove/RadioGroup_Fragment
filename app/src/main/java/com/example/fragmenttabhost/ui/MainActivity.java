package com.example.fragmenttabhost.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.example.fragmenttabhost.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.home_tab)
    RadioButton homeTab;
    @BindView(R.id.video_tab)
    RadioButton videoTab;
    @BindView(R.id.msg_tab)
    RadioButton msgTab;
    @BindView(R.id.person_tab)
    RadioButton personTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        replaceFragment(new HomeFragment());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentmanager.beginTransaction();
        transaction.replace(R.id.fl_content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick({R.id.home_tab, R.id.video_tab, R.id.msg_tab, R.id.person_tab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_tab:
                replaceFragment(new HomeFragment());
                break;
            case R.id.video_tab:
                replaceFragment(new VideoFragment());
                break;
            case R.id.msg_tab:
                replaceFragment(new MsgFragment());
                break;
            case R.id.person_tab:
                replaceFragment(new PersonFragment());
                break;
        }
    }
}
