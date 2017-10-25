package ru.dimaarts.universaladapterlib.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.dimaarts.universaladapterlib.holders.UniversalViewHolder;
import ru.dimaarts.universaladapterlib.holders.interfaces.BindableViewHolder;
import ru.dimaarts.universaladapterlib.items.ItemWithLayout;
import ru.dimaarts.universaladapterlib.viewmodels.ViewDataBindingViewModel;

/**
 * Created by gorshunovdv on 10/14/2016.
 */
public class UniversalRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<ItemWithLayout> mItems;
    private List<Integer> mTypes = new ArrayList<>();
    private Object mViewModel;
    private Integer mViewModelId;
    private int mModelId;

    public List<ItemWithLayout> getItems() {
        return mItems;
    }

    public UniversalRecyclerViewAdapter(int modelId) {
        this(new ArrayList<ItemWithLayout>(), null, null, modelId);
    }

    public UniversalRecyclerViewAdapter(List<ItemWithLayout> itemList, int modelId) {
        this(itemList, null, null, modelId);
    }

    public UniversalRecyclerViewAdapter(Object viewModel, Integer viewModelId, int modelId) {
        this(new ArrayList<ItemWithLayout>(), viewModel, viewModelId, modelId);
    }

    public UniversalRecyclerViewAdapter(List<ItemWithLayout> itemList, Object viewModel, Integer viewModelId, int modelId) {
        mViewModel = viewModel;
        mViewModelId = viewModelId;
        mItems = itemList;
        for (ItemWithLayout item :
                mItems) {
            addTypeIfNotExists(item);
        }
        mModelId = modelId;
    }

    @Override
    public int getItemViewType(int position) {
        ItemWithLayout currentItem = mItems.get(position);
        return mTypes.indexOf(currentItem.getLayoutId());
    }

    private void addTypeIfNotExists(ItemWithLayout item) {
        if (!mTypes.contains(item.getLayoutId())) {
            mTypes.add(item.getLayoutId());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, mTypes.get(viewType), parent, false);
        if(mViewModel!=null && mViewModel instanceof ViewDataBindingViewModel) {
            ViewDataBindingViewModel viewDataBindingViewModel = (ViewDataBindingViewModel) mViewModel;
            viewDataBindingViewModel.setItemDataBinding(binding);
        }
        if(mViewModel!=null && mViewModelId!=null)
            binding.setVariable(mViewModelId, mViewModel);
        return new UniversalViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemWithLayout currentItem = mItems.get(position);
        if(holder instanceof UniversalViewHolder) {
            BindableViewHolder<ItemWithLayout> bindableViewHolder = (UniversalViewHolder) holder;
            bindableViewHolder.bindTo(mModelId, currentItem);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addItem(ItemWithLayout item) {
        mItems.add(item);
        addTypeIfNotExists(item);
        notifyItemInserted(mItems.size()-1);
    }

    public void insertItem(ItemWithLayout item, int position) {
        mItems.add(position, item);
        addTypeIfNotExists(item);
        notifyItemInserted(position);
    }

    public void replaceItem(int position, ItemWithLayout item) {
        mItems.set(position, item);
        addTypeIfNotExists(item);
        notifyItemChanged(position);
    }

    public void clear() {
        int itemsCount = mItems.size();
        mItems.clear();
        mTypes.clear();
        notifyItemRangeRemoved(0, itemsCount);
    }

    public void addItemsRange(List<ItemWithLayout> drawerItem) {
        mItems.addAll(drawerItem);
        for (ItemWithLayout item : mItems) {
            addTypeIfNotExists(item);
        }
        notifyItemRangeInserted(mItems.size()-drawerItem.size(), drawerItem.size());
    }

    public void removeItem(ItemWithLayout item) {
        int position = mItems.indexOf(item);
        mItems.remove(item);
        notifyItemRemoved(position);
    }
}
