import com.android.dx.command.Main;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Runner {

    public static void main (String[] args) {

        JFileChooser fc = new JFileChooser("ClassyShark Size Calculator");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        FileFilter filter = new FileNameExtensionFilter("JAR file",
                new String[] {"jar", "jar"});
        fc.setFileFilter(filter);
        fc.addChoosableFileFilter(filter);

        int retValue = fc.showOpenDialog(new JPanel());
        if(retValue == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();

            if(file.isDirectory()) {
                buildJarsFromFolder(file);
            } else {
                buildClassesDex(file);
            }
        }
    }

    private static void buildJarsFromFolder(File folder) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                buildJarsFromFolder(file); // Calls same method again.
            } else {
               buildClassesDex(file);
            }
        }
    }
    
    private static void buildClassesDex(File jarFile) {
        if(!jarFile.getName().endsWith(".jar")) {
            return;
        }

        String[] dxParameters = new String[3];

        dxParameters[0] = "--dex";
        dxParameters[1] = "--output=" + jarFile.getName() + "classes.dex";
        dxParameters[2] = jarFile.getAbsolutePath();

        Main.main(dxParameters);
    }
}
