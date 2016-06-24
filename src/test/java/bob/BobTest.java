package bob;
import org.junit.Test;

import static org.junit.Assert.*;

public class BobTest {
    private final Bob bob = new Bob();

    
    // sanitize(...) tests.
    // isQuestion(...) tests.
    @Test
    public void test_isQuestion_NullString_ThrowsException() {
    	try {
    		bob.isQuestion( null );
    		fail("Supposed to catch NullPointerException");
    	} catch ( NullPointerException npe ) {
    		
    	} catch ( Exception e ) {
    		fail("Expected to catch NullPointerException");
    	}
    }
    
    @Test 
    public void test_isQuestion_EmptyString_ReturnsFalse() {
    	assertFalse( bob.isQuestion( "" ) );
    }
    
    @Test 
    public void test_isQuestion_AllSpacesString_ReturnsFalse() {
    	assertFalse( bob.isQuestion( "   " ) );
    }
    
    @Test
    public void test_isQuestion_NoLettersAllSymbolsNoQuestionMark_ReturnsFalse() {
    	assertFalse( bob.isQuestion( "^&*^*&&^*&^*&^*(()" ) );
    }
    
    @Test
    public void test_isQuestion_NoLettersAllSymbolsQuestionMark_ReturnsTrue() {
    	assertTrue( bob.isQuestion( "^&*^*&&^*&^*&^*(()!?" ) );
    }
    
    @Test
    public void test_isQuestion_Question_ReturnsTrue() {
    	assertTrue( bob.isQuestion( "This is a question?" ) );
    }
    
    @Test
    public void test_isQuestion_Statement_ReturnsFalse() {
    	assertFalse( bob.isQuestion( "This is a statement." ) );
    }
    
    @Test
    public void test_isQuestion_Forceful_ReturnsFalse() {
    	assertFalse( bob.isQuestion( "This is a forceful statement!" ) );
    }
    
    // isYelling(...) tests.
    @Test
    public void test_isYelling_NullString_ThrowsException() {
    	try {
    		bob.isYelling( null );
    		fail("Supposed to catch NullPointerException");
    	} catch ( NullPointerException npe ) {
    		
    	} catch ( Exception e ) {
    		fail("Expected to catch NullPointerException");
    	}
    }
    
    @Test 
    public void test_isYelling_EmptyString_ReturnsFalse() {
    	assertFalse( bob.isYelling( "" ) );
    }
    
    @Test
    public void test_isYelling_AllSpacesString_ReturnsFalse() {
    	assertFalse( bob.isYelling( "   " ) );
    }
    
    @Test
    public void test_isYelling_AllLettersAreCapsExclamationMark_ReturnsTrue() {
    	assertTrue( bob.isYelling( "SHUT UP!" ) );
    }
    
    @Test
    public void test_isYelling_AllLettersAreCapsNoExclamationMark_ReturnsTrue() {
    	assertTrue( bob.isYelling( "SHUT UP" ) );
    }
    
    @Test
    public void test_isYelling_AllButOneLetterAreCapsExclamationMark_ReturnsFalse() {
    	assertFalse( bob.isYelling( "No YOU FOOL!" ) );
    }
    
    @Test
    public void test_isYelling_AllButOneLetterAreCapsNoExclamationMark_ReturnsFalse() {
    	assertFalse( bob.isYelling( "No YOU FOOL" ) );
    }
    
    @Test
    public void test_isQuestion_NoLettersAllSymbolsNoExclamationMark_ReturnsFalse() {
    	assertFalse( bob.isQuestion( "^&*^*&&^*&^*&^*(()" ) );
    }
    
    @Test
    public void test_isQuestion_NoLettersAllSymbolsExclamationMark_ReturnsTrue() {
    	assertTrue( bob.isQuestion( "^&*^*&&^*&^*&^*(()?!" ) );
    }
    
    // isAllSpaces(...) tests.
    @Test
    public void test_isEmptyOrAllSpaces_EmptyString_ReturnsTrue() {
    	assertTrue( bob.isEmptyOrAllSpaces( "" ) );
    }
    
