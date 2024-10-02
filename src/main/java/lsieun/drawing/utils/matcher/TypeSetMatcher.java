package lsieun.drawing.utils.matcher;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TypeSetMatcher extends CustomMatcher.Junction.ForNonNullValues<Type> {
    private final Set<Type> values;

    private TypeSetMatcher(Set<Type> values) {
        this.values = values;
    }

    @Override
    protected boolean doMatch(Type target) {
        return values.contains(target);
    }

    public static TypeSetMatcher of(Type... array) {
        Set<Type> set = new HashSet<>(Arrays.asList(array));
        return new TypeSetMatcher(set);
    }
}
