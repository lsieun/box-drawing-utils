package lsieun.drawing.utils.matcher;

import java.lang.reflect.Member;

public class NameMatcher<T extends Member> extends CustomMatcher.Junction.ForNonNullValues<T> {
    private final CustomMatcher<String> matcher;

    public NameMatcher(CustomMatcher<String> matcher) {
        this.matcher = matcher;
    }

    @Override
    protected boolean doMatch(T target) {
        return matcher.matches(target.getName());
    }
}
