package com.xiaopo.flying.animatekit

import android.animation.*
import android.annotation.TargetApi
import android.graphics.Path
import android.graphics.PathMeasure
import android.os.Build
import android.view.View

/**
 * @author wupanjie
 */
internal typealias Listener = () -> Unit

fun quickAnimate(init: ManyAnimator.() -> Unit) = ManyAnimator.Controller(ManyAnimator().apply(init))

class ManyAnimator {

  var duration: Long = -1L
  var interpolator: TimeInterpolator? = null

  private var currentAnimatorSet: AnimatorSet = AnimatorSet()
  private var plays = arrayListOf<Animator>()

  var onStart: Listener? = null
  var onEnd: Listener? = null

  private fun createTogether() = currentAnimatorSet.apply {
    if (duration >= 0) {
      duration = this@ManyAnimator.duration
    }
    if (this@ManyAnimator.interpolator != null) {
      interpolator = this@ManyAnimator.interpolator
    }
    playTogether(plays)
  }

  private fun start() {
    currentAnimatorSet.cancel()
    currentAnimatorSet.removeAllListeners()
    currentAnimatorSet.addListener(object : AnimatorListenerAdapter() {
      override fun onAnimationStart(animation: Animator?) {
        onStart?.invoke()
      }

      override fun onAnimationEnd(animation: Animator?) {
        onEnd?.invoke()
      }
    })

    currentAnimatorSet.playSequentially(plays)
    currentAnimatorSet.start()
  }

  private fun cancel() {
    currentAnimatorSet.cancel()
  }

  @TargetApi(Build.VERSION_CODES.KITKAT)
  private fun pause() {
    currentAnimatorSet.pause()
  }

  @TargetApi(Build.VERSION_CODES.KITKAT)
  private fun resume() {
    currentAnimatorSet.resume()
  }

  fun delay(time: Long) {
    val animator = ValueAnimator.ofFloat(0f, 1f)
    animator.duration = time
    plays.add(animator)
  }

  fun play(anim: AnAnimator.() -> Unit) {
    val animator = AnAnimator().apply(anim).createAnimator()
    if (duration >= 0) {
      animator.duration = duration
    }
    if (interpolator != null) {
      animator.interpolator = interpolator
    }
    plays.add(animator)
  }

  fun together(init: ManyAnimator.() -> Unit) {
    val animator = ManyAnimator().apply(init).createTogether()
    plays.add(animator)
  }

  class Controller(private val animator: ManyAnimator) {
    fun start() = apply { animator.start() }
    fun cancel() = animator.cancel()

    @TargetApi(Build.VERSION_CODES.KITKAT)
    fun pause() = animator.pause()

    @TargetApi(Build.VERSION_CODES.KITKAT)
    fun resume() = animator.resume()
  }
}

/**
 * to let play together
 */
class AnAnimator {

  private val animatorSet = AnimatorSet()
  private val animators = arrayListOf<Animator>()

  var targets: List<View> = arrayListOf()
  var repeatCount = 0
  var duration = 300L
  var onStart: Listener? = null
  var onEnd: Listener? = null
  var interpolator: TimeInterpolator? = null

  fun createAnimator(): Animator = animatorSet.apply {
    addListener(object : AnimatorListenerAdapter() {
      override fun onAnimationStart(animation: Animator?) {
        onStart?.invoke()
      }

      override fun onAnimationEnd(animation: Animator?) {
        onEnd?.invoke()
      }
    })
    duration = this@AnAnimator.duration
    interpolator = this@AnAnimator.interpolator
    repeatCount = this@AnAnimator.repeatCount
    playTogether(animators)
  }

  fun alpha(vararg values: Float) {
    property("alpha", *values)
  }

  fun translationX(vararg values: Float) {
    property("translationX", *values)
  }

  fun translationY(vararg values: Float) {
    property("translationY", *values)
  }

  fun translation(vararg values: Float) {
    translationX(*values)
    translationY(*values)
  }

  fun scaleX(vararg values: Float) {
    property("scaleX", *values)
  }

  fun scaleY(vararg values: Float) {
    property("scaleY", *values)
  }

  fun scale(vararg values: Float) {
    scaleX(*values)
    scaleY(*values)
  }

  fun rotationX(vararg values: Float) {
    property("rotationX", *values)
  }

  fun rotationY(vararg values: Float) {
    property("rotationY", *values)
  }

  fun rotation(vararg values: Float) {
    rotationX(*values)
    rotationY(*values)
  }

  fun pivotX(vararg values: Float) {
    property("pivotX", *values)
  }

  fun pivotY(vararg values: Float) {
    property("pivotY", *values)
  }

  fun pivot(vararg values: Float) {
    pivotX(*values)
    pivotY(*values)
  }

  fun property(propertyName: String, vararg values: Float) {
    targets.forEach {
      val valueAnimator = ObjectAnimator.ofFloat(it, propertyName, *values)
      animators.add(valueAnimator)
    }
  }

  fun pivot(x: Float, y: Float) {
    targets.forEach {
      it.pivotX = x
      it.pivotY = y
    }
  }

  fun height(vararg values: Float) {
    floatValues(*values) { view, value ->
      view.layoutParams.height = value.toInt()
      view.requestLayout()
    }
  }

  fun width(vararg values: Float) {
    floatValues(*values) { view, value ->
      view.layoutParams.width = value.toInt()
      view.requestLayout()
    }
  }

  fun floatValues(vararg values: Float, evaluator: TypeEvaluator<*>? = null, onUpdate: (target: View, value: Float) -> Unit) {
    targets.forEach { target ->
      val valueAnimator = ValueAnimator.ofFloat(*values)
      valueAnimator.addUpdateListener { anim ->
        onUpdate.invoke(target, anim.animatedValue as Float)
      }
      if (evaluator != null) valueAnimator.setEvaluator(evaluator)
      animators.add(valueAnimator)
    }
  }

  fun intValues(vararg values: Int, evaluator: TypeEvaluator<*>? = null, onUpdate: (target: View, value: Int) -> Unit) {
    targets.forEach { target ->
      val valueAnimator = ValueAnimator.ofInt(*values)
      valueAnimator.addUpdateListener { anim ->
        onUpdate.invoke(target, anim.animatedValue as Int)
      }
      if (evaluator != null) valueAnimator.setEvaluator(evaluator)
      animators.add(valueAnimator)
    }
  }

  fun colors(vararg colors: Int, onUpdate: (target: View, value: Int) -> Unit) {
    intValues(*colors, evaluator = ArgbEvaluator(), onUpdate = onUpdate)
  }

  fun path(path: Path) {
    val pathMeasure = PathMeasure(path, false)

    return floatValues(0f, pathMeasure.length) { target: View, value: Float ->
      val currentPosition = FloatArray(2)
      pathMeasure.getPosTan(value, currentPosition, null)
      val x = currentPosition[0]
      val y = currentPosition[1]
      target.x = x
      target.y = y
    }
  }
}

