package lsieun.drawing.utils.matcher;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

public class ClassMemberMatcherBuddy {
    public static <T> CustomMatcher.Junction<T> not(CustomMatcher<? super T> matcher) {
        return new NegatingMatcher<T>(matcher);
    }

    // region modifier
    public static <T extends Member> CustomMatcher.Junction<T> isAbstract() {
        return ModifierMatcher.of(ModifierMatcher.Mode.ABSTRACT);
    }

    public static <T extends Member> CustomMatcher.Junction<T> isPublic() {
        return ModifierMatcher.of(ModifierMatcher.Mode.PUBLIC);
    }


    public static <T extends Member> CustomMatcher.Junction<T> isProtected() {
        return ModifierMatcher.of(ModifierMatcher.Mode.PROTECTED);
    }

    public static <T extends Member> CustomMatcher.Junction<T> isPackagePrivate() {
        return not(isPublic().or(isProtected()).or(isPrivate()));
    }


    public static <T extends Member> CustomMatcher.Junction<T> isPrivate() {
        return ModifierMatcher.of(ModifierMatcher.Mode.PRIVATE);
    }

    public static <T extends Member> CustomMatcher.Junction<T> isStatic() {
        return ModifierMatcher.of(ModifierMatcher.Mode.STATIC);
    }

    public static <T extends Member> CustomMatcher.Junction<T> isFinal() {
        return ModifierMatcher.of(ModifierMatcher.Mode.FINAL);
    }

    public static <T extends Member> CustomMatcher.Junction<T> isSynchronized() {
        return ModifierMatcher.of(ModifierMatcher.Mode.SYNCHRONIZED);
    }

    public static <T extends Member> CustomMatcher.Junction<T> isNative() {
        return ModifierMatcher.of(ModifierMatcher.Mode.NATIVE);
    }


    public static <T extends Member> CustomMatcher.Junction<T> isStrict() {
        return ModifierMatcher.of(ModifierMatcher.Mode.STRICT);
    }
    // endregion


    // region name
    public static <T extends Member> CustomMatcher.Junction<T> named(String name) {
        return new NameMatcher<>(new StringMatcher(name, StringMatcher.Mode.EQUALS_FULLY));
    }

    public static <T extends Member> CustomMatcher.Junction<T> namedOneOf(String... names) {
        return new NameMatcher<>(new StringSetMatcher(new HashSet<String>(Arrays.asList(names))));
    }

    /**
     * Matches a {@link Member} for its name. The name's
     * capitalization is ignored.
     *
     * @param name The expected name.
     * @param <T>  The type of the matched object.
     * @return An element matcher for a named element's name.
     */
    public static <T extends Member> CustomMatcher.Junction<T> namedIgnoreCase(String name) {
        return new NameMatcher<>(new StringMatcher(name, StringMatcher.Mode.EQUALS_FULLY_IGNORE_CASE));
    }

    /**
     * Matches a {@link Member} for its name's prefix.
     *
     * @param prefix The expected name's prefix.
     * @param <T>    The type of the matched object.
     * @return An element matcher for a named element's name's prefix.
     */
    public static <T extends Member> CustomMatcher.Junction<T> nameStartsWith(String prefix) {
        return new NameMatcher<>(new StringMatcher(prefix, StringMatcher.Mode.STARTS_WITH));
    }

    /**
     * Matches a {@link Member} for its name's prefix. The name's
     * capitalization is ignored.
     *
     * @param prefix The expected name's prefix.
     * @param <T>    The type of the matched object.
     * @return An element matcher for a named element's name's prefix.
     */
    public static <T extends Member> CustomMatcher.Junction<T> nameStartsWithIgnoreCase(String prefix) {
        return new NameMatcher<>(new StringMatcher(prefix, StringMatcher.Mode.STARTS_WITH_IGNORE_CASE));
    }

    /**
     * Matches a {@link Member} for its name's suffix.
     *
     * @param suffix The expected name's suffix.
     * @param <T>    The type of the matched object.
     * @return An element matcher for a named element's name's suffix.
     */
    public static <T extends Member> CustomMatcher.Junction<T> nameEndsWith(String suffix) {
        return new NameMatcher<>(new StringMatcher(suffix, StringMatcher.Mode.ENDS_WITH));
    }

    /**
     * Matches a {@link Member} for its name's suffix. The name's
     * capitalization is ignored.
     *
     * @param suffix The expected name's suffix.
     * @param <T>    The type of the matched object.
     * @return An element matcher for a named element's name's suffix.
     */
    public static <T extends Member> CustomMatcher.Junction<T> nameEndsWithIgnoreCase(String suffix) {
        return new NameMatcher<>(new StringMatcher(suffix, StringMatcher.Mode.ENDS_WITH_IGNORE_CASE));
    }

    public static <T extends Member> CustomMatcher.Junction<T> nameContains(String infix) {
        return new NameMatcher<>(new StringMatcher(infix, StringMatcher.Mode.CONTAINS));
    }

    public static <T extends Member> CustomMatcher.Junction<T> nameContainsIgnoreCase(String infix) {
        return new NameMatcher<>(new StringMatcher(infix, StringMatcher.Mode.CONTAINS_IGNORE_CASE));
    }

    public static <T extends Member> CustomMatcher.Junction<T> nameMatches(String regex) {
        return new NameMatcher<>(new StringMatcher(regex, StringMatcher.Mode.MATCHES));
    }
    // endregion

    // region method param
    public static <T extends Method> CustomMatcher.Junction<T> paramTypeContains(Class<?>... typeArray) {
        return new MethodParameterTypesMatcher<>(TypeSetMatcher.of(typeArray));
    }
    // endregion

    // region method return
    public static <T extends Method> CustomMatcher.Junction<T> returns(Class<?> type) {
        return new MethodReturnTypeMatcher<>(new TypeMatcher(type));
    }
    // endregion
}
