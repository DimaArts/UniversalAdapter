package ru.dimaarts.universaladapterlib.holders;

import android.databinding.ViewDataBinding;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;

import ru.dimaarts.universaladapterlib.holders.interfaces.BindableViewHolder;
import ru.dimaarts.universaladapterlib.items.ItemWithLayout;

/**
 * Created by gorshunovdv on 10/14/2016.
 */
public class UniversalViewHolder extends ParentViewHolder implements BindableViewHolder<ItemWithLayout> {
    private ViewDataBinding mBinding;

        public UniversalViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public ViewDataBinding getBinding() {
            return mBinding;
        }

    @Override
    public void bindTo(int modelId, ItemWithLayout item) {
        mBinding.setVariable(modelId, item);
        mBinding.executePendingBindings();
    }
}
