package com.abhishekshah.railconnect.adapters.holders;

import android.view.View;

import com.abhishekshah.railconnect.main.base.BaseActivity;
import com.abhishekshah.railconnect.managers.listeners.OnPostChangedListener;
import com.abhishekshah.railconnect.model.FollowingPost;
import com.abhishekshah.railconnect.model.Post;
import com.abhishekshah.railconnect.utils.LogUtil;


public class FollowPostViewHolder extends PostViewHolder {


    public FollowPostViewHolder(View view, OnClickListener onClickListener, BaseActivity activity) {
        super(view, onClickListener, activity);
    }

    public FollowPostViewHolder(View view, OnClickListener onClickListener, BaseActivity activity, boolean isAuthorNeeded) {
        super(view, onClickListener, activity, isAuthorNeeded);
    }

    public void bindData(FollowingPost followingPost) {
        postManager.getSinglePostValue(followingPost.getPostId(), new OnPostChangedListener() {
            @Override
            public void onObjectChanged(Post obj) {
                bindData(obj);
            }

            @Override
            public void onError(String errorText) {
                LogUtil.logError(TAG, "bindData", new RuntimeException(errorText));
            }
        });
    }

}
