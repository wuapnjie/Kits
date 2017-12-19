package com.xiaopo.flying.kits

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.xiaopo.flying.animatekit.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
  private val SVG_PATH = "M 42.266949,70.444915 C 87.351695,30.995763 104.25847,28.177966 104.25847,28.177966 l 87.3517,36.631356 8.45339,14.088983 L 166.25,104.25847 50.720339,140.88983 c 0,0 -45.0847458,180.33898 -39.449153,194.42797 5.635594,14.08898 67.627119,183.15678 67.627119,183.15678 l 16.90678,81.7161 c 0,0 98.622885,19.72457 115.529665,22.54237 16.90678,2.8178 70.44491,-22.54237 78.8983,-33.81356 8.45339,-11.27118 76.08051,-107.07627 33.81356,-126.80085 -42.26695,-19.72457 -132.43644,-56.35593 -132.43644,-56.35593 0,0 -33.81356,-73.26271 -19.72458,-73.26271 14.08899,0 132.43644,73.26271 138.07204,33.81356 5.63559,-39.44915 19.72457,-169.0678 19.72457,-169.0678 0,0 28.17797,-25.36017 -28.17796,-19.72457 -56.35593,5.63559 -95.80509,11.27118 -95.80509,11.27118 l 42.26695,-87.35169 8.45339,-28.177968"


  private var controller: ManyAnimator.Controller? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)

    btn_animate.setOnClickListener {
      startAnimate()
    }

    btn_pause.setOnClickListener {
      pauseAnimate()
    }

    btn_resume.setOnClickListener {
      resumeAnimate()
    }
  }

  private fun resumeAnimate() {
    controller?.resume()
  }

  private fun pauseAnimate() {
    controller?.pause()
  }

  private fun startAnimate() {
    controller = animate {

//      onStart = {
//        Log.d("ManyAnimator", "start")
//      }
//
//      onEnd = {
//        Log.d("ManyAnimator", "end")
//      }
//
//      together {
//
//        play {
//          targets = arrayListOf(tv_one, tv_two)
//          duration = 1000
//          translation(0f, 100f, 0f)
//        }
//
//        play {
//          targets = arrayListOf(tv_three, tv_four)
//          duration = 500
//          rotation(0f, 180f, 0f)
//        }
//
//        play {
//          targets = arrayListOf(tv_five, tv_six)
//          duration = 100
//          scale(0f, 2f, 1f)
//        }
//      }
//
//      delay(1000)

      play {
        targets = arrayListOf(tv_seven, tv_eight)
        repeatCount = 10
        duration = 1000
//        onStart = {
//          Log.d("Last", "start")
//        }
//
//        onEnd = {
//          Log.d("Last", "end")
//        }
        newsPaper()
      }

    }.start()
  }
}

fun AnAnimator.svgPath(dAttributeOfPath: String) {
  path(SvgPathParser.tryParsePath(dAttributeOfPath)!!)
}
