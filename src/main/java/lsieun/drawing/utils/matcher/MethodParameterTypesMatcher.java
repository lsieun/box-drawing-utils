package lsieun.drawing.utils.matcher;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MethodParameterTypesMatcher<T extends Method> extends CustomMatcher.Junction.ForNonNullValues<T> {
    private final CustomMatcher<? super Type> matcher;

    public MethodParameterTypesMatcher(CustomMatcher<? super Type> matcher) {
        this.matcher = matcher;
    }

    @Override
    protected boolean doMatch(T target) {
        Class<?>[] parameterTypes = target.getParameterTypes();
        for (Class<?> clazz : parameterTypes) {
            if (matcher.matches(clazz)) {
                return true;
            }
        }
        return false;
    }
}
