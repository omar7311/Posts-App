package com.example.socialmedia.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialmedia.data.model.CommentModel;
import com.example.socialmedia.databinding.CommentItemBinding;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {
    ArrayList<CommentModel> commentModels=new ArrayList<>();
   public void setCommentModels(ArrayList<CommentModel> commentModels){
        this.commentModels=commentModels;
    }
    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CommentItemBinding binding=CommentItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new CommentHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
      CommentModel commentModel=commentModels.get(position);
      holder.binding.name.setText(commentModel.getName());
        holder.binding.email.setText(commentModel.getEmail());
        holder.binding.comment.setText(commentModel.getBody());
    }



    @Override
    public int getItemCount() {
        return commentModels==null?0:commentModels.size();
    }
    static class CommentHolder extends RecyclerView.ViewHolder{
        CommentItemBinding binding;
        public CommentHolder(CommentItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
