package ru.dimaarts.universaladapter;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.dimaarts.universaladapter.databinding.ActivityListBinding;
import ru.dimaarts.universaladapter.interfaces.ListActivity;
import ru.dimaarts.universaladapter.items.ItemType1;
import ru.dimaarts.universaladapter.items.ItemType2;
import ru.dimaarts.universaladapterlib.adapters.UniversalRecyclerViewAdapter;
import ru.dimaarts.universaladapterlib.items.ItemWithLayout;

/**
 * Created by gorshunovdv on 5/22/2017.
 */

public class SimpleListExampleActivity extends AppCompatActivity implements ListActivity {
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        List<ItemWithLayout> items = new ArrayList();
        items.add(new ItemType1("Элемент списка 1"));
        items.add(new ItemType1("Элемент списка 2"));
        items.add(new ItemType2(Color.rgb(255, 0, 0)));
        items.add(new ItemType1("Элемент списка 3"));
        items.add(new ItemType1("Элемент списка 4"));
        items.add(new ItemType2(Color.rgb(0, 255, 0)));
        items.add(new ItemType2(Color.rgb(255, 0, 0)));
        items.add(new ItemType1("Элемент списка 5"));
        items.add(new ItemType2(Color.rgb(0, 0, 255)));
        items.add(new ItemType1("Элемент списка 6"));
        items.add(new ItemType1("Элемент списка 7"));
        items.add(new ItemType1("Элемент списка 8"));
        items.add(new ItemType1("Элемент списка 9"));
        items.add(new ItemType1("Элемент списка 10"));
        items.add(new ItemType1("Элемент списка 11"));
        adapter = new UniversalRecyclerViewAdapter(items, BR.model);
        binding.setModel(this);
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }
}
