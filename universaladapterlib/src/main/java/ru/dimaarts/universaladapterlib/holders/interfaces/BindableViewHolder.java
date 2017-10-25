package ru.dimaarts.universaladapterlib.holders.interfaces;

import android.databinding.ViewDataBinding;

import ru.dimaarts.universaladapterlib.items.Item;

/**
 * Created by gorshunovdv on 9/23/2016.
 */
public interface BindableViewHolder<AT extends Item>  {
    <T extends ViewDataBinding> T getBinding();
    void bindTo(int modelId, AT item);
}
