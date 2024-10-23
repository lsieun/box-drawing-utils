package lsieun.drawing.utils.reflect;

import lsieun.annotation.mind.logic.ThinkStep;
import lsieun.drawing.theme.tree.Tree;
import lsieun.drawing.utils.ClassifyByKeyword;
import lsieun.drawing.utils.TreeUtils;
import lsieun.drawing.utils.ValueUtils;
import lsieun.drawing.utils.coll.ListUtils;
import lsieun.drawing.utils.coll.MapUtils;
import lsieun.drawing.utils.matcher.CustomMatcher;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

public class ClassUtils {

    private ClassUtils() {
        throw new UnsupportedOperationException();
    }

    public static <T extends Member> Tree memberToTreeByStatic(
            Class<?> clazz,
            List<T> memberList,
            boolean includeMemberType,
            ClassifyByKeyword... classifiers
    ) {
        @ThinkStep("(1) root")
        String rootName = ValueUtils.formatValue(clazz);
        Tree root = Tree.of(rootName);
        if (ListUtils.isEmpty(memberList)) {
            return root;
        }

        @ThinkStep("(2) member: static + non-static")
        List<T> staticList = new ArrayList<>();
        List<T> nonStaticList = new ArrayList<>();

        int memberListSize = memberList.size();
        for (int i = 0; i < memberListSize; i++) {
            T m = memberList.get(i);

            int modifiers = m.getModifiers();
            boolean isStatic = Modifier.isStatic(modifiers);
            if (isStatic) {
                staticList.add(m);
            }
            else {
                nonStaticList.add(m);
            }
        }

        @ThinkStep("(3) tree")
        boolean hasBoth = !staticList.isEmpty() && !nonStaticList.isEmpty();
        if (hasBoth) {
            @ThinkStep("(3.1) tree: has both static and non-static")
            Tree staticChild = Tree.of("static");
            Tree nonStaticChild = Tree.of("non-static");

            addToTree(staticChild, staticList, includeMemberType, classifiers);
            addToTree(nonStaticChild, nonStaticList, includeMemberType, classifiers);

            root.addChild(staticChild);
            root.addChild(nonStaticChild);
        }
        else {
            @ThinkStep("(3.2) tree: has static or non-static")
            boolean hasStatic = ListUtils.isNotEmpty(staticList);
            if (hasStatic) {
                addToTree(root, staticList, includeMemberType, classifiers);
            }
            else {
                addToTree(root, nonStaticList, includeMemberType, classifiers);
            }
        }

        return root;
    }

    private static <T extends Member> void addToTree(
            Tree tree,
            List<T> memberList,
            boolean includeParams,
            ClassifyByKeyword... classifiers
    ) {
        // verify params
        if (memberList == null || memberList.isEmpty()) {
            return;
        }

        // sort
        memberList.sort(Comparator.comparing(Member::getName));

        // classify
        if (classifiers == null || classifiers.length == 0) {
            addToTreeWithoutClassifiers(tree, memberList, includeParams);
        }
        else {
            addToTreeWithClassifiers(tree, memberList, includeParams, classifiers);
        }
    }

    private static <T extends Member> void addToTreeWithClassifiers(
            Tree tree,
            List<T> memberList,
            boolean includeParams,
            ClassifyByKeyword... classifiers
    ) {
        int memberListSize = memberList.size();
        int classifierLength = classifiers.length;
        String otherCategory = "other";

        // (1) member to category list
        Map<T, List<String>> method2CategoryMap = new HashMap<>();
        for (int i = 0; i < memberListSize; i++) {
            // member
            T m = memberList.get(i);
            String name = m.getName().toLowerCase();

            // category list
            List<String> categoryList = MapUtils.getList(method2CategoryMap, m);

            // category check
            for (int j = 0; j < classifierLength; j++) {
                ClassifyByKeyword c = classifiers[j];
                String category = c.category;
                String[] keywords = c.keywords;

                int keywordsLength = keywords.length;
                for (int k = 0; k < keywordsLength; k++) {
                    String str = keywords[k].toLowerCase();
                    if (name.contains(str)) {
                        categoryList.add(category);
                        break;
                    }
                }
            }

            // other
            if (categoryList.isEmpty()) {
                categoryList.add(otherCategory);
            }
        }


        // (2) category to member list
        Map<String, List<T>> categoryMap = new HashMap<>();
        for (int i = 0; i < memberListSize; i++) {
            // member
            T m = memberList.get(i);
            List<String> categoryList = MapUtils.getList(method2CategoryMap, m);

            int categorySize = categoryList.size();
            if (categorySize == 1) {
                String category = categoryList.get(0);
                List<T> list = MapUtils.getList(categoryMap, category);
                list.add(m);
            }
            else {
                List<T> list = MapUtils.getList(categoryMap, otherCategory);
                list.add(m);
            }
        }

        // (3) category to tree
        for (int i = 0; i < classifierLength; i++) {
            // category
            ClassifyByKeyword c = classifiers[i];
            String category = c.category;

            // member list to tree
            List<T> list = MapUtils.getList(categoryMap, category);
            if (!list.isEmpty()) {
                Tree child = Tree.of(category);
                tree.addChild(child);

                addToTree(child, list, includeParams);
            }
        }

        {
            List<T> methodList = MapUtils.getList(categoryMap, otherCategory);
            if (!methodList.isEmpty()) {
                Tree child = Tree.of(otherCategory);
                tree.addChild(child);

                addToTree(child, methodList, includeParams);
            }
        }
    }

