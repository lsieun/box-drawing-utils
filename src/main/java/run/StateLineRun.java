package run;

import lsieun.canvas.TextStateCanvas;

public class StateLineRun {
    public static void main(String[] args) {
        TextStateCanvas canvas = new TextStateCanvas();

        canvas.moveTo(10, 20);
        canvas.turnUp().drawLine(3)
                .switchRight().drawLine(10)
                .switchDown().drawLine(5)
                .switchLeft().drawLine(20)
                .switchUp().drawLine(7)
                .switchRight().drawLine(30);

        canvas.moveTo(20, 30);
        canvas.turnUp().drawLine(3)
                .switchLeft().drawLine(10)
                .switchDown().drawLine(5)
                .switchRight().drawLine(20)
                .switchUp().drawLine(7)
                .switchLeft().drawLine(30);

        canvas.getLines().forEach(System.out::println);
    }
}
