public class PolyNode {
    
    public int coefficient;
    public int exponent;
    public PolyNode link;

    PolyNode(){
        link = null;
    }

    PolyNode(int coefficient,int exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
        link = null;
    }
}
