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
        ArrayList val =  new ArrayList(Arrays.asList(1,3,4,5,6));
        System.out.println(val);
        int n = val.size();
        FenwickTree btree = new FenwickTree(val);
        System.out.println(btree);
        System.out.println(btree.getSum(2,4));
        btree.setValue(3, 10);
        System.out.println(btree.getSum(2,4));
        System.out.println(btree);
    }
}