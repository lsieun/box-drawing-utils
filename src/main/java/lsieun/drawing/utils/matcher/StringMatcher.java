package lsieun.drawing.utils.matcher;

public class StringMatcher extends CustomMatcher.Junction.ForNonNullValues<String> {
    private final String value;

    private final Mode mode;

    public StringMatcher(String value, Mode mode) {
        this.value = value;
        this.mode = mode;
    }

    @Override
    protected boolean doMatch(String target) {
        return mode.matches(value, target);
    }

    public enum Mode {

        /**
         * Checks if two strings equal and respects casing differences.
         */
        EQUALS_FULLY("equals") {
            @Override
            protected boolean matches(String expected, String actual) {
                return actual.equals(expected);
            }
        },

        /**
         * Checks if two strings equal without respecting casing differences.
         */
        EQUALS_FULLY_IGNORE_CASE("equalsIgnoreCase") {
            @Override
            protected boolean matches(String expected, String actual) {
                return actual.equalsIgnoreCase(expected);
            }
        },

        /**
         * Checks if a string starts with a second string with respecting casing differences.
         */
        STARTS_WITH("startsWith") {
            @Override
            protected boolean matches(String expected, String actual) {
                return actual.startsWith(expected);
            }
        },

        /**
         * Checks if a string starts with a second string without respecting casing differences.
         */
        STARTS_WITH_IGNORE_CASE("startsWithIgnoreCase") {
            @Override
            protected boolean matches(String expected, String actual) {
                return actual.toLowerCase().startsWith(expected.toLowerCase());
            }
        },

        /**
         * Checks if a string ends with a second string with respecting casing differences.
         */
        ENDS_WITH("endsWith") {
            @Override
            protected boolean matches(String expected, String actual) {
                return actual.endsWith(expected);
            }
        },

        /**
         * Checks if a string ends with a second string without respecting casing differences.
         */
        ENDS_WITH_IGNORE_CASE("endsWithIgnoreCase") {
            @Override
            protected boolean matches(String expected, String actual) {
                return actual.toLowerCase().endsWith(expected.toLowerCase());
            }
        },

        /**
         * Checks if a string contains another string with respecting casing differences.
         */
        CONTAINS("contains") {
            @Override
            protected boolean matches(String expected, String actual) {
                return actual.contains(expected);
            }
        },

        /**
         * Checks if a string contains another string without respecting casing differences.
         */
        CONTAINS_IGNORE_CASE("containsIgnoreCase") {
            @Override
            protected boolean matches(String expected, String actual) {
                return actual.toLowerCase().contains(expected.toLowerCase());
            }
        },

        /**
         * Checks if a string can be matched by a regular expression.
         */
        MATCHES("matches") {
            @Override
            protected boolean matches(String expected, String actual) {
                return actual.matches(expected);
            }
        };

        /**
         * A description of the string for providing meaningful {@link Object#toString()} implementations.
         */
        private final String description;

        Mode(String description) {
            this.description = description;
        }

        protected String getDescription() {
            return description;
        }

        /**
         * Matches a string against another string.
         *
         * @param expected The target of the comparison against which the {@code actual} string is compared.
         * @param actual   The source which is subject of the comparison to the {@code expected} value.
         * @return {@code true} if the source matches the target.
         */
        protected abstract boolean matches(String expected, String actual);
    }
}
