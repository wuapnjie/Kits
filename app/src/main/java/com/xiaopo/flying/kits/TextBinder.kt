package com.xiaopo.flying.kits

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xiaopo.flying.recyclerkit.AnotherBinder
import com.xiaopo.flying.recyclerkit.AnotherViewHolder
import com.xiaopo.flying.recyclerkit.ItemBinder
import kotlinx.android.synthetic.main.item_text.view.*

/**
 * @author wupanjie
 */
class TextBinder : AnotherBinder<String>() {
  override fun renderView(holder: AnotherViewHolder, itemView: View, item: String) {
    itemView.tv_text.text = item
  }

  override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): AnotherViewHolder {
    val itemView = inflater.inflate(R.layout.item_text, parent, false)
    return AnotherViewHolder(itemView)
  }
}