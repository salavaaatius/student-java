package edu.course.lab03;

public class MinMaxNormalization implements NormalizationStrategy {

    @Override
    public double[] normalize(double[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(
                    "Values cannot be null or empty");
        }

        double min = values[0];
        double max = values[0];

        for (double value : values) {
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException(
                        "Values must be finite");
            }

            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        double[] result = new double[values.length];

        if (max == min) {
            return result;
        }

        for (int i = 0; i < values.length; i++) {
            result[i] = (values[i] - min) / (max - min);
        }

        return result;
    }
}
