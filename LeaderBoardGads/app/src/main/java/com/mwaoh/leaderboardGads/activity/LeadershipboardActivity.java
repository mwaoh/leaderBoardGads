package com.mwaoh.leaderboardGads.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mwaoh.leaderboardGads.R;
import com.mwaoh.leaderboardGads.adapter.LeadershipFragmentPagerAdapter;

public class LeadershipboardActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;
    private ViewPager2 mViewPager2;
    private FragmentStateAdapter leadershipFragmentPagerAdapter;
    private TabLayout mTabLayout;
    private static final int[] TAB_TITLES = new int[] { R.string.learning_leaders, R.string.skill_leaders};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leadershipboard);

        mButton = findViewById(R.id.submit_button);
        mViewPager2 = findViewById(R.id.pager);
        leadershipFragmentPagerAdapter =
                new LeadershipFragmentPagerAdapter(this);
        mViewPager2.setAdapter(leadershipFragmentPagerAdapter);

        mTabLayout = findViewById(R.id.tabs);

        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(getResources().getString(TAB_TITLES[position]));
            }
        }).attach();

        mButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        if (mViewPager2.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mViewPager2.setCurrentItem(mViewPager2.getCurrentItem() - 1);
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.submit_button) {
            Intent intent = new Intent(this, ProjectSubmissionActivity.class);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

    }

}