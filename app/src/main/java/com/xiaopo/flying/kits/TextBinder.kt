package com.xiaopo.flying.kits

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xiaopo.flying.kits.TextBinder.TextViewHolder
import com.xiaopo.flying.recyclerkit.ItemBinder
import kotlinx.android.synthetic.main.item_text.view.tv_text

/**
 * @author wupanjie
 */
class TextBinder : ItemBinder<String, TextViewHolder>() {
  override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): TextViewHolder {
    val itemView = inflater.inflate(R.layout.item_text, parent, false)
    return TextViewHolder(itemView)
  }

  override fun bindViewHolder(holder: TextViewHolder, item: String) {
    holder.itemView.tv_text.text = "HHHHHH + ${position}"
  }

  class TextViewHolder(itemView: View) : ViewHolder(itemView) {

  }
}