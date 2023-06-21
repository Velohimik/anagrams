package ua.com.foxminded.anagrams;

/**
 * This class executes some tests of Anagrams app. It instances testMaker class, sends input sentence
 * and expected result of Anagrams work to testMaker method makeTest(). Int variables (named by test name *Test)
 * are initialized by makeTest() returned result. Sum of all int *Test is calculated. If sum equals zero
 * tests are run, else tests are failed.
 */
public class AnagramsEndToEndTesting {

    public static void main(String[] args) {
        TestMaker testMaker = new TestMaker();
        
        int emptyStringTest = testMaker.makeTest("", "");
        
        int oneSpaceTest = testMaker.makeTest("\' \'", "  =>  \n");
        
        int severalSpacesTest = testMaker.makeTest("\'     \'", "      =>      \n");
        
        int oneCharacterTest = testMaker.makeTest("\'#\'", "# => #\n");
        
        int multiplySameLettersTest = testMaker.makeTest("bbbb", "bbbb => bbbb\n");
        
        int sameLettersInUpperAndLowercasesTest = testMaker.makeTest("cCCcC", "cCCcC => CcCCc\n");
        
        int wordWithDifferentCharactersTest = testMaker.makeTest("\'ab(DeF\'", "ab(DeF => Fe(Dba\n");
        
        int wordWithOnlySymbols = testMaker.makeTest("\'*^%$#'", "*^%$# => *^%$#\n");
        
        int twoWordsWithSpaceInSentenceTest = testMaker.makeTest("\'awe gh6j$ii\'", "awe gh6j$ii => ewa ii6j$hg\n");
        
        int twoSentencesTest = testMaker.makeTest("awe \'gh6j$ii\'", "awe => ewa\ngh6j$ii => ii6j$hg\n");
        
        int twoWordsWithDifferentDelimitersTest = testMaker.makeTest("\"awe`tgh6j#ii\"", "awe\tgh6j#ii => ewa\tii6j#hg\n");
        
        int resultOfTests = emptyStringTest + oneSpaceTest + severalSpacesTest
                            + oneCharacterTest + multiplySameLettersTest 
                            + sameLettersInUpperAndLowercasesTest 
                            + wordWithDifferentCharactersTest 
                            + wordWithOnlySymbols 
                            + twoWordsWithSpaceInSentenceTest 
                            + twoSentencesTest 
                            + twoWordsWithDifferentDelimitersTest;
        
        if (resultOfTests == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}