package lsieun.drawing.theme.miscellaneous;

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

        String[][][] subCube = new String[3][5][3];
        subCube[0][0] = new String[] {"Submarine-001", "30%", "Good"};
        subCube[1][0] = new String[] {"Submarine-002", "60%", "Better"};
        subCube[1][1] = new String[] {"Submarine-003", "60%", "Better"};
        subCube[1][2] = new String[] {"Submarine-004", "60%", "Better"};
        subCube[2][0] = new String[] {"Submarine-005", "90%", "Best"};
        subCube[2][1] = new String[] {"Submarine-006", "90%", "Best"};
        subCube[2][2] = new String[] {"Submarine-007", "90%", "Best"};
        subCube[2][3] = new String[] {"Submarine-008", "90%", "Best"};
        subCube[2][4] = new String[] {"Submarine-009", "90%", "Best"};

        MainSub mainSub = new MainSub("Deep Blue Ocean", mainLines, subCube, 2, 5);
        CanvasUtils.print(mainSub);
    }
}