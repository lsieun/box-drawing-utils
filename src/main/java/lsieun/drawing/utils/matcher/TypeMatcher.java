package lsieun.drawing.utils.matcher;

import java.lang.reflect.Type;
import java.util.Objects;

public class TypeMatcher extends CustomMatcher.Junction.ForNonNullValues<Type> {
    private final Type type;

    public TypeMatcher(Type type) {
        this.type = type;
    }

    @Override
    protected boolean doMatch(Type target) {
        return Objects.equals(type, target);
    }
}
