package denshchikov.dmitry

import denshchikov.dmitry.model.Point
import denshchikov.dmitry.model.dimension.TwoDimensional
import denshchikov.dmitry.model.figure.Triangle
import java.math.BigDecimal

fun main() {
    val dimension = TwoDimensional()

    val point1 = Point(dimension, listOf(BigDecimal(2), BigDecimal(2)))
    val point2 = Point(dimension, listOf(BigDecimal(3), BigDecimal(3)))

    println(point1.getDistance(point2))

    val triangle = Triangle(listOf(point1, point2))
    triangle.printPoints()
}