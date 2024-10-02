package lsieun.drawing.utils.matcher;

public class NegatingMatcher<T> extends CustomMatcher.Junction.AbstractBase<T> {
    private final CustomMatcher<? super T> matcher;

    public NegatingMatcher(CustomMatcher<? super T> matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(T target) {
        return !matcher.matches(target);
    }
}
