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
        long oldValue = get(index);
        long difference = value - oldValue;
        while (index < btree.length) {
            btree[index] += difference;
            index |= index + 1;
        }
    }

    public long getSum(int fromIndexInclusive, int toIndexInclusive) {
        if (fromIndexInclusive > toIndexInclusive) {
            throw new IllegalArgumentException("from index more than to index");
        }
        long leftSum = fromIndexInclusive > 0 ? getSum(fromIndexInclusive - 1) : 0;
        return getSum(toIndexInclusive) - leftSum;
    }

    public long getSum(int toIndexInclusive) {
        if (toIndexInclusive >= btree.length) {
            throw new IllegalArgumentException("to index more than btree length");
        }
        long result = 0;
        while (toIndexInclusive >= 0) {
            result += btree[toIndexInclusive];
            if (toIndexInclusive == 0) {
                break;
            }
            toIndexInclusive &= toIndexInclusive + 1;
            toIndexInclusive--;
        }
        return result;
    }
    public String toString(){
        return Arrays.toString(Arrays.copyOf(btree, btree.length));
    }
//    public static void main(String[] args){
//        ArrayList val =  new ArrayList(Arrays.asList(1,3,4,5,6));
//        System.out.println(val);
//        int n = val.size();
//        FenwickTree btree = new FenwickTree(val);
//        System.out.println(btree);
//        System.out.println(btree.getSum(2,4));
//        btree.setValue(3, 10);
//        System.out.println(btree.getSum(2,4));
//        System.out.println(btree);
//    }
}