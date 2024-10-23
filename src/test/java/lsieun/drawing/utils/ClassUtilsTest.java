package lsieun.drawing.utils;

import lsieun.drawing.theme.tree.Tree;
import lsieun.drawing.utils.reflect.ClassUtils;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ClassUtilsTest {
    @Test
    void testInnerClasses2Tree() {
        Class<?> clazz = Map.class;
        Tree tree = ClassUtils.innerClass2Tree(clazz);
        MarkdownUtils.print(tree);
    }
}