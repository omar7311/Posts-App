package com.example.socialmedia.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.socialmedia.R;
import com.example.socialmedia.data.model.PostModel;
import com.example.socialmedia.databinding.FragmentSavedBinding;
import com.example.socialmedia.ui.adapter.PostAdapter;

import java.util.ArrayList;


public class SavedFragment extends Fragment implements PostAdapter.Comment {
FragmentSavedBinding binding;
   public static ArrayList<PostModel> models=new ArrayList<>();
    PostAdapter adapter=new PostAdapter(this::getComment);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentSavedBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.setPosts(models);
        binding.recycle.setAdapter(adapter);
    }

    @Override
    public void getComment(PostModel postModel) {
        BottomSheetFragment bottomSheetFragment=new BottomSheetFragment();
        bottomSheetFragment.show(getParentFragmentManager(),BottomSheetFragment.TAG);
        Bundle bundle=new Bundle();
        bundle.putInt("key",postModel.getId());
        bottomSheetFragment.setArguments(bundle);
    }
}