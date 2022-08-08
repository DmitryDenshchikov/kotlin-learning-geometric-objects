package denshchikov.dmitry.model.figure

import denshchikov.dmitry.model.dimension.ThreeDimensional

/**
 * A representation of a polyhedron.
 *
 * @author Dmitry Denshchikov
 */
interface Polyhedron : Figure<ThreeDimensional> {

    fun printPoints() {
        println(points.joinToString(prefix = "WOW: ", separator = " | "))
    }

}