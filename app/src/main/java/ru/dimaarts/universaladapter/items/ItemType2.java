package ru.dimaarts.universaladapter.items;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import ru.dimaarts.universaladapter.BR;
import ru.dimaarts.universaladapter.R;
import ru.dimaarts.universaladapterlib.items.ChildItemWithLayout;
import ru.dimaarts.universaladapterlib.items.ItemWithLayout;

/**
 * Created by gorshunovdv on 5/22/2017.
 */

public class ItemType2 extends BaseObservable implements ChildItemWithLayout {
    private int color;

    public ItemType2(int color) {
        this.color = color;
    }

    @Bindable
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        notifyPropertyChanged(BR.color);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_type2;
    }
}
