public class PolyTest {
    public static void main(String[] args) {
        PolyNode polynomial1 = Polynomials.ReadPoly();
        PolyNode polynomial2 = Polynomials.ReadPoly();
        PolyNode polyProduct = Polynomials.multiply(polynomial1, polynomial2);
        Polynomials.printPoly(polyProduct);
        System.out.println("");
        PolyNode polySum = Polynomials.add(polynomial1,polynomial2);
        Polynomials.printPoly(polySum);
    }
}