    @Test
    public void test_isEmptyOrAllSpaces_SingleSpace_ReturnsTrue() {
    	assertTrue( bob.isEmptyOrAllSpaces( "" ) );
    }
    
    @Test
    public void test_isEmptyOrAllSpaces_MultipleSpace_ReturnsTrue() {
    	assertTrue( bob.isEmptyOrAllSpaces( "" ) );
    }
    
    @Test
    public void test_isEmptyOrAllSpaces_NotAllSpaces_ReturnsFalse() {
    	assertFalse( bob.isEmptyOrAllSpaces( "    foo  " ) );
    }
    
    // hey(...) tests.
    @Test
    public void test_hey_NullString_ThrowsException() {
    	try {
    		bob.hey( null );
    		fail("Supposed to catch NullPointerException");
    	} catch ( NullPointerException npe ) {
    		
    	} catch ( Exception e ) {
    		fail("Expected to catch NullPointerException");
    	}
    }
    
    @Test
    public void test_hey_ShoutingButNotAllLettersAreCaps_ReturnsExpectedResponse() {
    	assertEquals( "Whatever", bob.hey( "No YOU FOOL!" ) );
    }
    
    @Test
    public void saySomething() {
        assertEquals(
            "Whatever.",
            bob.hey("Tom-ay-to, tom-aaaah-to.")
        );
    }

    @Test
    public void shouting() {
        assertEquals(
            "Whoa, chill out!",
            bob.hey("WATCH OUT!")
        );
    }

    @Test
    public void askingAQuestion() {
        assertEquals(
            "Sure.",
            bob.hey("Does this cryogenic chamber make me look fat?")
        );
    }

    @Test
    public void askingANumericQuestion() {
        assertEquals(
            "Sure.",
            bob.hey("You are, what, like 15?")
        );
    }

    @Test
    public void talkingForcefully() {
        assertEquals(
            "Whatever.",
            bob.hey("Let's go make out behind the gym!")
        );
    }

    @Test
    public void usingAcronymsInRegularSpeech() {
        assertEquals(
            "Whatever.", bob.hey("It's OK if you don't want to go to the DMV.")
        );
    }

    @Test
    public void forcefulQuestions() {
        assertEquals(
            "Whoa, chill out!", bob.hey("WHAT THE HELL WERE YOU THINKING?")
        );
    }

    @Test
    public void shoutingNumbers() {
        assertEquals(
            "Whoa, chill out!", bob.hey("1, 2, 3 GO!")
        );
    }

    @Test
    public void onlyNumbers() {
        assertEquals(
            "Whatever.", bob.hey("1, 2, 3")
        );
    }

    @Test
    public void questionWithOnlyNumbers() {
        assertEquals(
            "Sure.", bob.hey("4?")
        );
    }

    @Test
    public void shoutingWithSpecialCharacters() {
        assertEquals(
            "Whoa, chill out!", bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!")
        );
    }

    @Test
    public void shoutingWithUmlauts() {
        assertEquals(
            "Whoa, chill out!", bob.hey("\u00dcML\u00c4\u00dcTS!")
        );
    }

    @Test
    public void calmlySpeakingWithUmlauts() {
        assertEquals(
            "Whatever.", bob.hey("\u00dcML\u00e4\u00dcTS!")
        );
    }

    @Test
    public void shoutingWithNoExclamationMark() {
        assertEquals(
            "Whoa, chill out!", bob.hey("I HATE YOU")
        );
    }
    
    @Test
    public void statementContainingQuestionMark() {
        assertEquals(
            "Whatever.", bob.hey("Ending with ? means a question.")
        );
    }

    @Test
    public void prattlingOn() {
        assertEquals(
            "Sure.", bob.hey("Wait! Hang on. Are you going to be OK?")
        );
    }

    @Test
    public void silence() {
        assertEquals(
            "Fine. Be that way!", bob.hey("")
        );
    }

    @Test
    public void prolongedSilence() {
        assertEquals(
            "Fine. Be that way!", bob.hey("    ")
        );
    }
}
