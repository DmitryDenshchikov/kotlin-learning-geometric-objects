package denshchikov.dmitry.model

import denshchikov.dmitry.model.dimension.Dimension
import denshchikov.dmitry.model.dimension.TwoDimensional
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable
import java.math.BigDecimal

internal class PointTest {

    @Test
    fun `The distance between two points in two dimensional should be calculated properly`() {
        val point1: Point<Dimension> = Point(TwoDimensional(), listOf(BigDecimal(1), BigDecimal(2)))
        val point2: Point<Dimension> = Point(TwoDimensional(), listOf(BigDecimal(3), BigDecimal(4)))
        val point3: Point<Dimension> = Point(TwoDimensional(), listOf(BigDecimal(-5.7), BigDecimal(-3.2)))

        assertAll(
            Executable { assertEquals(BigDecimal("2.8284"), point1.getDistance(point2)) },
            Executable { assertEquals(BigDecimal("2.8284"), point2.getDistance(point1)) },
            Executable { assertEquals(BigDecimal("8.4812"), point1.getDistance(point3)) },
            Executable { assertEquals(BigDecimal("8.4812"), point3.getDistance(point1)) },
            Executable { assertEquals(BigDecimal("11.293"), point2.getDistance(point3)) },
            Executable { assertEquals(BigDecimal("11.293"), point3.getDistance(point2)) }
        )
    }

}