    private static <T extends Member> void addToTreeWithoutClassifiers(
            Tree tree,
            List<T> memberList,
            boolean includeParams
    ) {
        int size = memberList.size();
        for (int i = 0; i < size; i++) {
            T m = memberList.get(i);
            String name = ValueUtils.formatValue(m);
            Tree child = Tree.of(name);
            tree.addChild(child);

            if (includeParams) {
                if (m instanceof Field) {
                    addFieldToTree(child, (Field) m);
                }
                else if (m instanceof Method) {
                    addMethodParamAndReturnToTree(child, (Method) m);
                }
            }
        }
    }

    static void addFieldToTree(Tree tree, Field f) {
        Type type = f.getGenericType();
        Tree child = Tree.of(ValueUtils.formatValue(type));
        tree.addChild(child);
    }

    static void addMethodParamAndReturnToTree(Tree tree, Method m) {
        Type[] parameterTypes = m.getGenericParameterTypes();
        Type returnType = m.getGenericReturnType();
        if (parameterTypes.length == 0 && returnType == Void.class) {
            return;
        }

        if (parameterTypes.length > 0) {
            Tree child = Tree.of("params");
            tree.addChild(child);
            for (Type clazz : parameterTypes) {
                Tree grandChild = Tree.of(ValueUtils.formatValue(clazz));
                child.addChild(grandChild);
            }
        }

        if (returnType != Void.class) {
            Tree child = Tree.of("return");
            tree.addChild(child);
            Tree grandChild = Tree.of(ValueUtils.formatValue(returnType));
            child.addChild(grandChild);
        }
    }


    public static List<Method> filter(List<Method> methodList, MethodMatcher matcher) {
        return methodList.stream()
                .filter(matcher::matches)
                .collect(Collectors.toList());
    }

    public static <T extends Member> List<T> filter(List<T> memberList, CustomMatcher<? super T> matcher) {
        return memberList.stream()
                .filter(matcher::matches)
                .collect(Collectors.toList());
    }

    public static <T extends Member> List<T> filterUnique(List<T> methodList) {
        List<String> nameList = new ArrayList<>();
        for (T item : methodList) {
            String name = item.getName();
            if (nameList.contains(name)) {
                continue;
            }
            nameList.add(name);
        }

        Collections.sort(nameList);

        List<T> resultList = new ArrayList<>();
        for (String name : nameList) {
            T m = find(methodList, name);
            resultList.add(m);
        }
        return resultList;
    }

    static <T extends Member> T find(List<T> memberList, String name) {
        List<T> list = memberList.stream()
                .filter(item -> item.getName().equals(name))
                .collect(Collectors.toList());
        if (list.size() == 1) {
            return list.get(0);
        }

        int maxParamCount = 0;
        T target = null;
        for (T item : list) {
            if (item instanceof Executable) {
                Method m = (Method) item;
                Class<?>[] parameterTypes = m.getParameterTypes();
                int length = parameterTypes.length;
                if (length > maxParamCount) {
                    maxParamCount = length;
                    target = item;
                }
            }
            else {
                target = item;
            }
        }
        return target;
    }

    public static Tree innerClass2Tree(Class<?> rootClazz, String... trimNames) {
        List<Class<?>> innerClassList = ClassFindUtils.getInnerClassList(rootClazz, false);
        Tree tree = classList2Tree(rootClazz, innerClassList);

        TreeUtils.trimTree(tree, trimNames);

        return tree;
    }

    public static Tree classList2Tree(Class<?> rootClazz, List<Class<?>> clazzList) {
        Objects.requireNonNull(clazzList);

        int size = clazzList.size();

        String rootSimpleName = rootClazz.getSimpleName();
        String rootTypeName = rootClazz.getTypeName();

        Tree root = Tree.of(rootSimpleName);
        Map<String, Tree> treeMap = new HashMap<>();
        treeMap.put(rootTypeName, root);


        for (int i = 0; i < size; i++) {
            Class<?> clazz = clazzList.get(i);
            String simpleName = clazz.getSimpleName();
            String typeName = clazz.getTypeName();

            // parent
            int index = typeName.lastIndexOf("$");
            String parentName = typeName.substring(0, index);
            Tree parent = treeMap.get(parentName);
            if (parent == null) {
                String msg = String.format("Ignore - parent is null: name = %s, parentName = %s", typeName, parentName);
                System.out.println(msg);
                continue;
            }

            // child
            Tree child = Tree.of(simpleName);

            // parent.add(child)
            parent.addChild(child);

            // map.put(name, child)
            treeMap.put(typeName, child);
        }

        return root;
    }
}
