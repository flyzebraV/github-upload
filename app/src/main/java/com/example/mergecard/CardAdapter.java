package com.example.mergecard;

import android.view.View;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 描述：
 * 创建人：LWS
 * 创建时间: 2020/10/10
 */
public class CardAdapter extends BaseQuickAdapter<String, BaseViewHolder> implements ItemTouchHelperListener {
    ItemTouchHelper mHelper;

    public CardAdapter(@Nullable List<String> data) {
        super(R.layout.item_card, data);
    }

    @Override
    protected void convert(@NotNull final BaseViewHolder viewHolder, String s) {
        viewHolder.setText(R.id.tv_content, viewHolder.getLayoutPosition() + "");
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mHelper.startDrag(viewHolder);
                return false;
            }
        });
    }

    @Override
    protected boolean setOnItemLongClick(@NotNull View v, int position) {
        return super.setOnItemLongClick(v, position);
    }

    @Override
    public void onItemMove(RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        target.itemView.setScaleX(1.3f);
        target.itemView.setScaleY(1.3f);
    }

    @Override
    public void onItemDissmiss(RecyclerView.ViewHolder source) {

    }

    @Override
    public void onItemSelect(RecyclerView.ViewHolder source) {

    }

    @Override
    public void onItemClear(RecyclerView.ViewHolder source) {

    }

    public void setHelper(@NotNull ItemTouchHelper mHelper) {
        this.mHelper = mHelper;
    }
}
