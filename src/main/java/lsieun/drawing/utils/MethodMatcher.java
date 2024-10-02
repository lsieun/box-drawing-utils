package lsieun.drawing.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public interface MethodMatcher {
    boolean matches(Method m);

    class Simple implements MethodMatcher {

        private final Predicate<Method> predicate;

        private Simple(Predicate<Method> predicate) {
            this.predicate = predicate;
        }

        @Override
        public boolean matches(Method m) {
            return predicate.test(m);
        }

        public static Simple of(Predicate<Method> predicate) {
            return new Simple(predicate);
        }
    }

    class Compound implements MethodMatcher {

        private final List<Predicate<Method>> predicateList = new ArrayList<>();

        private Compound(List<Predicate<Method>> list) {
            predicateList.addAll(list);
        }

        @Override
        public boolean matches(Method m) {
            for (Predicate<Method> p : predicateList) {
                if (!p.test(m)) {
                    return false;
                }
            }
            return true;
        }

        public static Compound of(List<Predicate<Method>> list) {
            return new Compound(list);
        }
    }

    class Builder {
        private final List<Predicate<Method>> predicateList = new ArrayList<>();

        private Builder() {
            Predicate<Method> p = m -> !m.isSynthetic();
            predicateList.add(p);
        }

        public Builder isPublic() {
            Predicate<Method> p = m -> checkModifier(m, Modifier::isPublic);
            predicateList.add(p);

            return this;
        }

        public Builder isProtected() {
            Predicate<Method> p = m -> checkModifier(m, Modifier::isProtected);
            predicateList.add(p);

            return this;
        }

        public Builder isPrivate() {
            Predicate<Method> p = m -> checkModifier(m, Modifier::isPrivate);
            predicateList.add(p);

            return this;
        }

        public Builder modifierHas(int mod) {
            Predicate<Method> p = m -> {
                int modifiers = m.getModifiers();
                return (modifiers & mod) != 0;
            };
            predicateList.add(p);

            return this;
        }

        public Builder nameContains(String... names) {
            Predicate<Method> p = m -> {
                if (names.length == 0) {
                    return true;
                }

                String methodName = m.getName();
                for (String str : names) {
                    if (str == null) {
                        continue;
                    }
                    if (methodName.toLowerCase().contains(str.trim().toLowerCase())) {
                        return true;
                    }
                }

                return false;
            };
            predicateList.add(p);

            return this;
        }

        public Builder nameEquals(String... names) {
            Predicate<Method> p = m -> {
                if (names.length == 0) {
                    return true;
                }

                String methodName = m.getName();
                for (String str : names) {
                    if (str == null) {
                        continue;
                    }
                    if (methodName.equalsIgnoreCase(str.trim())) {
                        return true;
                    }
                }

                return false;
            };
            predicateList.add(p);

            return this;
        }

        public Builder nameIgnoresCommon() {
            return nameIgnores("compareTo", "equals", "hashCode", "toString");
        }

        public Builder nameIgnores(String... methodNames) {
            Predicate<Method> p = m -> {
                if (methodNames.length == 0) {
                    return true;
                }
                String name = m.getName();
                for (String mn : methodNames) {
                    if (name.equals(mn)) {
                        return false;
                    }
                }

                return true;
            };
            predicateList.add(p);

            return this;
        }

        public Builder paramTypeCount(int count) {
            Predicate<Method> p = m -> {
                Class<?>[] parameterTypes = m.getParameterTypes();
                return parameterTypes.length == count;
            };
            predicateList.add(p);

            return this;
        }

        public Builder paramTypeEquals(Class<?>... expectedTypes) {
            Predicate<Method> p = m -> {
                Class<?>[] parameterTypes = m.getParameterTypes();
                return Arrays.equals(parameterTypes, expectedTypes);
            };
            predicateList.add(p);

            return this;
        }

        public Builder paramTypeContains(Class<?>... expectedTypes) {
            Predicate<Method> p = m -> {
                Class<?>[] parameterTypes = m.getParameterTypes();
                return checkTypeExists(parameterTypes, expectedTypes);
            };
            predicateList.add(p);

            return this;
        }

        public Builder returnType(Class<?>... expectedTypes) {
            Predicate<Method> p = m -> {
                Class<?> returnType = m.getReturnType();
                return checkTypeExists(returnType, expectedTypes);
            };
            predicateList.add(p);

            return this;
        }

        public MethodMatcher build() {
            return Compound.of(predicateList);
        }

        public static Builder newInstance() {
            return new Builder();
        }

        private static boolean checkModifier(Method m, Predicate<Integer> p) {
            int modifiers = m.getModifiers();
            return checkModifier(modifiers, p);
        }

        private static boolean checkModifier(int modifiers, Predicate<Integer> p) {
            return p.test(modifiers);
        }

        private static boolean checkTypeExists(Class<?>[] actualTypes, Class<?>... expectedTypes) {
            if (expectedTypes.length == 0) {
                return true;
            }


            for (Class<?> actualType : actualTypes) {
                if (checkTypeExists(actualType, expectedTypes)) {
                    return true;
                }
            }

            return false;
        }

        private static boolean checkTypeExists(Class<?> actualType, Class<?>... expectedTypes) {
            if (expectedTypes.length == 0) {
                return true;
            }

            boolean isArray = actualType.isArray();
            if (!isArray) {
                for (Class<?> expectedType : expectedTypes) {
                    if (actualType == expectedType) {
                        return true;
                    }
                }
            }
            else {
                return checkTypeExists(actualType.getComponentType(), expectedTypes);
            }
            return false;
        }
    }
}
