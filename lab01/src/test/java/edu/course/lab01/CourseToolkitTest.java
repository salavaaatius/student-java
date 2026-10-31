package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }
     @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }
    @Test
    void returnsTrueForPrimeNumber() {
        assertTrue(CourseToolkit.isPrime(17));
}

    @Test
    void returnsFalseForCompositeNumber() {
        assertFalse(CourseToolkit.isPrime(49));
}

    @Test
    void returnsFalseForOne() {
        assertFalse(CourseToolkit.isPrime(1));
}

    @Test
    void returnsFalseForNegativeNumber() {
        assertFalse(CourseToolkit.isPrime(-5));
}

    @Test
    void returnsTrueForTwo() {
        assertTrue(CourseToolkit.isPrime(2));
}
    @Test
    void returnsTrueForPalindrome() {
    assertTrue(CourseToolkit.isPalindrome("level"));
}

    @Test
    void returnsFalseForNonPalindrome() {
        assertFalse(CourseToolkit.isPalindrome("java"));
}

    @Test
    void returnsTrueForSingleCharacter() {
        assertTrue(CourseToolkit.isPalindrome("a"));
}

    @Test
    void returnsTrueForEmptyString() {
        assertTrue(CourseToolkit.isPalindrome(""));
}

    @Test
    void throwsExceptionForNullText() {
        assertThrows(IllegalArgumentException.class,
            () -> CourseToolkit.isPalindrome(null));
}
    @Test
    void calculatesAverage() {
        assertEquals(20.0, CourseToolkit.average(new int[]{10, 20, 30}), 0.0001);
}

    @Test
    void calculatesAverageWithNegativeNumbers() {
        assertEquals(0.0, CourseToolkit.average(new int[]{-10, 10}), 0.0001);
}

    @Test
    void calculatesFractionalAverage() {
        assertEquals(2.5, CourseToolkit.average(new int[]{2, 3}), 0.0001);
}

    @Test
    void throwsExceptionForEmptyArray() {
        assertThrows(IllegalArgumentException.class,
            () -> CourseToolkit.average(new int[]{}));
}

    @Test
    void throwsExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class,
            () -> CourseToolkit.average(null));
}
    @Test
    void findsMinimum() {
        assertEquals(-2, CourseToolkit.min(new int[]{8, 3, 15, -2, 10}));
}

    @Test
    void findsMaximum() {
        assertEquals(15, CourseToolkit.max(new int[]{8, 3, 15, -2, 10}));
}

    @Test
    void findsMinimumWithNegativeNumbers() {
        assertEquals(-10, CourseToolkit.min(new int[]{-3, -10, -5}));
}

    @Test
    void findsMaximumWithNegativeNumbers() {
        assertEquals(-3, CourseToolkit.max(new int[]{-3, -10, -5}));
}

    @Test
    void findsMinimumInSingleElementArray() {
        assertEquals(7, CourseToolkit.min(new int[]{7}));
}

    @Test
    void findsMaximumInSingleElementArray() {
        assertEquals(7, CourseToolkit.max(new int[]{7}));
}

    @Test
    void throwsExceptionForEmptyArrayInMin() {
        assertThrows(IllegalArgumentException.class,
            () -> CourseToolkit.min(new int[]{}));
}

    @Test
    void throwsExceptionForEmptyArrayInMax() {
        assertThrows(IllegalArgumentException.class,
            () -> CourseToolkit.max(new int[]{}));
}

    @Test
    void throwsExceptionForNullArrayInMin() {
        assertThrows(IllegalArgumentException.class,
            () -> CourseToolkit.min(null));
}

    @Test
    void throwsExceptionForNullArrayInMax() {
        assertThrows(IllegalArgumentException.class,
            () -> CourseToolkit.max(null));
}
    @Test
    void returnsFalseForDifferentLetterCases() {
        assertFalse(CourseToolkit.isPalindrome("Level"));
}
    @Test
    void returnsFalseForPalindromeWithDifferentSpaces() {
        assertFalse(CourseToolkit.isPalindrome("a b"));
}
    @Test
    void doesNotModifyInputArray() {
        int[] values = {10, 20, 30};

        CourseToolkit.average(values);

        assertArrayEquals(new int[]{10, 20, 30}, values);
}
}
