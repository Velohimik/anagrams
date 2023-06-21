package ua.com.foxminded.anagrams;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.*;

class MainTest {

    private Main main;
    private Anagram anagram;
    private ByteArrayOutputStream catchStandardOutput;
    private PrintStream printStream;
    private String fakeCommandLineOutput;
    
    @BeforeEach
    void setUp() {
        main = new Main();
        anagram = mock(Anagram.class);
        main.setAnagram(anagram);
        catchStandardOutput = new ByteArrayOutputStream();
        printStream = new PrintStream(catchStandardOutput);
    }
    
    @SuppressWarnings("static-access")
    @Test
    void main_shouldCloseApplicationWithoutPrinting_whenUserDontEnterCommandLineArguments() {
        //Arrange
        String[] fakeCommandLineArguments = {};
                
        //Act
        when(anagram.makeAnagrams("")).thenReturn("");
        System.setOut(printStream);
        main.main(fakeCommandLineArguments);
        fakeCommandLineOutput = catchStandardOutput.toString();
        
        //Assert
        assertEquals("", fakeCommandLineOutput);
    }
    
    @SuppressWarnings("static-access")
    @Test
    void main_shouldPrintArrowWithCRLF_whenUserEnterSpaceAsCommandLineArgument() {
        //Arrange
        String[] fakeCommandLineArguments = {" "};
                
        //Act
        when(anagram.makeAnagrams(" ")).thenReturn(" ");
        System.setOut(printStream);
        main.main(fakeCommandLineArguments);
        fakeCommandLineOutput = catchStandardOutput.toString();
        
        //Assert
        assertEquals(" " + " => " + " " + "\r\n", fakeCommandLineOutput);
    }

    @SuppressWarnings("static-access")
    @Test
    void main_shouldPrintArrowBetweenInputAndReversedWord_whenUserEnterOneWordSentenceAsCommandLineArgument() {
        //Arrange
        String[] fakeCommandLineArguments = {"ab^cd5k#lmn"};
        
        //Act
        when(anagram.makeAnagrams("ab^cd5k#lmn")).thenReturn("nm^lk5d#cba");
        System.setOut(printStream);
        main.main(fakeCommandLineArguments);
        fakeCommandLineOutput = catchStandardOutput.toString();
        
        //Assert
        assertEquals("ab^cd5k#lmn" + " => " + "nm^lk5d#cba" + "\r\n", fakeCommandLineOutput);
    }
    
    @SuppressWarnings("static-access")
    @Test
    void main_shouldPrintOneOutputLine_whenUserEnterOneSentenceWithSeveralWordsAndDelimitersAsCommandLineArgument() {
        //Arrange
        String[] fakeCommandLineArguments = {"ab^cd 5k#lmn"};
        
        //Act
        when(anagram.makeAnagrams("ab^cd 5k#lmn")).thenReturn("dc^ba 5n#mlk");
        System.setOut(printStream);
        main.main(fakeCommandLineArguments);
        fakeCommandLineOutput = catchStandardOutput.toString();
        
        //Assert
        assertEquals("ab^cd 5k#lmn" + " => " + "dc^ba 5n#mlk" + "\r\n", fakeCommandLineOutput);
    }
    
    @SuppressWarnings("static-access")
    @Test
    void main_shouldPrintCorespondingNumberOfOutputLines_whenUserEnterSeveralCommandLineArguments() {
        //Arrange
        String[] fakeCommandLineArguments = {"ab^cd", "5k#lmn"};
        
        //Act
        when(anagram.makeAnagrams("ab^cd")).thenReturn("dc^ba");
        when(anagram.makeAnagrams("5k#lmn")).thenReturn("5n#mlk");
        System.setOut(printStream);
        main.main(fakeCommandLineArguments);
        fakeCommandLineOutput = catchStandardOutput.toString();
        
        //Assert
        assertEquals("ab^cd" + " => " + "dc^ba" + "\r\n" +  "5k#lmn" + " => " + "5n#mlk" + "\r\n", fakeCommandLineOutput);
    }
}