package denshchikov.dmitry.model.figure

import denshchikov.dmitry.model.dimension.ThreeDimensional

interface Polyhedron : Figure<ThreeDimensional> {

    fun printPoints() {
        println(points.joinToString(prefix = "WOW: ", separator = " | "))
    }

}