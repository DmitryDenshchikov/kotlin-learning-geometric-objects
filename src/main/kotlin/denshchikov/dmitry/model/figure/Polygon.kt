package denshchikov.dmitry.model.figure

import denshchikov.dmitry.model.dimension.TwoDimensional

/**
 * A representation of a polygon.
 *
 * @author Dmitry Denshchikov
 */
interface Polygon : Figure<TwoDimensional> {

    fun printPoints() {
        println(points.joinToString(prefix = "${javaClass.kotlin.qualifiedName.toString()}: " , separator = " | "))
    }

}