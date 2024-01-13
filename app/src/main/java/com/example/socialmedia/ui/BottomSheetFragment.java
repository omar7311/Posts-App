package com.example.socialmedia.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.socialmedia.R;
import com.example.socialmedia.data.model.CommentModel;
import com.example.socialmedia.data.model.PostModel;
import com.example.socialmedia.data.remote.RetrofitClient;
import com.example.socialmedia.databinding.FragmentBottomSheetBinding;
import com.example.socialmedia.ui.adapter.CommentAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BottomSheetFragment extends BottomSheetDialogFragment {
    public static final String TAG = "BottomSheet";
    CommentAdapter adapter = new CommentAdapter();
    FragmentBottomSheetBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
       getComments(bundle.getInt("key", -1));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentBottomSheetBinding.inflate(inflater);
        return binding.getRoot();
    }

    void getComments(int postId) {
       RetrofitClient.getService().getComments(postId).enqueue(new Callback<ArrayList<CommentModel>>() {
           @Override
           public void onResponse(Call<ArrayList<CommentModel>> call, Response<ArrayList<CommentModel>> response) {
               if(response.isSuccessful()) {
                   adapter.setCommentModels(response.body());
                   binding.recycle.setAdapter(adapter);
           }}

           @Override
           public void onFailure(Call<ArrayList<CommentModel>> call, Throwable t) {

           }
       });
    }
}