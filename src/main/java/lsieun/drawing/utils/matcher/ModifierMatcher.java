package lsieun.drawing.utils.matcher;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public class ModifierMatcher<T extends Member> extends CustomMatcher.Junction.ForNonNullValues<T> {
    public static <T extends Member> CustomMatcher.Junction<T> of(Mode mode) {
        return (CustomMatcher.Junction<T>) mode.getMatcher();
    }

    /**
     * The matching mode to apply by this modifier matcher.
     */
    private final Mode mode;

    /**
     * Creates a new element matcher that matches an element by its modifier.
     *
     * @param mode The match mode to apply to the matched element's modifier.
     */
    public ModifierMatcher(Mode mode) {
        this.mode = mode;
    }

    @Override
    protected boolean doMatch(T target) {
        return (mode.getModifiers() & target.getModifiers()) != 0;
    }

    public enum Mode {

        /**
         * Matches an element that is considered {@code public}.
         */
        PUBLIC(Modifier.PUBLIC, "isPublic()"),

        /**
         * Matches an element that is considered {@code protected}.
         */
        PROTECTED(Modifier.PROTECTED, "isProtected()"),

        /**
         * Matches an element that is considered {@code private}.
         */
        PRIVATE(Modifier.PRIVATE, "isPrivate()"),

        /**
         * Matches an element that is considered {@code final}.
         */
        FINAL(Modifier.FINAL, "isFinal()"),

        /**
         * Matches an element that is considered {@code static}.
         */
        STATIC(Modifier.STATIC, "isStatic()"),

        /**
         * Matches an element that is considered {@code synchronized}.
         */
        SYNCHRONIZED(Modifier.SYNCHRONIZED, "isSynchronized()"),

        /**
         * Matches an element that is considered {@code native}.
         */
        NATIVE(Modifier.NATIVE, "isNative()"),

        /**
         * Matches an element that is considered {@code strict}.
         */
        STRICT(Modifier.STRICT, "isStrict()"),


        /**
         * Matches an element that is considered {@code abstract}.
         */
        ABSTRACT(Modifier.ABSTRACT, "isAbstract()"),

        /**
         * Matches a type that is considered an interface.
         */
        INTERFACE(Modifier.INTERFACE, "isInterface()"),


        /**
         * Matches a volatile field.
         */
        VOLATILE(Modifier.VOLATILE, "isVolatile()"),

        /**
         * Matches a transient field.
         */
        TRANSIENT(Modifier.TRANSIENT, "isTransient()");

        /**
         * The mask of the modifier to match.
         */
        private final int modifiers;

        /**
         * The textual representation of this instance's matching mode.
         */
        private final String description;

        /**
         * The canonical matcher instance.
         */
        private final ModifierMatcher<?> matcher;

        /**
         * Creates a new modifier matcher mode.
         *
         * @param modifiers   The mask of the modifier to match.
         * @param description The textual representation of this instance's matching mode.
         */
        <T> Mode(int modifiers, String description) {
            this.modifiers = modifiers;
            this.description = description;
            matcher = new ModifierMatcher<>(this);
        }

        /**
         * Returns the textual description of this mode.
         *
         * @return The textual description of this mode.
         */
        private String getDescription() {
            return description;
        }

        /**
         * Returns the modifiers to match by this mode.
         *
         * @return The modifiers to match by this mode.
         */
        private int getModifiers() {
            return modifiers;
        }

        /**
         * Returns a reusable matcher for this modifier sort.
         *
         * @return A reusable matcher for this modifier sort.
         */
        private ModifierMatcher<?> getMatcher() {
            return matcher;
        }
    }
}
