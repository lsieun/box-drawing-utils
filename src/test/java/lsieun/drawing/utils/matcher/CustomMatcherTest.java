package lsieun.drawing.utils.matcher;

import lsieun.drawing.theme.tree.Tree;
import lsieun.drawing.utils.CanvasUtils;
import lsieun.drawing.utils.ClassUtils;
import lsieun.drawing.utils.MemberFindUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.Watchable;
import java.util.List;

class CustomMatcherTest {
    @Test
    void testGetFieldList() {
        Class<?> clazz = URI.class;
        List<Field> fieldList = MemberFindUtils.getFieldList(clazz);
        CustomMatcher<Member> matcher = ClassMemberMatcherBuddy.isPrivate();

        List<Field> fieldList2 = ClassUtils.filter(fieldList, matcher);
        Tree tree = ClassUtils.memberToTreeByStatic(clazz, fieldList2, true);
        CanvasUtils.print(tree);
    }

    @Test
    void testGetMethodList() {
        Class<?> clazz = Watchable.class;
        List<Method> methodList = MemberFindUtils.getMethodList(clazz);
        CustomMatcher<Member> matcher = ClassMemberMatcherBuddy.isPublic()
//                .and(
//                nameContains("get")
//        ).and(
//                nameContainsIgnoreCase("raw")
//        )
                ;

        methodList = ClassUtils.filter(methodList, matcher);
//        methodList = ClassUtils.filterUnique(methodList);
        Tree tree = ClassUtils.memberToTreeByStatic(clazz, methodList, true);
        CanvasUtils.print(tree);
    }
}