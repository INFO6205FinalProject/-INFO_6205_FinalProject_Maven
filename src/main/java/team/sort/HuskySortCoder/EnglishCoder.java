package team.sort.HuskySortCoder;

import team.MingZi;

public class EnglishCoder extends Coder{
    private static final int BITS_LONG = 64;
    private static final int MASK_SHORT = 0xFFFF;
    private static final int BIT_WIDTH_ENGLISH = 6;
    private static final int MAX_LENGTH_ENGLISH = BITS_LONG / BIT_WIDTH_ENGLISH;
    private static final int MASK_ENGLISH = 0x3F;

    public EnglishCoder(final int maxLength){
        this.maxLength = maxLength;

    }
    @Override
    public void Encode(MingZi[] xs){
        boolean isPerfect = true;
        final long[] result = new long[xs.length];
        for (int i = 0; i < xs.length; i++) {
            final String x = xs[i].getPinYin();
            if (isPerfect) isPerfect = perfectForLength(x.length());
            result[i] = englishToLong(x);
        }
        this.longs = result;
    }

    /**
     * Method to determine if this Husky Coder is perfect for a sequence of the given length.
     * If the result is false for a particular length, it implies that inversions will remain after the first pass of Husky Sort.
     * If the result is true for all actual lengths, then the second pass of Husky Sort would be superfluous.
     *
     * @param length the length of a particular String.
     * @return true if length <= maxLength.
     */
    public final boolean perfectForLength(final int length) {
        return length <= maxLength;
    }
    private static long englishToLong(final String str) {
        return stringToLong(str, MAX_LENGTH_ENGLISH, BIT_WIDTH_ENGLISH, MASK_ENGLISH);
    }
    private static long stringToLong(final String str, final int maxLength, final int bitWidth, final int mask) {
        final int length = Math.min(str.length(), maxLength);
        final int padding = maxLength - length;
        long result = 0L;
        if (((mask ^ MASK_SHORT) & MASK_SHORT) == 0)
            for (int i = 0; i < length; i++) result = result << bitWidth | str.charAt(i);
        else
            for (int i = 0; i < length; i++) result = result << bitWidth | str.charAt(i) & mask;
        result = result << bitWidth * padding;
        return result;
    }

    private final int maxLength;
}
