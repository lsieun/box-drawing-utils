package run;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.utils.TreeUtils;

import java.util.List;

public class D_MultipleDrawable {
    public static void main(String[] args) {
        List<? extends Drawable> list = TreeUtils.readTree();
        for (Drawable drawable : list) {
            Canvas canvas = new Canvas();
            canvas.draw(0, 0, drawable);
            System.out.println(canvas);
            System.out.println();
        }
    }
}
