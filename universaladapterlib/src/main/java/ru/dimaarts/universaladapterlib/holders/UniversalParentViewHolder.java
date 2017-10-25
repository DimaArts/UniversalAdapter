package ru.dimaarts.universaladapterlib.holders;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;

import ru.dimaarts.universaladapterlib.holders.interfaces.BindableViewHolder;
import ru.dimaarts.universaladapterlib.items.Item;
import ru.dimaarts.universaladapterlib.items.ParentExpandableItem;

public class UniversalParentViewHolder extends ParentViewHolder implements BindableViewHolder<Item> {
    private ViewDataBinding mBinding;
    private ParentExpandableItem bindedExpandableItem;

    @Override
    public void setExpanded(boolean expanded) {
        super.setExpanded(expanded);
        if(bindedExpandableItem != null) {
            bindedExpandableItem.setExpanded(expanded);
         }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if(bindedExpandableItem != null) {
            bindedExpandableItem.setClickToExpanded(isExpanded());
         }
    }

    public UniversalParentViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public ViewDataBinding getBinding() {
            return mBinding;
        }

        @Override
        public void bindTo(int modelId, Item item) {
            bindedExpandableItem = item instanceof ParentExpandableItem ? (ParentExpandableItem) item: null;
            mBinding.setVariable(modelId, item);
            mBinding.executePendingBindings();
        }
    }
