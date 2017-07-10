package com.xiaopo.flying.recyclerkit

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * @author wupanjie
 */
interface ItemBinder<in T : Any, VH : ViewHolder> {
  fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): VH

  fun bindViewHolder(holder: VH, item: T)
}