public class WordMeaning {
    
    private String word;
    private String meaning;

    WordMeaning(String word, String meaning)
    {
        this.word = word;
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getWord() {
        return word;
    }

    public void appendToMeaning(String meaning)
    {
        this.meaning += meaning;
    }

}