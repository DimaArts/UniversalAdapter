package ru.dimaarts.universaladapter.dependencies;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by gorshunovdv on 9/23/2016.+
 */
public class RVSettingsDependency {
    @BindingAdapter("initDefaultRVSettings")
    public static void setDefaultRecyclerViewSettings(RecyclerView view, boolean apply) {
        if (apply) {
            defaultSetupRecyclerView(view.getContext(), view, false);
        }
    }

    @BindingAdapter("initDefaultInverseRVSettings")
    public static void setDefaultInverseRecyclerViewSettings(RecyclerView view, boolean apply) {
        if (apply) {
            defaultSetupRecyclerView(view.getContext(), view, true);
        }
    }

    @BindingAdapter("adapter")
    public static void setRecyclerViewAdapterSettings(RecyclerView view, RecyclerView.Adapter
            adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter("adapter")
    public static void setRecyclerViewAdapterSettings(ListView view, ListAdapter adapter) {
        view.setAdapter(adapter);
    }

    private static void defaultSetupRecyclerView(Context context, RecyclerView recyclerView, boolean inverse) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setReverseLayout(inverse);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);

    }
}