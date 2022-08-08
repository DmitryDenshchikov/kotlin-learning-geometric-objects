package denshchikov.dmitry.model.figure

import denshchikov.dmitry.model.Point
import denshchikov.dmitry.model.dimension.Dimension

/**
 * An abstract representation of a figure.
 * The field [points] represents coordinates of a figure's corners.
 *
 * @author Dmitry Denshchikov
 */
interface Figure<T : Dimension> : Surface {

    val points: List<Point<T>>

}