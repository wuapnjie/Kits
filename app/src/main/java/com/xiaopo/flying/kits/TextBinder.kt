package com.xiaopo.flying.kits

import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiaopo.flying.recyclerkit.AnotherViewHolder
import com.xiaopo.flying.recyclerkit.ItemBinder
import kotlinx.android.synthetic.main.item_text.view.*

/**
 * @author wupanjie
 */
class TextBinder : ItemBinder<String, AnotherViewHolder> {
  override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): AnotherViewHolder {
    val itemView = inflater.inflate(R.layout.item_text, parent, false)
    return AnotherViewHolder(itemView)
  }

  override fun bindViewHolder(holder: AnotherViewHolder, item: String) {
    holder.itemView.tv_text.text = "HHHHHH + ${holder.adapterPosition}"
  }
}