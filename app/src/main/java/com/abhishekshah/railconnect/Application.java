

package com.abhishekshah.railconnect;

import com.abhishekshah.railconnect.main.interactors.PostInteractor;

public class Application extends android.app.Application {

    public static final String TAG = Application.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationHelper.initDatabaseHelper(this);
        PostInteractor.getInstance(this).subscribeToNewPosts();
    }
}
