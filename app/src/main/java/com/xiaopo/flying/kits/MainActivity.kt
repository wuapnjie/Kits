package com.xiaopo.flying.kits

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xiaopo.flying.animatekit.AnAnimator
import com.xiaopo.flying.animatekit.ManyAnimator
import com.xiaopo.flying.recyclerkit.AnotherAdapter
import com.xiaopo.flying.recyclerkit.with
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.item_text.view.*

class MainActivity : AppCompatActivity() {
  private val SVG_PATH = "M 42.266949,70.444915 C 87.351695,30.995763 104.25847,28.177966 104.25847,28.177966 l 87.3517,36.631356 8.45339,14.088983 L 166.25,104.25847 50.720339,140.88983 c 0,0 -45.0847458,180.33898 -39.449153,194.42797 5.635594,14.08898 67.627119,183.15678 67.627119,183.15678 l 16.90678,81.7161 c 0,0 98.622885,19.72457 115.529665,22.54237 16.90678,2.8178 70.44491,-22.54237 78.8983,-33.81356 8.45339,-11.27118 76.08051,-107.07627 33.81356,-126.80085 -42.26695,-19.72457 -132.43644,-56.35593 -132.43644,-56.35593 0,0 -33.81356,-73.26271 -19.72458,-73.26271 14.08899,0 132.43644,73.26271 138.07204,33.81356 5.63559,-39.44915 19.72457,-169.0678 19.72457,-169.0678 0,0 28.17797,-25.36017 -28.17796,-19.72457 -56.35593,5.63559 -95.80509,11.27118 -95.80509,11.27118 l 42.26695,-87.35169 8.45339,-28.177968"


  private var controller: ManyAnimator.Controller? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)

    val adapter = AnotherAdapter().with(R.layout.item_text, String::class.java) {
      tv_text.text = it
    }


    adapter.items = arrayListOf("HHH", "HHHH", "HHHHH")

    text_list.with(adapter)
//    text_list.layoutManager = LinearLayoutManager(this)
//    text_list.adapter = adapter

  }

  fun AnAnimator.svgPath(dAttributeOfPath: String) {
    path(SvgPathParser.tryParsePath(dAttributeOfPath)!!)
  }
}


