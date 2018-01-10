# barclaymarketingdesign
Barclays bank design coding challenge
Welcome to the barclaymarketingdesign wiki!

/** input consists of a number of products, followed by each Product's supply and demand parameters.
 **  followed by a number of surveyed prices, followed by competitor prices.
 ** 
 **   2
 **   flashdrive H H
 **   ssd L H
 **   55

 **   flashdrive X 1.0s
 **    ssd X 10.0
 **   flashdrive Y 0.9
 **    flashdrive Z 1.1
 **    ssd Y 12.5
 **/

/**
 * Business Rules
 * If Supply is High and Demand is High,
 * Product is sold at same price as chosen price. If Supply is Low and Demand is
 * Low, Product is sold at 10 % more than chosen price. If Supply is Low and
 * Demand is High, Product is sold at 5 % more than chosen price. If Supply is
 * High and Demand is Low, Product is sold at 5 % less than chosen price.
 * 
 * Prices less than 50% of average price is treated as promotion and not
 * considered. Prices more than 50% of average price is treated as data errors
 * and not considered.
 * 
 * 
 */
