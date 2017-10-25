package ru.dimaarts.universaladapter.dependencies;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by gorshunovdv on 9/27/2016.
 */
public class ItemClickDependency {
    public interface OnItemClickListener {
        void onItemClick(Object param);
    }

    public interface OnItemClickWithViewListener {
        void onItemClick(View view, Object param);
    }

    @BindingAdapter({"onClick", "param"})
    public static void bindOnClick(View view, final OnItemClickListener listener, final Object param) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null)
                    listener.onItemClick(param);
            }
        });
    }

    @BindingAdapter({"onClick", "param", "enabled"})
    public static void bindOnClick2(View view, final OnItemClickListener listener, final Object param, final boolean enabled) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(enabled && listener!=null)
                    listener.onItemClick(param);
            }
        });
    }


    @BindingAdapter({"onClickWithView", "param"})
    public static void bindOnClickView(View view, final OnItemClickWithViewListener listener, final Object param) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null)
                    listener.onItemClick(view, param);
            }
        });
    }
}
