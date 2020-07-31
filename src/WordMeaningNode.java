public class WordMeaningNode {
    
    
    public WordMeaningNode next;
    private WordMeaning wordMeaning;

    WordMeaningNode(WordMeaning wordMeaning)
    {
        this.wordMeaning = wordMeaning;
    }

    public WordMeaning getWordMeaning() {
        return wordMeaning;
    }

}