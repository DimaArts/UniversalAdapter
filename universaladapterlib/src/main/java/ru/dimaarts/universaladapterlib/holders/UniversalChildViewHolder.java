package ru.dimaarts.universaladapterlib.holders;

import android.databinding.ViewDataBinding;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;

import ru.dimaarts.universaladapterlib.holders.interfaces.BindableViewHolder;
import ru.dimaarts.universaladapterlib.items.ItemWithLayout;

/**
 * Created by gorshunovdv on 10/14/2016.
 */
public class UniversalChildViewHolder extends ChildViewHolder implements BindableViewHolder<ItemWithLayout> {
    private ViewDataBinding mBinding;

    public UniversalChildViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    @Override
    public ViewDataBinding getBinding() {
        return mBinding;
    }

    @Override
    public void bindTo(int modelId, ItemWithLayout item) {
        mBinding.setVariable(modelId, item);
        mBinding.executePendingBindings();
    }
}
