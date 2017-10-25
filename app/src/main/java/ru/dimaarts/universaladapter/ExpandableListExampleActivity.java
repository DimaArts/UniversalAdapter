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
import ru.dimaarts.universaladapter.items.ItemParent;
import ru.dimaarts.universaladapter.items.ItemType1;
import ru.dimaarts.universaladapter.items.ItemType2;
import ru.dimaarts.universaladapterlib.adapters.UniversalExpandableRecyclerViewAdapter;
import ru.dimaarts.universaladapterlib.items.ParentItemWithLayout;
import ru.dimaarts.universaladapterlib.items.ParentListItem;

/**
 * Created by gorshunovdv on 5/22/2017.
 */

public class ExpandableListExampleActivity extends AppCompatActivity implements ListActivity {
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        List<ParentItemWithLayout> items = new ArrayList<>();
        ItemParent parent1 = new ItemParent("Родитель 1");
        parent1.addChild(new ItemType1("Элемент списка 1"));
        parent1.addChild(new ItemType1("Элемент списка 2"));
        parent1.addChild(new ItemType2(Color.rgb(255, 0, 0)));
        parent1.addChild(new ItemType1("Элемент списка 3"));
        items.add(parent1);
        ItemParent parent2 = new ItemParent("Родитель 2");
        parent2.addChild(new ItemType1("Элемент списка 1"));
        parent2.addChild(new ItemType1("Элемент списка 2"));
        parent2.addChild(new ItemType2(Color.rgb(255, 0, 0)));
        parent2.addChild(new ItemType1("Элемент списка 3"));
        parent2.addChild(new ItemType1("Элемент списка 4"));
        parent2.addChild(new ItemType2(Color.rgb(0, 255, 0)));
        parent2.addChild(new ItemType2(Color.rgb(255, 0, 0)));
        parent2.addChild(new ItemType1("Элемент списка 5"));
        parent2.addChild(new ItemType2(Color.rgb(0, 0, 255)));
        parent2.addChild(new ItemType1("Элемент списка 6"));
        parent2.addChild(new ItemType1("Элемент списка 7"));
        parent2.addChild(new ItemType1("Элемент списка 8"));
        parent2.addChild(new ItemType1("Элемент списка 9"));
        parent2.addChild(new ItemType1("Элемент списка 10"));
        items.add(parent2);
        ItemParent parent3 = new ItemParent("Родитель 3");
        parent3.addChild(new ItemType1("Элемент списка 11"));
        items.add(parent3);

        adapter = new UniversalExpandableRecyclerViewAdapter(items, null, null, BR.model);
        binding.setModel(this);
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }
}
