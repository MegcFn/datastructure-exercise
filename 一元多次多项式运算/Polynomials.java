import java.util.Scanner;

public class Polynomials {

    // 读取多项式
    public static PolyNode ReadPoly() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PolyNode head = new PolyNode();
        PolyNode rear = head;
        while (N-- > 0) {
            int coe = sc.nextInt();
            int exp = sc.nextInt();
            rear.link = new PolyNode(coe, exp);
            rear = rear.link;
        }
        //sc.close();
        head = head.link;
        return head;
    }

    // 多项式相加
    public static PolyNode add(PolyNode p1, PolyNode p2) {
        PolyNode ptr1 = p1, ptr2 = p2;
        PolyNode head = new PolyNode();
        PolyNode rear = head;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.exponent == ptr2.exponent) {
                int newCof = ptr1.coefficient + ptr2.coefficient;
                if (newCof != 0) {
                    rear.link = new PolyNode(newCof, ptr1.exponent);
                    rear = rear.link;
                }
                ptr1 = ptr1.link;
                ptr2 = ptr2.link;
            } else if (ptr1.exponent > ptr2.exponent) {
                rear.link = ptr1;
                rear = rear.link;
                ptr1 = ptr1.link;
            } else {
                rear.link = ptr2;
                rear = rear.link;
                ptr2 = ptr2.link;
            }
        }

        if (ptr1 != null) {
            rear.link = ptr1;
        }
        if (ptr2 != null) {
            rear.link = ptr2;
        }
        head = head.link;
        return head;
    }

    // 多项式相乘
    public static PolyNode multiply(PolyNode p1, PolyNode p2) {
        if (p1 == null || p2 == null)
            return null;

        PolyNode head = new PolyNode();
        PolyNode rear = head;
        PolyNode ptr1 = p1, ptr2 = p2;
        while (ptr2 != null) {
            rear.link = new PolyNode(ptr1.coefficient * ptr2.coefficient,
                    ptr1.exponent + ptr2.exponent);
            ptr2 = ptr2.link;
        }
        while (ptr1 != null) {
            ptr2 = p2;
            rear = head;
            while (ptr2 != null) {
                int curCof = ptr1.coefficient * ptr2.coefficient;
                int curExp = ptr1.exponent + ptr2.exponent;
                while (rear.link != null && rear.link.exponent > curExp) {
                    rear = rear.link;
                }
                if (rear.link != null && rear.link.exponent == curExp) {
                    if (rear.link.coefficient + curCof == 0) {
                        rear.link = rear.link.link;
                    } else {
                        rear.link.coefficient += curCof;
                    }
                } else {
                    PolyNode tmp = new PolyNode(curCof, curExp);
                    tmp.link = rear.link;
                    rear.link = tmp;
                    rear = rear.link;
                }
                ptr2 = ptr2.link;
            }
            ptr1 = ptr1.link;
        }
        head = head.link;
        return head;
    }

    // 打印多项式
    public static void printPoly(PolyNode polynomial) {
        if (polynomial == null) {
            System.out.println("0 0");
            return;
        }
        boolean flag = true;
        while (polynomial != null) {
            if (flag) {
                flag = false;
            } else {
                System.out.print(" ");
            }
            System.out.print(polynomial.coefficient + " " + polynomial.exponent);
            polynomial = polynomial.link;
        }
    }
}
