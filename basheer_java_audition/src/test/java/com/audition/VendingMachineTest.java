/**
 * 
 */
package com.audition;

import junit.framework.TestCase;
/**
 * @author Basheer
 *
 */
public class VendingMachineTest  extends TestCase{
	
	VendingMachine vendingMachine = new VendingMachine();
	
    public void testSelectProduct()
    {
    	vendingMachine.addCurrency("4w", "4h");
    	vendingMachine.addCurrency("4w", "4h");
    	vendingMachine.addCurrency("3w", "3h");
    	vendingMachine.addCurrency("1w", "1h");
    	vendingMachine.addCurrency("2w", "2h");
    	vendingMachine.buttonPressed("CANDY");
    	vendingMachine.checkDisplay();
        
    }
    
    public void testMakeChange(){
    	
    	vendingMachine.addCurrency("4w", "4h");
    	vendingMachine.addCurrency("4w", "4h");
    	vendingMachine.addCurrency("4w", "4h");
    	vendingMachine.addCurrency("4w", "4h");
    	vendingMachine.buttonPressed("CANDY");
    	vendingMachine.checkDisplay();
    	
    }
    
	 public void testReturnCoin(){
	    	
	    	vendingMachine.addCurrency("4w", "4h");
	    	vendingMachine.addCurrency("4w", "4h");
	    	vendingMachine.addCurrency("4w", "4h");
	    	vendingMachine.addCurrency("4w", "4h");
	    	vendingMachine.cancelTransaction();
	    	vendingMachine.checkDisplay();
	    	
	    }

}
