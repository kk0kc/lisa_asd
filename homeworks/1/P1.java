
class Lst<T> {
    T val;
    Lst<T> next;

    public Lst(T val, Lst<T> next) {
        this.val = val;
        this.next = next;
    }

    public static <T> Lst<T> nil() { return null; }
    public static <T> Lst<T> cons(T head, Lst<T> tail) {
        return new Lst<>(head, tail);
    }

    public static <T> void print(Lst<T> lst) {
        Lst<T> p = lst;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    // Функция удаления всех чётных элементов
    // из списка
    public static Lst<Integer> removeEven(Lst<Integer> lst) {
        // сдвигаем начало списка, пока там чётные элементы
        Lst<Integer> p = lst;
        while (p != null && p.val % 2 == 0) {
            p = p.next;
        }
        // удаляем чётные элементы в середине списка
        Lst<Integer> q = p;
        while (q != null && q.next != null) {
            if (q.next.val % 2 == 0) {
                q.next = q.next.next;
            } else {
                q = q.next;
            }
        }
        return p;
    }
    public static <T> Lst<T> change12(Lst<T> lst) {
        Lst<T> p = lst;
        if (p != null && p.next != null) {
            Lst<T> a = p;               //a = 0 2 15 4
            Lst<T> b = a.next;          //b = 2 15 4
            a.next = b.next;            // 0 15 4 -> 2 0 15 4
            b.next = a;
            //p = b;

            Lst.print(p);
            Lst<T> o = b.next.next;
            b.next.next = change12(o);
            return b;
        } else { return p; }
    }
}

public class P1 {
    public static void main(String[] args) {

        Lst<Integer> lst = Lst.cons(0,
                Lst.cons(2,
                        Lst.cons(15,
                                Lst.cons(4, Lst.cons(9, Lst.cons(6, Lst.cons( 8, null)))
                                ))));
        Lst.print(lst);
        Lst.print(Lst.change12(lst));

    }
}