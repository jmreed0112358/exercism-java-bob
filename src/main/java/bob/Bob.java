package bob;

import exceptions.NotImplementedException;

public class Bob
{
	private static final String sure = "Sure.";					// Questions.
	private static final String whoa = "Whoa, chill out!";		// Yelling.
	private static final String fine = "Fine. Be that way!";	// Empty sentences.
	private static final String whatever = "Whatever.";			// Everything else.
	
	public String hey(String input) {
		// Empty string check.
		// Sanitize the string ( Remove special characters ).
		// 
		input = this.sanitize( input );
		
		if ( this.isEmptyOrAllSpaces( input ) ) {
			return fine;
		} else if ( this.isYelling( input ) ) {
			return whoa;
		} else if ( this.isQuestion( input ) ) {
			return sure;
		} else {
			return whatever;
		}
	}
	
	/**
	 * Is every character in this sentence a space?
	 * @param sentence
	 * @return
	 */
	public boolean isEmptyOrAllSpaces(String sentence) {

		for ( int i = 0 ; i < sentence.length( ) ; i++ ) {
			if ( sentence.charAt( i ) != ' ' ) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Does this sentence end in a question mark?
	 * @param sentence
	 * @return
	 */
	public boolean isQuestion(String sentence) {
		if ( sentence.isEmpty( ) ) {
			return false;
		}
		
		return ( sentence.charAt( sentence.length( ) - 1 ) == '?' );
	}
	
	/**
	 * Checks to see if all letters are capitalized.
	 * @param sentence
	 * @return
	 */
	public boolean isYelling(String sentence) {
		if ( sentence.isEmpty( ) ) {
			return false;
		}
		
		int numUpperCaseLetters = 0;
		
		for ( int i = 0 ; i < sentence.length( ) ; i++ ) {
			if ( Character.isLetter( sentence.charAt( i ) ) ) {
				if ( Character.isUpperCase( sentence.charAt( i ) ) ) {
					numUpperCaseLetters += 1;
				} else {
					return false;
				}
			}
		}
		
		return (numUpperCaseLetters != 0 );
	}
	
	/**
	 * Removes garbage from input.  Retain all alphabetic and punctuation characters.
	 * @param input
	 * @return
	 */
	private String sanitize(String input) {
		if ( input.isEmpty( ) ) {
			return input;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0 ; i < input.length( ) ; i++ ) {
			if ( !Character.isISOControl( input.charAt( i ) )) {
				sb.append( input.charAt( i ) );
			}
		}
		
		return sb.toString( );
	}
}
