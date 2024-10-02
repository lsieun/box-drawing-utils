package lsieun.drawing.utils.matcher;

import java.util.Objects;

public interface CustomMatcher<T> {
    boolean matches(T target);

    interface Junction<S> extends CustomMatcher<S> {
        <U extends S> Junction<U> and(CustomMatcher<? super U> other);

        <U extends S> Junction<U> or(CustomMatcher<? super U> other);

        abstract class AbstractBase<V> implements Junction<V> {
            public <U extends V> Junction<U> and(CustomMatcher<? super U> other) {
                return Conjunction.of(this, other);
            }

            public <U extends V> Junction<U> or(CustomMatcher<? super U> other) {
                return Disjunction.of(this, other);
            }
        }

        class Conjunction<W> extends AbstractBase<W> {
            private final CustomMatcher<? super W> first;
            private final CustomMatcher<? super W> second;

            private Conjunction(CustomMatcher<? super W> first, CustomMatcher<? super W> second) {
                Objects.requireNonNull(first);
                Objects.requireNonNull(second);

                this.first = first;
                this.second = second;
            }

            public boolean matches(W target) {
                return first.matches(target) && second.matches(target);
            }

            public static <V> Conjunction<V> of(
                    CustomMatcher<? super V> first,
                    CustomMatcher<? super V> second
            ) {
                return new Conjunction<>(first, second);
            }
        }

        class Disjunction<W> extends AbstractBase<W> {
            private final CustomMatcher<? super W> first;
            private final CustomMatcher<? super W> second;

            private Disjunction(CustomMatcher<? super W> first, CustomMatcher<? super W> second) {
                Objects.requireNonNull(first);
                Objects.requireNonNull(second);

                this.first = first;
                this.second = second;
            }

            public boolean matches(W target) {
                return first.matches(target) || second.matches(target);
            }

            public static <V> Disjunction<V> of(
                    CustomMatcher<? super V> first,
                    CustomMatcher<? super V> second
            ) {
                return new Disjunction<>(first, second);
            }
        }

        abstract class ForNonNullValues<W> extends AbstractBase<W> {
            public boolean matches(W target) {
                return target != null && doMatch(target);
            }

            protected abstract boolean doMatch(W target);
        }

    }

}
