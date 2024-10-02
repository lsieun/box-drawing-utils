package lsieun.drawing.utils.matcher;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MethodReturnTypeMatcher<T extends Method> extends CustomMatcher.Junction.ForNonNullValues<T> {
    private final CustomMatcher<? super Type> matcher;

    public MethodReturnTypeMatcher(CustomMatcher<? super Type> matcher) {
        this.matcher = matcher;
    }

    @Override
    protected boolean doMatch(T target) {
        Class<?> returnType = target.getReturnType();
        return matcher.matches(returnType);
    }
}
