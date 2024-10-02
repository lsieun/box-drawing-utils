package lsieun.drawing.utils.matcher;

import java.lang.reflect.Type;
import java.util.List;

public class TypeListMatcher extends CustomMatcher.Junction.ForNonNullValues<List<? extends Type>>{
    @Override
    protected boolean doMatch(List<? extends Type> target) {
        return false;
    }
}
