package com.example.socialmedia.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.socialmedia.R;
import com.example.socialmedia.data.model.PostModel;
import com.example.socialmedia.databinding.FragmentPostsBinding;
import com.example.socialmedia.ui.adapter.PostAdapter;
import java.util.ArrayList;
import com.example.socialmedia.data.remote.RetrofitClient;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostsFragment extends Fragment implements PostAdapter.Comment {
    FragmentPostsBinding binding;
    PostAdapter adapter=new PostAdapter(this::getComment);
    public PostsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding=FragmentPostsBinding.bind(view);
        getPosts();
        Log.d("tag","onViewCreated");

    }

    private void getPosts() {
        RetrofitClient.getService().getPosts().enqueue(new Callback<ArrayList<PostModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostModel>> call, Response<ArrayList<PostModel>> response) {
                if (response.isSuccessful()) {
                    Log.d("tag", "response success");
                    adapter.setPosts(response.body());
                    binding.recycle.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {

            }
        });
        Log.d("tag", "after callback");
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