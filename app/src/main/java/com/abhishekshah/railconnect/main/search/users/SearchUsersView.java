package com.abhishekshah.railconnect.main.search.users;

import com.abhishekshah.railconnect.main.base.BaseFragmentView;
import com.abhishekshah.railconnect.model.Profile;

import java.util.List;

/**
 * Created by Alexey on 08.06.18.
 */
public interface SearchUsersView extends BaseFragmentView {
    void onSearchResultsReady(List<Profile> profiles);

    void showLocalProgress();

    void hideLocalProgress();

    void showEmptyListLayout();

    void updateSelectedItem();
}
