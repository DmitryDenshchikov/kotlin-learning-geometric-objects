package denshchikov.dmitry.model.figure

import denshchikov.dmitry.model.Point
import denshchikov.dmitry.model.dimension.TwoDimensional

/**
 * A representation of a triangle.
 *
 * @author Dmitry Denshchikov
 */
class Triangle(points: List<Point<TwoDimensional>>) : Polygon {

    override val points: List<Point<TwoDimensional>>

    init {
        this.points = points.toList()
    }

}