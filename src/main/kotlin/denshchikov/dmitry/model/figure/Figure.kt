package denshchikov.dmitry.model.figure

import denshchikov.dmitry.model.Point
import denshchikov.dmitry.model.dimension.Dimension

interface Figure<T : Dimension> : Surface {

    val points: List<Point<T>>

}