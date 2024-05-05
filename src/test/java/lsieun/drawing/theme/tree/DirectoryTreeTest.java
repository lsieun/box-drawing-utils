package lsieun.drawing.theme.tree;

import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

class DirectoryTreeTest {
    @Test
    void test() {
        DirectoryTree tree = DirectoryTree.valueOf("IDEA");

        DirectoryTree bin = DirectoryTree.valueOf("bin");
        DirectoryTree help = DirectoryTree.valueOf("help");
        DirectoryTree jbr = DirectoryTree.valueOf("jbr");
        DirectoryTree lib = DirectoryTree.valueOf("lib");
        DirectoryTree license = DirectoryTree.valueOf("license");
        DirectoryTree plugins = DirectoryTree.valueOf("plugins");
        DirectoryTree redist = DirectoryTree.valueOf("redist");
        tree.add(bin);
        tree.add(help);
        tree.add(jbr);
        tree.add(lib);
        tree.add(license);
        tree.add(plugins);
        tree.add(redist);

        DirectoryTree idea_bat = DirectoryTree.valueOf("idea.bat");
        DirectoryTree idea_exe = DirectoryTree.valueOf("idea.exe");
        DirectoryTree idea_exe_vmoptions = DirectoryTree.valueOf("idea.exe.vmoptions");
        bin.add(idea_bat);
        bin.add(idea_exe);
        bin.add(idea_exe_vmoptions);

        DirectoryTree reference_card_pdf = DirectoryTree.valueOf("ReferenceCard.pdf");
        DirectoryTree reference_card_for_mac_pdf = DirectoryTree.valueOf("ReferenceCardForMac.pdf");
        help.add(reference_card_pdf);
        help.add(reference_card_for_mac_pdf);

        DirectoryTree idea_jar = DirectoryTree.valueOf("idea.jar");
        DirectoryTree idea_rt_jar = DirectoryTree.valueOf("idea_rt.jar");
        lib.add(idea_jar);
        lib.add(idea_rt_jar);

        DirectoryTree plugin_java = DirectoryTree.valueOf("java");
        DirectoryTree plugin_java_ide_customization = DirectoryTree.valueOf("java-ide-customization");
        plugins.add(plugin_java);
        plugins.add(plugin_java_ide_customization);

        CanvasUtils.print(tree);
    }
}