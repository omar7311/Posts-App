package com.example.socialmedia.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.socialmedia.data.model.PostModel;
import com.example.socialmedia.databinding.PostItemBinding;
import com.example.socialmedia.ui.BottomSheetFragment;
import com.example.socialmedia.ui.MainActivity;
import com.example.socialmedia.ui.PostsFragment;
import com.example.socialmedia.ui.SavedFragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

   private ArrayList<PostModel> posts =new ArrayList<>();
   private final Comment comment;
    public PostAdapter(Comment comment) {
        this.comment=comment;
    }

    public void setPosts(ArrayList<PostModel> posts){
       this.posts=posts;

   }
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostItemBinding binding= PostItemBinding.inflate(LayoutInflater.from(parent.getContext())
                ,parent,false);
        return new PostHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        PostModel postModel=posts.get(position);
        holder.binding.title.setText(postModel.getTitle());
        holder.binding.body.setText(postModel.getBody());
    }

    @Override
    public int getItemCount() {
        return posts==null ? 0:posts.size() ;
    }

    public class PostHolder extends RecyclerView.ViewHolder{
        PostItemBinding binding;
        public PostHolder(PostItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            binding.comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comment.getComment(posts.get(getLayoutPosition()));
                }
            });
          binding.love.addOnCheckedStateChangedListener(new MaterialCheckBox.OnCheckedStateChangedListener() {
              @Override
              public void onCheckedStateChangedListener(@NonNull MaterialCheckBox checkBox, int state) {
                  if(state==MaterialCheckBox.STATE_CHECKED){
                      SavedFragment.models.add(posts.get(getLayoutPosition()));
                  }
                  if(state==MaterialCheckBox.STATE_UNCHECKED){
                      SavedFragment.models.remove(posts.get(getLayoutPosition()));
                  }
              }
          });
        }
    }
public interface Comment{
        void getComment(PostModel postModel);
}
}
