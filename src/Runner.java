import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Runner {

    public static void main (String[] args) {

        JFileChooser fc = new JFileChooser("ClassyShark Size Calculator");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        FileFilter filter = new FileNameExtensionFilter("jars or classes",
                new String[] {"jar", "class"});
        fc.setFileFilter(filter);
        fc.addChoosableFileFilter(filter);

        int retValue = fc.showOpenDialog(new JPanel());
        if(retValue == JFileChooser.APPROVE_OPTION){
            FileUtils.buildFrom(fc.getSelectedFile());
        }
    }
}
