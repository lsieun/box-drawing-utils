package lsieun.drawing.theme.miscellaneous;

import lsieun.drawing.theme.text.Text;
import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

class MainSubTest {
    @Test
    void test() {
        String[] mainLines = new String[]{
                "depth: 100m",
                "depth: 200m",
                "depth: 300m"
            };
        Text mainText = Text.of(mainLines);

        Text[][] subMatrix = new Text[3][5];
        subMatrix[0][0] = Text.of("Submarine-001", "30%", "Good");
        subMatrix[1][0] = Text.of("Submarine-002", "60%", "Better");
        subMatrix[1][1] = Text.of("Submarine-003", "60%", "Better");
        subMatrix[1][2] = Text.of("Submarine-004", "60%", "Better");
        subMatrix[2][0] = Text.of("Submarine-005", "90%", "Best");
        // subMatrix[2][0] = null;
        subMatrix[2][1] = Text.of("Submarine-006", "90%", "Best");
        subMatrix[2][2] = Text.of("Submarine-007", "90%", "Best");
        subMatrix[2][3] = Text.of("Submarine-008", "90%", "Best");
        subMatrix[2][4] = Text.of("Submarine-009", "90%", "Best");
        // subMatrix[2][4] = null;

        MainSub mainSub = new MainSub("Deep Blue Ocean", mainText, subMatrix, 2, 5);
        CanvasUtils.print(mainSub);
    }
}