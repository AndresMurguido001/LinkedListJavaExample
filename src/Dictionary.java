import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Dictionary {

    public static WordList wordList = new WordList();
    public static WordList deletedWordList = new WordList();
    public static void main(String[] args) throws Exception {
        
        boolean done = false;
        String menu =   "1. Display Dictionary\n" +
                        "2. Add word to Dictionary\n"  +
                        "3. Add meaning to existing word\n" +
                        "4. Remove word from Dictionary\n" +
                        "5. Display Deleted words\n" +
                        "6. Exit\n";

        while (!done) 
        {
            int option = GetData.getInt(menu);

            switch (option)
            {
                case 1:
                    displayWordList();
                    break;
                case 2:
                    addWord();
                    break;
                case 3:
                    editWord();
                    break;
                case 4:
                    removeWord();
                    break;
                case 5:
                    displayDeletedWords();
                    break;
                case 6:
                    done = true;
                    break;
                default:
                    break;
            }
        }
        
    }

    private static void displayDeletedWords() {
        JTextArea textArea = new JTextArea(deletedWordList.getWords(), 20, 30);

        // change font to monospaced font for easier formatting
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Deleted Words", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void removeWord() {
        String wordToRemove = GetData.getWord("Word:");
        WordMeaningNode removedWord = wordList.removeWord(wordToRemove);

        deletedWordList.add(removedWord.getWordMeaning());
    }

    private static void editWord() {
        String word = GetData.getWord("Word:");
        String meaning = GetData.getWord("Meaning:");

        WordMeaning wordToEdit = wordList.findWord(word);

        if (wordToEdit != null)
        {
            String meaningFormatted = "";
            for (int i = 0; i < wordToEdit.getWord().length(); i++)
            {
                // Add spaces to line up meaning
                meaningFormatted += " ";
            }
            meaningFormatted += String.format(" - %s\n", meaning);
            wordToEdit.appendToMeaning(meaningFormatted);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Word does not exist in Dictionary", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private static void displayWordList() {
        JTextArea textArea = new JTextArea(wordList.toString(), 20, 30);
        // change font to monospaced font for easier formatting
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Words", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void addWord() {

        String newWord = GetData.getWord("Word:");
        
        WordMeaning exists = wordList.findWord(newWord);

        if (exists == null)
        {
            String meaning = GetData.getWord("Meaning:");
    
            meaning = String.format(" - %s\n", meaning);
    
            WordMeaning newEntry = new WordMeaning(newWord, meaning);
    
    
            wordList.add(newEntry);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Word already exists. Please select edit option.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}
