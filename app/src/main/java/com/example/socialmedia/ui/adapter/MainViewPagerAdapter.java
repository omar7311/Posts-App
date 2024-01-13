package com.example.socialmedia.ui.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.socialmedia.ui.PostsFragment;
import com.example.socialmedia.ui.ProfileFragment;
import com.example.socialmedia.ui.SavedFragment;

public class MainViewPagerAdapter extends FragmentStateAdapter {
    public MainViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new PostsFragment();
            case 1: return new SavedFragment();
            case 2: return new ProfileFragment();
        }
        return new PostsFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
