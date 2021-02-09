package com.example.parstagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class PostsAdapter extends  RecyclerView.Adapter<PostsAdapter.ViewHolder>{
    Context context;
    List<Post> posts;

    // Pass in context and list of tweets

    public PostsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    // For each row, inflate the layout for tweet
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    // Bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // get the data at position
        Post post = posts.get(position);
        // bind the post with view holder
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void clear() {
        this.posts.clear();
    }

//    @GlideModule
//    public final class MyAppGlideModule extends AppGlideModule {
//        // leave empty for now
//    }

    // Define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImagePost;
        TextView tvUsername;
        TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagePost = itemView.findViewById(R.id.ivPostImage);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        public void bind(Post post) {
            tvUsername.setText(post.getUser().getUsername());
            tvDescription.setText(post.getDescription());
            if (post.getImage() != null) {
                Glide.with(context).load(post.getImage().getUrl()).into(ivImagePost);
            }
//            tvScreenName.setText(tweet.user.screenName);
//            Glide.with(context).load(tweet.user.profileImageUrl).into(ivProfileImage);
//            tvTimestamp.setText(Tweet.getFormattedTimestamp(tweet.createdAt));
        }
    }
}
