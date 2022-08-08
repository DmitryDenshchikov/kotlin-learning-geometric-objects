package denshchikov.dmitry.model

import denshchikov.dmitry.model.dimension.Dimension
import java.lang.IllegalArgumentException
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

/**
 * An abstract representation of a point.
 * The field [coordinates] represents point's coordinates.
 *
 * @author Dmitry Denshchikov
 */
class Point<T : Dimension>(dimension: T, coordinates: List<BigDecimal>) {

    val coordinates: List<BigDecimal>

    init {
        if (coordinates.size != dimension.numOfPlanes) {
            throw IllegalArgumentException(
                "point coordinates size (${coordinates.size}) " +
                        "doesn't math dimension type (${dimension.numOfPlanes})"
            )
        }
        this.coordinates = coordinates.toList();
    }

    /**
     * Calculates distance between current and given points.
     *
     * @param destination another point
     * @return distance between current and given points
     */
    fun getDistance(destination : Point<T>) : BigDecimal {
        var result = BigDecimal.ZERO

        for (i in coordinates.indices) {
            val difference = destination.coordinates[i].subtract(coordinates[i])
            result = result.add(difference.multiply(difference))
        }

        return result.sqrt(MathContext(5, RoundingMode.HALF_UP))
    }

    override fun toString(): String = coordinates.joinToString()

}