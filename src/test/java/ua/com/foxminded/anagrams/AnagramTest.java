package ua.com.foxminded.anagrams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class AnagramTest {

    private Anagram anagram;

    @BeforeEach
    void setUp() {
        anagram = new Anagram();
    }
    
    @Test
    void reverseWord_shouldReturnEmptyString_whenInputWordIsEmpty() {
        //Arrange
        String inputWord = "";
        
        //Act
        String resultWord = anagram.reverseWord(inputWord).toString();
        
        //Assert
        assertEquals("", resultWord);
    }

    @Test
    void reverseWord_shouldReturnTheSameLetter_whenInputWordConsistOfOneLetter() {
        //Arrange
        String inputWord = "a";
        
        //Act
        String resultWord = anagram.reverseWord(inputWord).toString();
        
        //Assert
        assertEquals("a", resultWord);
    }
    
    @Test
    void reverseWord_shouldReturnTheSameSymbol_whenInputWordConsistOfOneSymbol() {
        //Arrange
        String inputWord = "#";
        
        //Act
        String resultWord = anagram.reverseWord(inputWord).toString();
        
        //Assert
        assertEquals("#", resultWord);
    }
    
    @Test
    void reverseWord_shouldReverseOnlyLetters_whenInputWordConsistOfDifferentSymbols() {
        //Arrange
        String inputWord = "aB!cd(e^fGh@";
        
        //Act
        String resultWord = anagram.reverseWord(inputWord).toString();
        
        //Assert
        assertEquals("hG!fe(d^cBa@", resultWord);
    }
        
    @Test
    void makeAnagrams_shouldReturnDelimiters_whenInputSentenceConsistOfThemOnly() {
        //Arrange
        String inputSentence = " \t\r";
        
        //Act
        String resultSentence = anagram.makeAnagrams(inputSentence);
        
        //Assert
        assertEquals(" \t\r", resultSentence);
    }
    
    @Test
    void makeAnagrams_shouldReturnSentenceWithTabAsDelimiter_whenInputSentenceContainsTab() {
        //Arrange
        String inputSentence = "b@g\tF*d";
        
        //Act
        String resultSentence = anagram.makeAnagrams(inputSentence);
        
        //Assert
        assertEquals("g@b\td*F", resultSentence);
    }
    
    @Test
    void makeAnagrams_shouldReturnSentenceWithCarriageReturnAsDelimiter_whenInputSentenceContainsCarriageReturn() {
        //Arrange
        String inputSentence = "b@g\rF*d";
        
        //Act
        String resultSentence = anagram.makeAnagrams(inputSentence);
        
        //Assert
        assertEquals("g@b\rd*F", resultSentence);
    }
    
    @Test
    void makeAnagrams_shouldReturnSentenceWithLineFeedAsDelimiter_whenInputSentenceContainsLineFeed() {
        //Arrange
        String inputSentence = "b@g\nF*d";
        
        //Act
        String resultSentence = anagram.makeAnagrams(inputSentence);
        
        //Assert
        assertEquals("g@b\nd*F", resultSentence);
    }
    
    @Test
    void makeAnagrams_shouldReturnSentenceWithDifferentDelimitersInTheSameOrder_whenInputSentenceContainsSeveralDifferentDelimiters() {
        //Arrange
        String inputSentence = "n^g \t \r  \n F*d";
        
        //Act
        String resultSentence = anagram.makeAnagrams(inputSentence);
        
        //Assert
        assertEquals("g^n \t \r  \n d*F", resultSentence);
    }
    
}
