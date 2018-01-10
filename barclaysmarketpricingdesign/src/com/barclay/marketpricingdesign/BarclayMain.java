package com.barclay.marketpricingdesign;

import java.io.IOException;
import java.util.Scanner;
import java.util.*;

import static java.lang.System.*;

/**
 * Created by freelancer on 3/18/17.
 * <p>
 * <p>
 * There are inconsistensies in the way the Scanner utility handles delimiters/regular expressions we can use
 * to stop reading input from console. across different operating systems and also in different consoles
 * on different ides.  For example, the idea intellij has several configurable consoles.
 * That's the reason I chose to do it this way so the examiner will not run into issues
 * <p>
 * The design pattern used here is the Decorator, by which we handle Strings, more so when we pass it to
 * the object ProcessScannedInput
 */

public class BarclayMain {

// input consists of number of products, followed by each Product's supply and demand parameters.
// followed by number of surveyed prices, followed by competitor prices.

//    2
//    flashdrive H H
//    ssd L H
//    55

//    flashdrive X 1.0s
//    ssd X 10.0
//    flashdrive Y 0.9
//    flashdrive Z 1.1
//    ssd Y 12.5


    public static void  main ( String[] args ) throws IOException {
        ProcessScannedInput processScannedInput = null;
        int numProducts = 0;
        int numSurveys = 0;
        Scanner scanner = new Scanner ( System.in );
        List<String> slist3 = new ArrayList<String>();
        out.println ( "Enter your input " );
     
        String scan = "";
         while (!scan.equals("ZZ" )) {
        	   scan = scanner.nextLine ( );
            try {
                int i = Integer.parseInt(scan);       
               if (numProducts == 0) {
                    numProducts=i;                  
                } else 
                if(numProducts > 0 && numSurveys == 0 ) {                 
                    numSurveys=i;  
                }              
            } catch (NumberFormatException e) {                
                slist3.add(scan);
               
            }
                   
        }           
          processScannedInput = new ProcessScannedInput();
          processScannedInput.accept(numProducts, numSurveys, slist3);
        scanner.close();
        }
    
}


