package ru.dimaarts.universaladapter.dependencies;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;

/**
 * Created by gorshunovdv on 9/28/2016.
 */
public class RotationDependency {
    @BindingAdapter("rotation")
    public static void setViewRotation(View view, float angle){
        setRotation(view, angle, null, null);
    }

    private static void setRotation(final View view, final float angle, final Float offsetPivotX, final Float offsetPivotY){
        try {
            if(offsetPivotX != null) view.setPivotX(view.getWidth() - offsetPivotX);
            else view.setPivotX(view.getWidth() / 2);
            if(offsetPivotY!=null) view.setPivotY(view.getHeight() - offsetPivotY);
            else view.setPivotX(view.getHeight() / 2);
            view.setRotation(angle);
        } catch (Exception e1) {
            Log.d("test", e1.getMessage());
        }
    }
}
