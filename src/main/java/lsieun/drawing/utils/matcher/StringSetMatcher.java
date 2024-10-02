package lsieun.drawing.utils.matcher;

import java.util.Set;

public class StringSetMatcher extends CustomMatcher.Junction.ForNonNullValues<String> {
    private final Set<String> values;

    public StringSetMatcher(Set<String> values) {
        this.values = values;
    }

    @Override
    protected boolean doMatch(String target) {
        return values.contains(target);
    }
}
