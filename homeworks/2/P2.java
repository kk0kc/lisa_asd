import javafx.util.*;

public class P2 {
    public static <T> Pair<Integer,Integer> findCycle(Lst<T> lst) {
        Lst <T> p1 = lst;
        Lst <T> p2 = lst;
        int count = 1;
        int countCycle = 1;
        Lst<T> p = lst;
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            count++;
            if (p2 != null) {
                p2 = p2.next;
            }
            if (p1 == p2) {
                break;
            }
        }
        if (p2 == null) {
            return new Pair<>(count, 0);
        }
        while (lst != p2) {
            countCycle++;
            lst = lst.next;
            p2 = p2.next;
        }

        return new Pair<>(count - countCycle,countCycle);
    }
//    public static void main(String[] args) {
//        Lst<Integer> p = new Lst<Integer>(12,Lst.cons(3,Lst.cons(5, null)));
//        p.next.next.next = p.next;
//        System.out.println(findCycle(p));
//    }

}
