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

public class ItemType1 extends BaseObservable implements ChildItemWithLayout {
    private String text;

    public ItemType1(String text) {
        this.text = text;
    }

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_type1;
    }
}
