package lsieun.drawing.utils;

import java.util.Collection;
import java.util.Map;

public class CheckUtils {
    private static final float FLOAT_ZERO = 0.0F;
    private static final double DOUBLE_ZERO = 0.0D;
    private static final long LONG_ZERO = 0L;
    private static final int INT_ZERO = 0;

    private CheckUtils() {
        throw new UnsupportedOperationException();
    }


    // region null

    /**
     * Checks that the given argument is not null.
     * If it is, throws {@link NullPointerException}.
     * Otherwise, returns the argument.
     */
    public static <T> T notNull(T arg, String text) {
        if (arg == null) {
            throw new NullPointerException(text);
        }
        return arg;
    }

    /**
     * Check that the given varargs is not null and does not contain elements null elements.
     * <p>
     * If it is, throws {@link NullPointerException}.
     * Otherwise, returns the argument.
     */
    @SafeVarargs
    public static <T> T[] deepNotNull(String text, T... varargs) {
        if (varargs == null) {
            throw new NullPointerException(text);
        }

        for (T element : varargs) {
            if (element == null) {
                throw new NullPointerException(text);
            }
        }
        return varargs;
    }

    /**
     * Checks that the given argument is not null.
     * If it is, throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static <T> T notNullWithIAE(final T arg, final String paramName) throws IllegalArgumentException {
        if (arg == null) {
            throw new IllegalArgumentException("Param '" + paramName + "' must not be null");
        }
        return arg;
    }

    /**
     * Checks that the given argument is not null.
     * If it is, throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     *
     * @param <T>   type of the given argument value.
     * @param name  of the parameter, belongs to the exception message.
     * @param index of the array, belongs to the exception message.
     * @param value to check.
     * @return the given argument value.
     * @throws IllegalArgumentException if value is null.
     */
    public static <T> T notNullArrayParam(T value, int index, String name) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Array index " + index + " of parameter '" + name + "' must not be null");
        }
        return value;
    }
    // endregion


    // region Positive

    /**
     * Checks that the given argument is strictly positive.
     * If it is not, throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static int positive(int i, String name) {
        if (i <= INT_ZERO) {
            throw new IllegalArgumentException(name + " : " + i + " (expected: > 0)");
        }
        return i;
    }

    /**
     * Checks that the given argument is strictly positive.
     * If it is not, throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static long positive(long l, String name) {
        if (l <= LONG_ZERO) {
            throw new IllegalArgumentException(name + " : " + l + " (expected: > 0)");
        }
        return l;
    }

    /**
     * Checks that the given argument is strictly positive.
     * If it is not, throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static double positive(final double d, final String name) {
        if (d <= DOUBLE_ZERO) {
            throw new IllegalArgumentException(name + " : " + d + " (expected: > 0)");
        }
        return d;
    }

    /**
     * Checks that the given argument is strictly positive.
     * If it is not, throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static float positive(final float f, final String name) {
        if (f <= FLOAT_ZERO) {
            throw new IllegalArgumentException(name + " : " + f + " (expected: > 0)");
        }
        return f;
    }

    /**
     * Checks that the given argument is positive or zero.
     * If it is not , throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static int positiveOrZero(int i, String name) {
        if (i < INT_ZERO) {
            throw new IllegalArgumentException(name + " : " + i + " (expected: >= 0)");
        }
        return i;
    }

    /**
     * Checks that the given argument is positive or zero.
     * If it is not, throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static long positiveOrZero(long l, String name) {
        if (l < LONG_ZERO) {
            throw new IllegalArgumentException(name + " : " + l + " (expected: >= 0)");
        }
        return l;
    }

    /**
     * Checks that the given argument is positive or zero.
     * If it is not, throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static double positiveOrZero(final double d, final String name) {
        if (d < DOUBLE_ZERO) {
            throw new IllegalArgumentException(name + " : " + d + " (expected: >= 0)");
        }
        return d;
    }

    /**
     * Checks that the given argument is positive or zero.
     * If it is not, throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static float positiveOrZero(final float f, final String name) {
        if (f < FLOAT_ZERO) {
            throw new IllegalArgumentException(name + " : " + f + " (expected: >= 0)");
        }
        return f;
    }
    // endregion


    // region Range

    /**
     * Checks that the given argument is in range.
     * If it is not, throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static int inRange(int i, int start, int end, String name) {
        if (i < start || i > end) {
            throw new IllegalArgumentException(name + ": " + i + " (expected: " + start + "-" + end + ")");
        }
        return i;
    }

    /**
     * Checks that the given argument is in range.
     * If it is not, throws {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static long inRange(long l, long start, long end, String name) {
        if (l < start || l > end) {
            throw new IllegalArgumentException(name + ": " + l + " (expected: " + start + "-" + end + ")");
        }
        return l;
    }
    // endregion


    // region Odd + Even
    public static int odd(int i, String name) {
        if ((i & 1 ) == INT_ZERO) {
            throw new IllegalArgumentException(name + " : " + i + " (expected: odd)");
        }
        return i;
    }

    public static int even(int i, String name) {
        if ((i & 1 ) != INT_ZERO) {
            throw new IllegalArgumentException(name + " : " + i + " (expected: even)");
        }
        return i;
    }
    // endregion


    // region NonEmpty

    /**
     * Checks that the given argument is neither null nor empty.
     * If it is, throws {@link NullPointerException} or {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static <T> T[] nonEmpty(T[] array, String name) {
        //No String concatenation for check
        if (notNull(array, name).length == 0) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return array;
    }

    /**
     * Checks that the given argument is neither null nor empty.
     * If it is, throws {@link NullPointerException} or {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static byte[] nonEmpty(byte[] array, String name) {
        //No String concatenation for check
        if (notNull(array, name).length == 0) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return array;
    }

    /**
     * Checks that the given argument is neither null nor empty.
     * If it is, throws {@link NullPointerException} or {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static char[] nonEmpty(char[] array, String name) {
        //No String concatenation for check
        if (notNull(array, name).length == 0) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return array;
    }

    /**
     * Checks that the given argument is neither null nor empty.
     * If it is, throws {@link NullPointerException} or {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static <T extends Collection<?>> T nonEmpty(T collection, String name) {
        //No String concatenation for check
        if (notNull(collection, name).isEmpty()) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return collection;
    }

    /**
     * Checks that the given argument is neither null nor empty.
     * If it is, throws {@link NullPointerException} or {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static String nonEmpty(final String value, final String name) {
        if (notNull(value, name).isEmpty()) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return value;
    }

    /**
     * Checks that the given argument is neither null nor empty.
     * If it is, throws {@link NullPointerException} or {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static <K, V, T extends Map<K, V>> T nonEmpty(T value, String name) {
        if (notNull(value, name).isEmpty()) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return value;
    }

    /**
     * Checks that the given argument is neither null nor empty.
     * If it is, throws {@link NullPointerException} or {@link IllegalArgumentException}.
     * Otherwise, returns the argument.
     */
    public static CharSequence nonEmpty(final CharSequence value, final String name) {
        if (notNull(value, name).length() == 0) {
            throw new IllegalArgumentException("Param '" + name + "' must not be empty");
        }
        return value;
    }

    /**
     * Trims the given argument and checks whether it is neither null nor empty.
     * If it is, throws {@link NullPointerException} or {@link IllegalArgumentException}.
     * Otherwise, returns the trimmed argument.
     *
     * @param value to trim and check.
     * @param name  of the parameter.
     * @return the trimmed (not the original) value.
     * @throws NullPointerException     if value is null.
     * @throws IllegalArgumentException if the trimmed value is empty.
     */
    public static String nonEmptyAfterTrim(final String value, final String name) {
        String trimmed = notNull(value, name).trim();
        return nonEmpty(trimmed, name);
    }
    // endregion


    /**
     * Resolves a possibly null Integer to a primitive int, using a default value.
     *
     * @param wrapper      the wrapper
     * @param defaultValue the default value
     * @return the primitive value
     */
    public static int intValue(Integer wrapper, int defaultValue) {
        return wrapper != null ? wrapper : defaultValue;
    }

    /**
     * Resolves a possibly null Long to a primitive long, using a default value.
     *
     * @param wrapper      the wrapper
     * @param defaultValue the default value
     * @return the primitive value
     */
    public static long longValue(Long wrapper, long defaultValue) {
        return wrapper != null ? wrapper : defaultValue;
    }
}
