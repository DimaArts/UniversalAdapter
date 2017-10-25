package ru.dimaarts.universaladapterlib.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import ru.dimaarts.universaladapterlib.holders.UniversalChildViewHolder;
import ru.dimaarts.universaladapterlib.holders.UniversalParentViewHolder;
import ru.dimaarts.universaladapterlib.items.ChildItemWithLayout;
import ru.dimaarts.universaladapterlib.items.ItemWithLayout;
import ru.dimaarts.universaladapterlib.items.ParentItemWithLayout;
import ru.dimaarts.universaladapterlib.items.ParentListItem;
import ru.dimaarts.universaladapterlib.viewmodels.ViewDataBindingViewModel;

/**
 * Created by gorshunovdv on 5/17/2017.
 */

public class UniversalExpandableRecyclerViewAdapter extends ExpandableRecyclerAdapter<ParentItemWithLayout, ChildItemWithLayout, UniversalParentViewHolder, UniversalChildViewHolder> {
    private List<ParentItemWithLayout> mItems;
    private Integer mViewModelId;
    private int mModelId;
    private Object mViewModel;

    private List<Integer> mParentTypes = new ArrayList<>();
    private List<Integer> mChildTypes = new ArrayList<>();

    public UniversalExpandableRecyclerViewAdapter(@NonNull List<ParentItemWithLayout> parentItemList, Object viewModel, Integer viewModelId, int modelId) {
        super(parentItemList);
        mItems = parentItemList;
        for (ParentItemWithLayout item :
                mItems) {
            addParentTypeIfNotExists(item);
            for (Object childItem :
                    item.getChildList()) {
                addChildTypeIfNotExists((ItemWithLayout) childItem);
            }
        }
        mViewModel = viewModel;
        mViewModelId = viewModelId;
        mModelId = modelId;
    }

    @NonNull
    @Override
    public UniversalParentViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parentViewGroup.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, mParentTypes.get(viewType), parentViewGroup, false);
        if(mViewModel!=null && mViewModel instanceof ViewDataBindingViewModel) {
            ViewDataBindingViewModel viewDataBindingViewModel = (ViewDataBindingViewModel) mViewModel;
            viewDataBindingViewModel.setItemDataBinding(binding);
        }
        if(mViewModel!=null && mViewModelId!=null) {
            binding.setVariable(mViewModelId, mViewModel);
        }
        return new UniversalParentViewHolder(binding);
    }

    @NonNull
    @Override
    public UniversalChildViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(childViewGroup.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, mChildTypes.get(-viewType-1), childViewGroup, false);
        if(mViewModel!=null && mViewModel instanceof ViewDataBindingViewModel) {
            ViewDataBindingViewModel viewDataBindingViewModel = (ViewDataBindingViewModel) mViewModel;
            viewDataBindingViewModel.setItemDataBinding(binding);
        }
        if(mViewModel!=null && mViewModelId!=null) {
            binding.setVariable(mViewModelId, mViewModel);
        }
        return new UniversalChildViewHolder(binding);
    }

    private void addParentTypeIfNotExists(ItemWithLayout item) {
        if (!mParentTypes.contains(item.getLayoutId())) {
            mParentTypes.add(item.getLayoutId());
        }
    }

    private void addChildTypeIfNotExists(ItemWithLayout item) {
        if (!mChildTypes.contains(item.getLayoutId())) {
            mChildTypes.add(item.getLayoutId());
        }
    }

    @Override
    public boolean isParentViewType(int viewType) {
        return viewType>=0;
    }

    public int getParentItemPosition(ParentListItem item) {
        int listItemCount = mFlatItemList.size();
        for (int i = 0; i < listItemCount; i++) {
            if (mFlatItemList.get(i).isParent()) {
                ParentListItem parent = mFlatItemList.get(i).getParent();
                if (parent == item) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int getParentViewType(int parentPosition) {
        ItemWithLayout currentItem = mItems.get(parentPosition);
        return mParentTypes.indexOf(currentItem.getLayoutId());
    }

    @Override
    public int getChildViewType(int parentPosition, int childPosition) {
        ParentItemWithLayout currentItem = mItems.get(parentPosition);
        ItemWithLayout child = currentItem.getChildList().get(childPosition);
        return -(mChildTypes.indexOf(child.getLayoutId())+1);
    }

    @Override
    public void onBindParentViewHolder(@NonNull UniversalParentViewHolder parentViewHolder, int parentPosition, @NonNull ParentItemWithLayout parent) {
        parentViewHolder.bindTo(mModelId, parent);
    }

    @Override
    public void onBindChildViewHolder(@NonNull UniversalChildViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull ChildItemWithLayout child) {
        childViewHolder.bindTo(mModelId, child);
    }

}
