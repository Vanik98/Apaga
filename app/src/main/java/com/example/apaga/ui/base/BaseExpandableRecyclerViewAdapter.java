package com.example.apaga.ui.base;

import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

public class BaseExpandableRecyclerViewAdapter <GVH extends GroupViewHolder, CVH extends ChildViewHolder>
        extends ExpandableRecyclerViewAdapter<GVH, CVH> {
    public BaseExpandableRecyclerViewAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    public void notifyGroupDataChanged() {
        expandableList.expandedGroupIndexes = new boolean[getGroups().size()];
        for (int i = 0; i < getGroups().size(); i++) {
            expandableList.expandedGroupIndexes[i] = false;
        }

    }
//    public void notifyChildDataChanged(int position) {
//        expandableList =
//        expandableList.expandedGroupIndexes = new boolean[getGroups().get(position).getItems().size()];
//        for (int i = 0; i < getGroups().get(position).getItems().size(); i++) {
//            expandableList.ge = false;
//        }
//        getGroups().get().getItems()
//    }

    @Override
    public GVH onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public CVH onCreateChildViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindChildViewHolder(CVH holder, int flatPosition, ExpandableGroup group, int childIndex) {

    }

    @Override
    public void onBindGroupViewHolder(GVH holder, int flatPosition, ExpandableGroup group) {

    }
}
