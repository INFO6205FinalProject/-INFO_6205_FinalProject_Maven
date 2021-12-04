package team.sort.HuskySortDir.HuskySortCoder;

import team.MingZi;

public class UnicodeCoder extends Coder{
    private static final int BITS_LONG = 64;
    private static final int BITS_BYTE = 8;
    private static final int BYTES_LONG = BITS_LONG / BITS_BYTE;
    private static final int MASK_BYTE = 0xFF;
    private static final int MASK_SHORT = 0xFFFF;

    private static final int BIT_WIDTH_ASCII = 7;
    private static final int MAX_LENGTH_ASCII = BITS_LONG / BIT_WIDTH_ASCII;
    private static final int MASK_ASCII = 0x7F;

    private static final int BIT_WIDTH_ENGLISH = 6;
    private static final int MAX_LENGTH_ENGLISH = BITS_LONG / BIT_WIDTH_ENGLISH;
    private static final int MASK_ENGLISH = 0x3F;

    private static final int BIT_WIDTH_UNICODE = 16;
    private static final int MAX_LENGTH_UNICODE = BITS_LONG / BIT_WIDTH_UNICODE;
    private static final int MASK_UNICODE = MASK_SHORT;

    private static final int BIT_WIDTH_UTF8 = 8;
    private static final int MAX_LENGTH_UTF8 = BITS_LONG / BIT_WIDTH_UTF8;
    private static final int MASK_UTF8 = MASK_BYTE;

    public UnicodeCoder(final int maxLength){
        this.maxLength = maxLength;

    }
    @Override
    public void Encode(MingZi[] xs){
        boolean isPerfect = true;
        final long[] result = new long[xs.length];
        for (int i = 0; i < xs.length; i++) {
            final String x = xs[i].getHanZi();
            if (isPerfect) isPerfect = perfectForLength(x.length());
            result[i] = unicodeToLong(x);
        }
        this.longs = result;
    }
    public final boolean perfectForLength(final int length) {
        return length <= maxLength;
    }
    private static long unicodeToLong(final String str) {
        return stringToLong(str, MAX_LENGTH_UNICODE, BIT_WIDTH_UNICODE, MASK_UNICODE) >>> 1;
        // CONSIDER an alternative coding scheme which would use str.getBytes(Charset.forName("UTF-16"));
        // ignore the first two bytes and take the next eight bytes (or however many there are) and then pack them byte by byte into the long.
//        int startingPos = 2; // We need to account for the BOM
//        return stringToBytesToLong(str, MAX_LENGTH_UNICODE, StandardCharsets.UTF_16, startingPos) >>> 1;
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
