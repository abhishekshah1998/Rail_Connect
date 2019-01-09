

package com.abhishekshah.railconnect.model;


import com.abhishekshah.railconnect.enums.ItemType;

public interface LazyLoading {
    ItemType getItemType();
    void setItemType(ItemType itemType);
}
