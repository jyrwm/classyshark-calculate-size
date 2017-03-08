import com.android.dx.command.Main;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Runner {

    public static void main (String[] args) {

        JFileChooser fc = new JFileChooser("ClassyShark Size Calculator");

        FileFilter filter = new FileNameExtensionFilter("JAR file",
                new String[] {"jar", "jar"});
        fc.setFileFilter(filter);
        fc.addChoosableFileFilter(filter);

        int retValue = fc.showOpenDialog(new JPanel());
        if(retValue == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();

            String[] dxParameters = new String[3];

            dxParameters[0] = "--dex";
            dxParameters[1] = "--output=classes.dex";
            dxParameters[2] = file.getAbsolutePath();

            Main.main(dxParameters);
        }
    }
}
