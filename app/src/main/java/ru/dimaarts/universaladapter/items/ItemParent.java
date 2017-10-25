package ru.dimaarts.universaladapter.items;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

import ru.dimaarts.universaladapter.BR;
import ru.dimaarts.universaladapter.R;
import ru.dimaarts.universaladapterlib.items.ChildItemWithLayout;
import ru.dimaarts.universaladapterlib.items.ParentExpandableItem;
import ru.dimaarts.universaladapterlib.items.ParentItemWithLayout;

/**
 * Created by gorshunovdv on 5/22/2017.
 */

public class ItemParent extends BaseObservable implements ParentItemWithLayout, ParentExpandableItem {
    private List<ChildItemWithLayout> childItems = new ArrayList();
    private boolean expanded;
    private String text;

    public ItemParent(String text) {
        this.text = text;
    }

    public void addChild(ChildItemWithLayout child) {
        childItems.add(child);
    }

    @Override
    public List<ChildItemWithLayout> getChildList() {
        return childItems;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_parent;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        notifyPropertyChanged(BR.expanded);
    }

    @Bindable
    public boolean getExpanded() {
        return expanded;
    }

    @Override
    public void setClickToExpanded(boolean clickToExpanded) {

    }

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }
}
