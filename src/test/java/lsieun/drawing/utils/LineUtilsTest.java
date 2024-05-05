package lsieun.drawing.utils;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.theme.shape.line.ConnectionDirection;
import lsieun.drawing.theme.shape.line.ContinuousLine;
import lsieun.drawing.theme.shape.rect.FullRectangle;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LineUtilsTest {

    @Test
    @Order(1)
    void testConnectVertical_FromTop2Down() {
        connect(1, 30, 8, 30, ConnectionDirection.VERTICAL);
    }

    @Test
    @Order(2)
    void testConnectVertical_FormTopLeft2DownRight() {
        connect(1, 30, 8, 50, ConnectionDirection.VERTICAL);
    }

    @Test
    @Order(3)
    void testConnectVertical_FromTopRight2DownLeft() {
        connect(1, 30, 8, 10, ConnectionDirection.VERTICAL);
    }

    @Test
    @Order(4)
    void testConnectHorizontal_FromLeft2Right() {
        connect(5, 20, 5, 50, ConnectionDirection.HORIZONTAL);
    }

    @Test
    @Order(5)
    void testConnectHorizontal_FormTopLeft2DownRight() {
        connect(5, 20, 9, 50, ConnectionDirection.HORIZONTAL);
    }

    @Test
    @Order(6)
    void testConnectHorizontal_FromDownLeft2TopRight() {
        connect(5, 20, 1, 50, ConnectionDirection.HORIZONTAL);
    }

    @Test
    @Order(7)
    void testConnectHorizontal_FromDownRight2TopLeft() {
        connect(5, 50, 1, 20, ConnectionDirection.HORIZONTAL);
    }

    private void connect(int startRow1, int startCol1, int startRow2, int startCol2, ConnectionDirection direction) {
        int contentWidth = 5;
        int contentHeight = 1;


        // create two rectangles
        FullRectangle rect1 = new FullRectangle(contentWidth, contentHeight);
        FullRectangle rect2 = new FullRectangle(contentWidth, contentHeight);

        rect1.setStartRow(startRow1);
        rect1.setStartCol(startCol1);
        rect2.setStartRow(startRow2);
        rect2.setStartCol(startCol2);


        // connect the two rectangles
        ContinuousLine line = LineUtils.connect(rect1, rect2, direction);


        // draw the rectangles and the line on the canvas
        Canvas canvas = new Canvas();
        canvas.draw(rect1.getStartRow(), rect1.getStartCol(), rect1);
        canvas.draw(rect2.getStartRow(), rect2.getStartCol(), rect2);
        if (direction == ConnectionDirection.VERTICAL) {
            canvas.draw(line.getStartRow(), line.getStartCol(), line);
        }
        else {
            canvas.draw(line.getStartRow(), line.getStartCol(), line);
        }

        System.out.println(canvas);
    }
}
