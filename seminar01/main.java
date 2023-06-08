package seminar01;

public class main {
    public static void main(String[] args) {

                hotdrink cocoalarge = new cocoa("Big Cococa with Marshmallows", 300, 400, 50);
                hotdrink espresso = new coffee("Espresso", 150, 30, 80);
                hotdrink sweettea = new tea("Black Sweet Tea with Milk", 200, 250, 60);
                
                vendingmachine hotdrinkvending = new hotdrinkvendingmachine();
        
                hotdrinkvending.addproduct(cocoalarge);
                hotdrinkvending.addproduct(espresso);
                hotdrinkvending.addproduct(sweettea);
        
                System.out.println(hotdrinkvending.getproduct("Espresso"));
                System.out.println(hotdrinkvending.getproduct("Black Sweet Tea with Milk", 250, 60));
            }
}
