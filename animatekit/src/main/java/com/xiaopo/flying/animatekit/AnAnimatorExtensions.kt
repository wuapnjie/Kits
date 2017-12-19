package com.xiaopo.flying.animatekit

import android.view.animation.CycleInterpolator

/**
 * Inspired by ViewAnimator
 * @link https://github.com/florent37/ViewAnimator
 *
 * @author wupanjie
 */
fun AnAnimator.bounce() {
  translationY(0f, 0f, -30f, 0f, -15f, 0f, 0f)
}

fun AnAnimator.bounceIn() {
  alpha(0f, 1f, 1f, 1f)
  scaleX(0.3f, 1.05f, 0.9f, 1f)
  scaleY(0.3f, 1.05f, 0.9f, 1f)
}

fun AnAnimator.bounceOut() {
  scaleY(1f, 0.9f, 1.05f, 0.3f)
  scaleX(1f, 0.9f, 1.05f, 0.3f)
  alpha(1f, 1f, 1f, 0f)
}

fun AnAnimator.fadeIn() {
  return alpha(0f, 0.25f, 0.5f, 0.75f, 1f)
}

fun AnAnimator.fadeOut() {
  return alpha(1f, 0.75f, 0.5f, 0.25f, 0f)
}

fun AnAnimator.flash() {
  return alpha(1f, 0f, 1f, 0f, 1f)
}

fun AnAnimator.flipHorizontal() {
  return rotationX(90f, -15f, 15f, 0f)
}

fun AnAnimator.flipVertical() {
  return rotationY(90f, -15f, 15f, 0f)
}

fun AnAnimator.pulse() {
  scaleY(1f, 1.1f, 1f)
  scaleX(1f, 1.1f, 1f)

}

fun AnAnimator.rollIn() {
  for (view in targets) {
    alpha(0f, 1f)
    translationX(-(view.width - view.paddingLeft - view.paddingRight).toFloat(), 0f)
    rotation(-120f, 0f)
  }

}

fun AnAnimator.rollOut() {
  for (view in targets) {
    alpha(1f, 0f)
    translationX(0f, view.width.toFloat())
    rotation(0f, 120f)
  }

}

fun AnAnimator.rubber() {
  scaleX(1f, 1.25f, 0.75f, 1.15f, 1f)
  scaleY(1f, 0.75f, 1.25f, 0.85f, 1f)

}

fun AnAnimator.shake() {
  translationX(0f, 25f, -25f, 25f, -25f, 15f, -15f, 6f, -6f, 0f)
  interpolator = CycleInterpolator(5f)
}

fun AnAnimator.standUp() {
  for (view in targets) {
    val x = ((view.width - view.paddingLeft - view.paddingRight) / 2 + view.paddingLeft).toFloat()
    val y = (view.height - view.paddingBottom).toFloat()
    pivotX(x, x, x, x, x)
    pivotY(y, y, y, y, y)
    rotationX(55f, -30f, 15f, -15f, 0f)
  }

}

fun AnAnimator.swing() {
  return rotation(0f, 10f, -10f, 6f, -6f, 3f, -3f, 0f)
}

fun AnAnimator.tada() {
  scaleX(1f, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1f)
  scaleY(1f, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1f)
  rotation(0f, -3f, -3f, 3f, -3f, 3f, -3f, 3f, -3f, 0f)

}

fun AnAnimator.wave() {
  for (view in targets) {
    val x = ((view.getWidth() - view.getPaddingLeft() - view.getPaddingRight()) / 2 + view.getPaddingLeft()).toFloat()
    val y = (view.getHeight() - view.getPaddingBottom()).toFloat()
    rotation(12f, -12f, 3f, -3f, 0f)
    pivotX(x, x, x, x, x)
    pivotY(y, y, y, y, y)
  }

}

fun AnAnimator.wobble() {
  for (view in targets) {
    val width = view.width.toFloat()
    val one = (width / 100.0).toFloat()
    translationX(0 * one, -25 * one, 20 * one, -15 * one, 10 * one, -5 * one, 0 * one, 0f)
    rotation(0f, -5f, 3f, -3f, 2f, -1f, 0f)
  }

}

fun AnAnimator.zoomIn() {
  scaleX(0.45f, 1f)
  scaleY(0.45f, 1f)
  alpha(0f, 1f)

}

fun AnAnimator.zoomOut() {
  scaleX(1f, 0.3f, 0f)
  scaleY(1f, 0.3f, 0f)
  alpha(1f, 0f, 0f)

}

fun AnAnimator.fall() {
  rotation(1080f, 720f, 360f, 0f)

}

fun AnAnimator.newsPaper() {
  rotation(1080f, 720f, 360f, 0f)
  alpha(0f, 1f)
  scaleX(0.1f, 0.5f, 1f)
  scaleY(0.1f, 0.5f, 1f)

}

fun AnAnimator.slit() {
  rotationY(90f, 88f, 88f, 45f, 0f)
  alpha(0f, 0.4f, 0.8f, 1f)
  scaleX(0f, 0.5f, 0.9f, 0.9f, 1f)
  scaleY(0f, 0.5f, 0.9f, 0.9f, 1f)

}

fun AnAnimator.slideLeft() {
  translationX(-300f, 0f)
  alpha(0f, 1f)

}

fun AnAnimator.slideRight() {
  translationX(300f, 0f)
  alpha(0f, 1f)

}

fun AnAnimator.slideTop() {
  translationY(-300f, 0f)
  alpha(0f, 1f)

}

fun AnAnimator.slideBottom() {
  translationY(300f, 0f)
  alpha(0f, 1f)

}



