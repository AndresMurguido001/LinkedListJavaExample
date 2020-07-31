import javax.swing.JOptionPane;

public class GetData {
    
    public static int getInt(String s) {
        return Integer.parseInt(getWord(s));
    }

    public static String getWord(String s) {
        return JOptionPane.showInputDialog(s);
    }

}