public class WordList {

    private WordMeaningNode list;

	WordList() 
	{
		list = null;
	}

	public void add(WordMeaning b)
	{
		WordMeaningNode temp = new WordMeaningNode(b);  
		
	 	if (list == null)
	 		list = temp;
	 	else
	 	{
	 		WordMeaningNode current = list, 
	 				 back = null;
	 		boolean found = false;
	 			
	 	 	while(current != null && ! found) 
	 	 	 	if( temp.getWordMeaning().getWord().compareTo(current.getWordMeaning().getWord()) < 0)
					found = true;
				else
				{
					back = current;
					current = current.next;
				}
					
			temp.next = current;
			
			if ( back == null)
				list = temp;
			else
				back.next = temp;
	 	}
    }

    public WordMeaningNode removeWord(String word)
    {
        WordMeaningNode previousNode = null, currentNode = list;
        boolean found = false;

        if (currentNode.getWordMeaning().getWord().compareTo(word) == 0)
        {
            list = list.next;
            return currentNode;
        }
        else 
        {
            while (!found && currentNode != null)
            {
                // If current node word matches
                if (currentNode.getWordMeaning().getWord().compareTo(word) == 0)
                {
                    // make sure its not the last node
                    if (currentNode.next != null) 
                    {
                        // If its not last, then replace the previous nodes 'next' property
                        // with the current nodes 'next' property, skipping over currentNOde.
                        previousNode.next = currentNode.next;
                        return currentNode;
                    }
                    // Otherwise, assume currentNode is the last element. If so, set the previous nodes 'next'
                    // property to null;
                    previousNode.next = null;
                    found = true;
                    return currentNode;
                }
                else
                {
                    previousNode = currentNode;
                }

                currentNode = currentNode.next;
            }
            return null;
        }
    }

    public WordMeaning findWord(String word)
    {
        boolean found = false;
        WordMeaningNode currentNode = list;

        while (!found && currentNode != null)
        {
            if (currentNode.getWordMeaning().getWord().compareTo(word) == 0)
            {
                found = true;
                return currentNode.getWordMeaning();
            }

            currentNode = currentNode.next;
        }
        return null;
    }


	public String toString()
	{
		String result = "";
		WordMeaningNode current = list;

		while (current != null)
		{
			result += current.getWordMeaning().getWord() + current.getWordMeaning().getMeaning();
			current = current.next;
		}
		return result;
    }
    
    public String getWords()
    {
 		String result = "";
		WordMeaningNode current = list;

		while (current != null)
		{
			result += current.getWordMeaning().getWord() + "\n";
			current = current.next;
		}
		return result;
   
    }
    
}