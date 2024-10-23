package lsieun.drawing.utils;

import lsieun.drawing.theme.tree.Tree;
import lsieun.drawing.utils.reflect.ClassUtils;
import lsieun.drawing.utils.reflect.MemberFindUtils;
import lsieun.drawing.utils.reflect.MethodMatcher;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.Watchable;
import java.util.List;
import java.util.stream.Stream;

class MarkdownUtilsTest {
    @Test
    void testFieldList() {
        Class<?> clazz = StandardOpenOption.class;
        List<Field> fieldList = MemberFindUtils.getFieldList(clazz);
        Tree tree = ClassUtils.memberToTreeByStatic(clazz, fieldList, true);
        MarkdownUtils.print(tree);
    }

    @Test
    void testPublicMethodList() {
        Class<?> clazz = Watchable.class;
        List<Method> methodList = MemberFindUtils.getMethodList(clazz);
        MethodMatcher matcher = MethodMatcher.Builder.newInstance()
                .isPublic()
                .nameIgnoresCommon()
                .build();
        methodList = ClassUtils.filter(methodList, matcher);
        Tree tree = ClassUtils.memberToTreeByStatic(clazz, methodList, true);
        MarkdownUtils.print(tree);
    }

    @Test
    void testPublicMethodListByParamTypes() {
        Class<?> clazz = Files.class;

        List<Method> methodList = MemberFindUtils.getMethodList(clazz);
        MethodMatcher matcher = MethodMatcher.Builder.newInstance()
                .isPublic()
                .nameIgnoresCommon()
                .paramTypeContains(
                  OpenOption.class
//                CopyOption.class
//                LinkOption.class
//                        FileVisitOption.class,
//                        FileVisitor.class
                )
                .build();
        methodList = ClassUtils.filter(methodList, matcher);
        Tree tree = ClassUtils.memberToTreeByStatic(clazz, methodList, true);
        MarkdownUtils.print(tree);
    }

    @Test
    void testPublicMethodListByReturnType() {
        Class<?> clazz = Files.class;

        List<Method> methodList = MemberFindUtils.getMethodList(clazz);
        MethodMatcher matcher = MethodMatcher.Builder.newInstance()
                .isPublic()
                .nameIgnoresCommon()
                .returnType(
                        Stream.class
                )
                .build();
        methodList = ClassUtils.filter(methodList, matcher);
        Tree tree = ClassUtils.memberToTreeByStatic(clazz, methodList, true);
        MarkdownUtils.print(tree);
    }
}