
package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxNormalizationTest {

    private final MinMaxNormalization normalization =
            new MinMaxNormalization();

    @Test
    void normalizesValuesBetweenZeroAndOne() {
        double[] result = normalization.normalize(
                new double[]{2, 4, 6});

        assertArrayEquals(
                new double[]{0, 0.5, 1},
                result,
                0.0001);
    }

    @Test
    void returnsZerosForEqualValues() {
        double[] result = normalization.normalize(
                new double[]{5, 5, 5});

        assertArrayEquals(
                new double[]{0, 0, 0},
                result);
    }

    @Test
    void doesNotModifyOriginalArray() {
        double[] values = {2, 4, 6};

        normalization.normalize(values);

        assertArrayEquals(
                new double[]{2, 4, 6},
                values);
    }

    @Test
    void rejectsNullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> normalization.normalize(null));
    }

    @Test
    void rejectsEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> normalization.normalize(new double[]{}));
    }
}
