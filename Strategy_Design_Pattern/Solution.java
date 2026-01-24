package Strategy_Design_Pattern;

interface DiscountStratergy {
    int applyDiscount(int amount);
}


class Regular implements DiscountStratergy {
    public int applyDiscount(int amount){
        return amount - ((amount* 30 )/ 100);
    }
}

class Primium implements DiscountStratergy {
    public int applyDiscount(int amount){
        return amount - ((amount* 50 )/ 100);
    }
}

class SpecialOffer implements DiscountStratergy {
    public int applyDiscount(int amount){
        return amount - ((amount* 90 )/ 100);
    }
}

class DiscountServicer {

    private DiscountStratergy stratergy; 

    DiscountServicer( DiscountStratergy  stratergy){
            this.stratergy = stratergy;
    }
    public int calculateDiscont(int amount){
        return stratergy.applyDiscount(amount);
    }
}

public class Solution {
  
    public static void main(String[] args) {
    DiscountStratergy stratergy = new Regular();
    DiscountServicer servicer = new DiscountServicer(stratergy);
    int result = servicer.calculateDiscont(100);
    System.out.println(result);
    }
}