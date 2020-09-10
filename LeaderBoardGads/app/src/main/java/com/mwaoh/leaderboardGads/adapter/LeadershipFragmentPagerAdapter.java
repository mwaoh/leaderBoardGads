package com.mwaoh.leaderboardGads.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mwaoh.leaderboardGads.R;
import com.mwaoh.leaderboardGads.fragment.LearningFragment;
import com.mwaoh.leaderboardGads.fragment.SkillsFragment;

public class LeadershipFragmentPagerAdapter extends FragmentStateAdapter {

    final int PAGE_COUNT = 2;
    @StringRes
    private static final int[] TAB_TITLES = new int[] { R.string.learning_leaders, R.string.skill_leaders};


    public LeadershipFragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new LearningFragment();
                break;
            case 1:
                fragment = new SkillsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return PAGE_COUNT;
    }


}
