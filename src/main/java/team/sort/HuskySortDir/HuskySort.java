package team.sort.HuskySortDir;


import team.MingZi;
import team.sort.HuskySortDir.HuskySortCoder.Coder;
import team.sort.HuskySortDir.HuskySortCoder.EnglishCoder;
import team.sort.Sort;


import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.binarySearch;

public class HuskySort implements Sort {

    private static final int BITS_LONG = 64;
    private static final int BIT_WIDTH_ENGLISH = 6;
    private static final int MAX_LENGTH_ENGLISH = BITS_LONG / BIT_WIDTH_ENGLISH;

    private MingZi[] data;
    private final boolean mayBeSorted;
    private final boolean useInsertionSort;
    private Coder huskyCoder;

    public HuskySort(final boolean mayBeSorted, final boolean useInsertionSort){
        this.mayBeSorted = mayBeSorted;
        this.useInsertionSort = useInsertionSort;
        this.huskyCoder = new EnglishCoder(MAX_LENGTH_ENGLISH);
    }
    public HuskySort(final boolean mayBeSorted, final boolean useInsertionSort, Coder coder){
        this.mayBeSorted = mayBeSorted;
        this.useInsertionSort = useInsertionSort;
        this.huskyCoder = coder;
    }

    @Override
    public void run() {
        sort();
    }

    @Override
    public MingZi[] getData(){
        return this.data;
    }
    @Override
    public void setData(MingZi[] data){
        this.data = data;
    }
    @Override
    public void preWork() {
        for(MingZi n:this.data){
            n.toPinYin();
        }
    }
    public void sort(){
        // NOTE: we start with a random shuffle
        // This is necessary if we might be sorting a pre-sorted array. Otherwise, we usually don't need it.
        if (mayBeSorted) Collections.shuffle(Arrays.asList(data));
        // NOTE: First pass where we code to longs and sort according to those.
        huskyCoder.Encode(data);
        final long[] longs = huskyCoder.longs;
        introSort(data, longs, 0, longs.length, 2 * floor_lg(data.length));

        // NOTE: Second pass (if required) to fix any remaining inversions.
        if (huskyCoder.perfect)
            return;
        if (useInsertionSort)
            HuskyInsertionSort.sort(data);
        else
            Arrays.sort(data);
    }


    // CONSIDER invoke method in IntroSort
    private static int floor_lg(final int a) {
        return (int) (Math.floor(Math.log(a) / Math.log(2)));
    }

    private static final int sizeThreshold = 16;

    // TEST
    @SuppressWarnings({"UnnecessaryLocalVariable"})
    private void introSort(final MingZi[] objects, final long[] longs, final int from, final int to, final int depthThreshold) {
        // CONSIDER merge with IntroHuskySort
        if (to - from <= sizeThreshold + 1) {
            insertionSort(objects, longs, from, to);
            return;
        }
        if (depthThreshold == 0) {
            heapSort(objects, longs, from, to);
            return;
        }

        final int lo = from;
        final int hi = to - 1;

        if (longs[hi] < longs[lo]) swap(objects, longs, lo, hi);

        int lt = lo + 1, gt = hi - 1;
        int i = lo + 1;
        while (i <= gt) {
            if (longs[i] < longs[lo]) swap(objects, longs, lt++, i++);
            else if (longs[hi] < longs[i]) swap(objects, longs, i, gt--);
            else i++;
        }
        swap(objects, longs, lo, --lt);
        swap(objects, longs, hi, ++gt);
        introSort(objects, longs, lo, lt, depthThreshold - 1);
        if (longs[lt] < longs[gt]) introSort(objects, longs, lt + 1, gt, depthThreshold - 1);
        introSort(objects, longs, gt + 1, hi + 1, depthThreshold - 1);
    }

    // TEST
    private void heapSort(final MingZi[] objects, final long[] longs, final int from, final int to) {
        // CONSIDER removing these size checks. They haven't really been tested.
        if (to - from <= sizeThreshold + 1) {
            insertionSort(objects, longs, from, to);
            return;
        }
        final int n = to - from;
        for (int i = n / 2; i >= 1; i = i - 1) {
            downHeap(objects, longs, i, n, from);
        }
        for (int i = n; i > 1; i = i - 1) {
            swap(objects, longs, from, from + i - 1);
            downHeap(objects, longs, 1, i - 1, from);
        }
    }

    // TEST
    private void downHeap(final MingZi[] objects, final long[] longs, int i, final int n, final int lo) {
        final long d = longs[lo + i - 1];
        final MingZi od = objects[lo + i - 1];
        int child;
        while (i <= n / 2) {
            child = 2 * i;
            if (child < n && longs[lo + child - 1] < longs[lo + child]) child++;
            if (d >= longs[lo + child - 1]) break;
            longs[lo + i - 1] = longs[lo + child - 1];
            objects[lo + i - 1] = objects[lo + child - 1];
            i = child;
        }
        longs[lo + i - 1] = d;
        objects[lo + i - 1] = od;
    }

    void insertionSort(final MingZi[] objects, final long[] longs, final int from, final int to) {
        for (int i = from + 1; i < to; i++)
            for (int j = i; j > from && longs[j] < longs[j - 1]; j--)
                swap(objects, longs, j, j - 1);
    }

    /**
     * Regular swap of elements at indexes i and j, not necessarily adjacent.
     * However, for insertion sort, they will always be adjacent.
     *
     * @param xs    the X array.
     * @param longs the long array.
     * @param i     the index of one element to be swapped.
     * @param j     the index of the other element to be swapped.
     */
    private void swap(final MingZi[] xs, final long[] longs, final int i, final int j) {
        // Swap longs
        final long temp1 = longs[i];
        longs[i] = longs[j];
        longs[j] = temp1;
        // Swap xs
        final MingZi temp2 = xs[i];
        xs[i] = xs[j];
        xs[j] = temp2;
    }

    /**
     * Swap method for insertion sort which takes advantage of the known fact that the elements of the array
     * at indices less than i are in order.
     *
     * @param xs    the X array.
     * @param longs the long array.
     * @param i     the index of the element to be moved.
     */
    private void swapIntoSorted(final MingZi[] xs, final long[] longs, final int i) {
        int j = binarySearch(longs, 0, i, longs[i]);
        if (j < 0) j = -j - 1;
        if (j < i) swapInto(xs, longs, j, i);
    }

    /**
     * Swap method which uses half-swaps.
     *
     * @param xs    the X array.
     * @param longs the long array.
     * @param i     the index of the element to be moved.
     * @param j     the index of the destination of that element.
     */
    void swapInto(final MingZi[] xs, final long[] longs, final int i, final int j) {
        if (j > i) {
            final MingZi x = xs[j];
            System.arraycopy(xs, i, xs, i + 1, j - i);
            xs[i] = x;
            final long l = longs[j];
            System.arraycopy(longs, i, longs, i + 1, j - i);
            longs[i] = l;
        }
    }

}