import java.util.*;
public class FenwickTree {

    private final int[] btree;

    public FenwickTree(int size) {
        this.btree = new int[size];
    }

    public FenwickTree(ArrayList<Integer> initValues) {
        this(initValues.size());
        for (int i = 0; i < initValues.size(); i++) {
            setValue(i, initValues.get(i));

        }
    }

    public long get(int index) {
        long result = getSum(index);

        return index > 0 ? result - getSum(index - 1) : result;
    }

    public void setValue(int index, int value) {
        long difference = value - get(index);
        for (; index < btree.length; index = (index | (index+1)))
            btree[index] += difference;
    }

    public long getSum(int from, int to) {
        return getSum(to) - getSum(from - 1);
    }

    public long getSum(int to) {
        long result = 0;
        while (to >= 0) {
            result += btree[to];
            if (to == 0) {
                break;
            }
            to &= to + 1;
            to--;
        }
        return result;
    }
    public String toString(){
        return Arrays.toString(Arrays.copyOf(btree, btree.length));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int changes = sc.nextInt();
        int population = sc.nextInt();
        FenwickTree tree = new FenwickTree(n);
        for (int i = 0; i < changes; i++) {
            int index = sc.nextInt();
            int value = sc.nextInt();
            tree.setValue(index, value);
        }
        for (int i = 0; i < population; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            System.out.println(tree.getSum(from, to));
        }
    }
}