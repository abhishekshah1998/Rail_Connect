package com.abhishekshah.railconnect;


import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
        import com.twitter.sdk.android.tweetui.UserTimeline;

public class TimelineActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("AaaVxXBvWGd7ULJROu6ir6X0n ", "7Xh2NQjqDUM5GrPW3YriAQk59oWsJxOFVXg2hIb3g8WgvdDAfo "))
                .debug(true)
                .build();
        Twitter.initialize(config);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("mumbairailusers")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);
    }
}