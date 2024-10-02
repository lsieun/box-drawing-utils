package lsieun.drawing.utils;

public class ClassifyByKeyword {
    public final String category;
    public final String[] keywords;

    private ClassifyByKeyword(String category, String[] keywords) {
        this.category = category;
        this.keywords = keywords;
    }

    public static ClassifyByKeyword of(String category, String... keywords) {
        return new ClassifyByKeyword(category, keywords);
    }
}
