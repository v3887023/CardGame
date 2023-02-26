package com.zcx.cardgame.utils

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.IntDef

class ShapeBuilder {
    private var gradientDrawable: GradientDrawable

    constructor() {
        gradientDrawable = GradientDrawable()
    }

    constructor(@Shape shape: Int) {
        gradientDrawable = GradientDrawable()
        gradientDrawable.shape = shape
    }

    fun solid(@ColorInt argb: Int) = apply { gradientDrawable.setColor(argb) }

    fun corners(radius: Float) = apply { gradientDrawable.cornerRadius = radius }

    fun corners(radii: FloatArray) = apply { gradientDrawable.cornerRadii = radii }

    fun corners(
        topLeftRadius: Float,
        topRightRadius: Float,
        bottomRightRadius: Float,
        bottomLeftRadius: Float
    ): ShapeBuilder {
        return corners(
            floatArrayOf(
                topLeftRadius,
                topRightRadius,
                bottomRightRadius,
                bottomLeftRadius
            )
        )
    }

    fun size(width: Int, height: Int) = apply { gradientDrawable.setSize(width, height) }

    fun stroke(width: Int, color: Int) = apply { gradientDrawable.setStroke(width, color) }

    fun gradientType(@GradientType gradient: Int) =
        apply { gradientDrawable.gradientType = gradient }

    fun gradientRadius(radius: Float) = apply { gradientDrawable.cornerRadius = radius }

    fun gradientCenter(x: Float, y: Float) = apply { gradientDrawable.setGradientCenter(x, y) }

    fun alpha(alpha: Int) = apply { gradientDrawable.alpha = alpha }

    fun bounds(padding: Int): ShapeBuilder {
        return bounds(padding, padding, padding, padding)
    }

    fun bounds(left: Int, top: Int, right: Int, bottom: Int) =
        apply { gradientDrawable.setBounds(left, top, right, bottom) }

    fun bounds(rect: Rect) = apply { gradientDrawable.bounds = rect }

    fun build(): Drawable {
        return gradientDrawable
    }

    @IntDef(
        GradientDrawable.LINE,
        GradientDrawable.OVAL,
        GradientDrawable.RECTANGLE,
        GradientDrawable.RING
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class Shape

    @IntDef(
        GradientDrawable.LINEAR_GRADIENT,
        GradientDrawable.RADIAL_GRADIENT,
        GradientDrawable.SWEEP_GRADIENT
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class GradientType
}