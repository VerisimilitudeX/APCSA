public class Test {
	// global variables !!!
	public static int passed = 0;
	public static int total = 0;
	
	public static void main(String[] args) {
        test("123/456 + 123/456", "41/76", "41/76", 41, 76);
        test("-123/456 + -123/456", "-41/76", "-41/76", -41, 76);
        test("+123/456 + +123/456", "41/76", "41/76", 41, 76);

        // valid that cannot be reduced (uses primes)
        test("1/2210 + 1/4389", "6599/9699690", "6599/9699690", 6599, 9699690);
        test("1/2210 - 1/4389", "2179/9699690", "2179/9699690", 2179, 9699690);
        test("1/2210 * 1/4389", "1/9699690", "1/9699690", 1, 9699690);
        test("1/2210 / 1/4389", "4389/2210", "1_2179/2210", 4389, 2210);
        test("23/2210 + 41/4389", "191557/9699690", "191557/9699690", 191557, 9699690);
        test("29/2210 - 43/4389", "32251/9699690", "32251/9699690", 32251, 9699690);

        test("31/2210 * 47/4389", "1457/9699690", "1457/9699690", 1457, 9699690);
        test("37/2210 / 53/4389", "162393/117130", "1_45263/117130", 162393, 117130);
        test("30/77 + 77/30", "6829/2310", "2_2209/2310", 6829, 2310);

        test("30/77 - 77/30", "-5029/2310", "-2_409/2310", -5029, 2310);
        test("30/77 * 77/30", "1", "1", 1, 1);
        test("30/77 / 77/30", "900/5929", "900/5929", 900, 5929);
        test("30/77 + -77/30", "-5029/2310", "-2_409/2310", -5029, 2310);
        test("30/77 - -77/30", "6829/2310", "2_2209/2310", 6829, 2310);
        test("30/77 * -77/30", "-1", "-1", -1, 1);
        test("30/77 / -77/30", "-900/5929", "-900/5929", -900, 5929);
        
        // whole and whole
        test("123/1 + 456/1", "579", "579", 579, 1);
        test("123/1 - 456/1", "-333", "-333", -333, 1);
        test("123/1 * 456/1", "56088", "56088", 56088, 1);
        test("123/1 / 456/1", "41/152", "41/152", 41, 152);
        test("123/1 + +456/1", "579", "579", 579, 1);
        test("123/1 - +456/1", "-333", "-333", -333, 1);
        test("123/1 * +456/1", "56088", "56088", 56088, 1);
        test("123/1 / +456/1", "41/152", "41/152", 41, 152);
        test("+123/1 + 456/1", "579", "579", 579, 1);
        test("+123/1 - 456/1", "-333", "-333", -333, 1);
        test("+123/1 * 456/1", "56088", "56088", 56088, 1);
        test("+123/1 / 456/1", "41/152", "41/152", 41, 152);
        test("123/1 + -456/1", "-333", "-333", -333, 1);
        test("123/1 - -456/1", "579", "579", 579, 1);
        test("123/1 * -456/1", "-56088", "-56088", -56088, 1);
        test("123/1 / -456/1", "-41/152", "-41/152", -41, 152);
        test("-123/1 + 456/1", "333", "333", 333, 1);
        test("-123/1 - 456/1", "-579", "-579", -579, 1);
        test("-123/1 * 456/1", "-56088", "-56088", -56088, 1);
        test("-123/1 / 456/1", "-41/152", "-41/152", -41, 152);
        
        // whole and fraction
        test("1/1 + 1/2", "3/2", "1_1/2", 3, 2);
        test("2/1 - 1/2", "3/2", "1_1/2", 3, 2);
        test("3/1 * 1/2", "3/2", "1_1/2", 3, 2);
        test("4/1 / 1/2", "8", "8", 8, 1);
        test("1/1 + +1/2", "3/2", "1_1/2", 3, 2);
        test("2/1 - +1/2", "3/2", "1_1/2", 3, 2);
        test("3/1 * +1/2", "3/2", "1_1/2", 3, 2);
        test("4/1 / +1/2", "8", "8", 8, 1);
        test("+1/1 + 1/2", "3/2", "1_1/2", 3, 2);
        test("+2/1 - 1/2", "3/2", "1_1/2", 3, 2);
        test("+3/1 * 1/2", "3/2", "1_1/2", 3, 2);
        test("+4/1 / 1/2", "8", "8", 8, 1);
        test("1/1 + -1/2", "1/2", "1/2", 1, 2);
        test("2/1 - -1/2", "5/2", "2_1/2", 5, 2);
        test("3/1 * -1/2", "-3/2", "-1_1/2", -3, 2);
        test("4/1 / -1/2", "-8", "-8", -8, 1);
        test("-1/1 + -1/2", "-3/2", "-1_1/2", -3, 2);
        test("-2/1 - -1/2", "-3/2", "-1_1/2", -3, 2);
        test("-3/1 * -1/2", "3/2", "1_1/2", 3, 2);
        test("-4/1 / -1/2", "8", "8", 8, 1);
 
        // fraction and whole
        test("1/2 + 1/1", "3/2", "1_1/2", 3, 2);
        test("1/2 - 2/1", "-3/2", "-1_1/2", -3, 2);
        test("1/2 * 3/1", "3/2", "1_1/2", 3, 2);
        test("1/2 / 4/1", "1/8", "1/8", 1, 8);
        test("+1/2 + 1/1", "3/2", "1_1/2", 3, 2);
        test("+1/2 - 2/1", "-3/2", "-1_1/2", -3, 2);
        test("+1/2 * 3/1", "3/2", "1_1/2", 3, 2);
        test("+1/2 / 4/1", "1/8", "1/8", 1, 8);
        test("1/2 + +1/1", "3/2", "1_1/2", 3, 2);
        test("1/2 - +2/1", "-3/2", "-1_1/2", -3, 2);
        test("1/2 * +3/1", "3/2", "1_1/2", 3, 2);
        test("1/2 / +4/1", "1/8", "1/8", 1, 8);
        test("1/2 + -1/1", "-1/2", "-1/2", -1, 2);
        test("1/2 - -2/1", "5/2", "2_1/2", 5, 2);
        test("1/2 * -3/1", "-3/2", "-1_1/2", -3, 2);
        test("1/2 / -4/1", "-1/8", "-1/8", -1, 8);
        test("-1/2 + 1/1", "1/2", "1/2", 1, 2);
        test("-1/2 - 2/1", "-5/2", "-2_1/2", -5, 2);
        test("-1/2 * 3/1", "-3/2", "-1_1/2", -3, 2);
        test("-1/2 / 4/1", "-1/8", "-1/8", -1, 8);
        test("-1/2 + -1/1", "-3/2", "-1_1/2", -3, 2);
        test("-1/2 - -2/1", "3/2", "1_1/2", 3, 2);
        test("-1/2 * -3/1", "3/2", "1_1/2", 3, 2);
        test("-1/2 / -4/1", "1/8", "1/8", 1, 8);
 
        // these will fail if program does not
        // properly find duplicate factors
        test("2048/4096 + 2048/4096", "1", "1", 1, 1);
        test("2048/4096 - 2048/4096", "0", "0", 0, 1);
        test("2048/4096 * 2048/4096", "1/4", "1/4", 1, 4);
        test("2048/4096 / 2048/4096", "1", "1", 1, 1);
        test("2048/4096 + +2048/4096", "1", "1", 1, 1);
        test("2048/4096 - +2048/4096", "0", "0", 0, 1);
        test("2048/4096 * +2048/4096", "1/4", "1/4", 1, 4);
        test("2048/4096 / +2048/4096", "1", "1", 1, 1);
        test("+2048/4096 + 2048/4096", "1", "1", 1, 1);
        test("+2048/4096 - 2048/4096", "0", "0", 0, 1);
        test("+2048/4096 * 2048/4096", "1/4", "1/4", 1, 4);
        test("+2048/4096 / 2048/4096", "1", "1", 1, 1);
        test("2048/4096 + -2048/4096", "0", "0", 0, 1);
        test("2048/4096 - -2048/4096", "1", "1", 1, 1);
        test("2048/4096 * -2048/4096", "-1/4", "-1/4", -1, 4);
        test("2048/4096 / -2048/4096", "-1", "-1", -1, 1);
        test("-2048/4096 + 2048/4096", "0", "0", 0, 1);
        test("-2048/4096 - 2048/4096", "-1", "-1", -1, 1);
        test("-2048/4096 * 2048/4096", "-1/4", "-1/4", -1, 4);
        test("-2048/4096 / 2048/4096", "-1", "-1", -1, 1);
        test("-2048/4096 + -2048/4096", "-1", "-1", -1, 1);
        test("-2048/4096 - -2048/4096", "0", "0", 0, 1);
        test("-2048/4096 * -2048/4096", "1/4", "1/4", 1, 4);
        test("-2048/4096 / -2048/4096", "1", "1", 1, 1);
 
        // fractions same denominator
        test("1/2 + 1/2", "1", "1", 1, 1);
        test("1/2 - 1/2", "0", "0", 0, 1);
        test("1/2 * 1/2", "1/4", "1/4", 1, 4);
        test("1/2 / 1/2", "1", "1", 1, 1);
        test("1/2 + +1/2", "1", "1", 1, 1);
        test("1/2 - +1/2", "0", "0", 0, 1);
        test("1/2 * +1/2", "1/4", "1/4", 1, 4);
        test("1/2 / +1/2", "1", "1", 1, 1);
        test("+1/2 + 1/2", "1", "1", 1, 1);
        test("+1/2 - 1/2", "0", "0", 0, 1);
        test("+1/2 * 1/2", "1/4", "1/4", 1, 4);
        test("+1/2 / 1/2", "1", "1", 1, 1);
        test("1/2 + -1/2", "0", "0", 0, 1);
        test("1/2 - -1/2", "1", "1", 1, 1);
        test("1/2 * -1/2", "-1/4", "-1/4", -1, 4);
        test("1/2 / -1/2", "-1", "-1", -1, 1);
        test("-1/2 + 1/2", "0", "0", 0, 1);
        test("-1/2 - 1/2", "-1", "-1", -1, 1);
        test("-1/2 * 1/2", "-1/4", "-1/4", -1, 4);
        test("-1/2 / 1/2", "-1", "-1", -1, 1);
        test("-1/2 + -1/2", "-1", "-1", -1, 1);
        test("-1/2 - -1/2", "0", "0", 0, 1);
        test("-1/2 * -1/2", "1/4", "1/4", 1, 4);
        test("-1/2 / -1/2", "1", "1", 1, 1);
 
        // fractions different denominator
        test("1/2 + 1/3", "5/6", "5/6", 5, 6);
        test("1/2 - 1/3", "1/6", "1/6", 1, 6);
        test("1/2 * 1/3", "1/6", "1/6", 1, 6);
        test("1/2 / 1/3", "3/2", "1_1/2", 3, 2);
        test("1/2 + +1/3", "5/6", "5/6", 5, 6);
        test("1/2 - +1/3", "1/6", "1/6", 1, 6);
        test("1/2 * +1/3", "1/6", "1/6", 1, 6);
        test("1/2 / +1/3", "3/2", "1_1/2", 3, 2);
        test("+1/2 + 1/3", "5/6", "5/6", 5, 6);
        test("+1/2 - 1/3", "1/6", "1/6", 1, 6);
        test("+1/2 * 1/3", "1/6", "1/6", 1, 6);
        test("+1/2 / 1/3", "3/2", "1_1/2", 3, 2);
        test("1/2 + -1/3", "1/6", "1/6", 1, 6);
        test("1/2 - -1/3", "5/6", "5/6", 5, 6);
        test("1/2 * -1/3", "-1/6", "-1/6", -1, 6);
        test("1/2 / -1/3", "-3/2", "-1_1/2", -3, 2);
        test("-1/2 + 1/3", "-1/6", "-1/6", -1, 6);
        test("-1/2 - 1/3", "-5/6", "-5/6", -5, 6);
        test("-1/2 * 1/3", "-1/6", "-1/6", -1, 6);
        test("-1/2 / 1/3", "-3/2", "-1_1/2", -3, 2);
        test("-1/2 + -1/3", "-5/6", "-5/6", -5, 6);
        test("-1/2 - -1/3", "-1/6", "-1/6", -1, 6);
        test("-1/2 * -1/3", "1/6", "1/6", 1, 6);
        test("-1/2 / -1/3", "3/2", "1_1/2", 3, 2);
        
        //compareTo
        test("0/1 < 1/1", "-1", "", 0, 0);
        test("0/1 < 2/1", "-1", "", 0, 0);
        test("1/1 < 0/1", "1", "", 0, 0);
        test("2/1 < 0/1", "1", "", 0, 0);
        test("123/456 < -456/123", "1", "", 0, 0);
        test("-123/456 < 456/123", "-1", "", 0, 0);
        test("24/48 < 2/4", "0", "", 0, 0);
        test("1/2 < 49/99", "1", "", 0, 0);
        test("49/99 < 1/2", "-1", "", 0, 0); 
        
   //   _____   ____    _   _  ____ _______   ______ _____ _____ _______ 
    //  |  __ \ / __ \  | \ | |/ __ \__   __| |  ____|  __ \_   _|__   __|
    //  | |  | | |  | | |  \| | |  | | | |    | |__  | |  | || |    | |   
    //  | |  | | |  | | | . ` | |  | | | |    |  __| | |  | || |    | |   
    //  | |__| | |__| | | |\  | |__| | | |    | |____| |__| || |_   | |   
    //  |_____/ \____/  |_| \_|\____/  |_|    |______|_____/_____|  |_|     
    //
        
        if (passed < total) 
        	System.err.println("\nPass/Total: " + passed + "/" + total);
        else {
        	System.out.println("\nPass/Total: " + passed + "/" + total + " !");
        }
	}
	
	private static void test(String input, String expected, String expectedMixed, int numerator, int denominator) 
	{	
		total += 1;
		
        try 
        {
        	String[]  tokens = input.split(" ");
        	
        	if (tokens == null || tokens.length != 3) 
        	{
        		throw new IllegalArgumentException("Unxpected number of tokens");
        	}
        	
        	// split the input string into three tokens
        	// create our fractions  and  our  operator
        	
        	Fraction operand1 = new Fraction(tokens[0]);
        	Fraction operand2 = new Fraction(tokens[2]);
        	String   operator = tokens[1];

        	Fraction saved1   = new Fraction(operand1.getNumerator(), operand1.getDenominator());
        	Fraction saved2   = new Fraction(operand2.getNumerator(), operand2.getDenominator());
        	
        	Fraction result = null;
        	int intResult = 0;
        	// depending on the operator call a different
        	// method
        	
        	if (operator.equals("+"))
        	{
        		result = operand1.add(operand2);
        	}
        	else if (operator.equals("-"))
        	{
        		result = operand1.subtract(operand2);
        	}
        	else if (operator.equals("*"))
        	{
        		result = operand1.multiply(operand2);
        	}
        	else if (operator.equals("/"))
        	{
        		result = operand1.divide(operand2);
        	}
        	else if (operator.equals("<"))
        	{
        		intResult = operand1.compareTo(operand2);
        	}
        	else 
        	{
        		throw new IllegalArgumentException("Invalid operator, " + operator);
        	}
        	
        	if (operand1.getNumerator() != saved1.getNumerator() || operand1.getDenominator() != saved1.getDenominator())
        	{
            	System.err.println("Fail      : input = \"" + input + "\", first operand was modified, before = \"" + saved1 + "\", after = \"" + operand1 + "\"");
        	}
        	else if (operand2.getNumerator() != saved2.getNumerator() || operand2.getDenominator() != saved2.getDenominator())
        	{
            	System.err.println("Fail      : input = \"" + input + "\", second operand was modified, before = \"" + saved2 + "\", after = \"" + operand2 + "\"");
        	}
        	
        	// compare the result
        	
        	// Check for the same sign on compareTo tests
        	else if (result == null && Integer.signum(intResult) != Integer.signum(Integer.parseInt(expected)))
        	{
        		System.err.println("Fail      : input = \"" + input + "\", expectedSign \"" + expected + "\", actual = \"" + intResult + "\"");
        		System.err.println("            operand1 = " + operand1 + ", operand2 = " + operand2);
        	}
        	else if (result == null)
        	{
        		passed += 1;
        		System.out.println("Success   : input = \"" + input + "\", expectedSign \"" + expected + "\", actual = \"" + intResult + "\"");
        	}
        	
        	// Check for same result on operator tests
        	else if (result.getNumerator() == numerator && result.getDenominator() == denominator && expected.equals(result.toString()) && expectedMixed.equals(result.toMixedNumberString())) 
        	{
            	passed += 1;
            	System.out.println("Success   : input = \"" + input + "\", expected \"" + expected + "\", actual = \"" + result.toString() + "\"");
            	System.out.println("          : input = \"" + input + "\", expectedMixed \"" + expectedMixed + "\", actual = \"" + result.toMixedNumberString() + "\"");
            }
            else 
            {
            	System.err.println("Fail      : input = \"" + input + "\", expected \"" + expected + "\", actual = \"" + result.toString() + "\"");
            	System.err.println("          : input = \"" + input + "\", expected \"" + expectedMixed + "\", actual toMixed = \"" + result.toMixedNumberString() + "\"");
            	System.err.println("            operand1 = " + operand1 + ", operand2 = " + operand2 + ", numerator = " + result.getNumerator() + ", denominator " + result.getDenominator());
            }
        }
        catch (Exception e) 
        {
        	System.err.println("Exception : input = \"" + input + "\", expected \"" + expected + "\"");
            StackTraceElement[] stackTrace = e.getStackTrace();
             
            for (int i = 0; i < stackTrace.length; i++) 
            {
                System.err.println("    " + stackTrace[i]);
            }
        }
    }
}
