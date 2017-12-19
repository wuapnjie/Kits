package com.xiaopo.flying.recyclerkit

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * @author wupanjie
 */

fun RecyclerView.with(adapter: AnotherAdapter,
                      layoutManager: LinearLayoutManager = LinearLayoutManager(this.context)) = apply {
  this.adapter = adapter
  this.layoutManager = layoutManager
}

fun RecyclerView.with(itemDecoration: RecyclerView.ItemDecoration) = apply {
  this.addItemDecoration(itemDecoration)
}
