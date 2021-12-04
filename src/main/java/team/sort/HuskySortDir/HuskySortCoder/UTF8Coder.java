package team.sort.HuskySortDir.HuskySortCoder;

import team.MingZi;

import java.nio.LongBuffer;

public class UTF8Coder extends Coder{
    private static final int BITS_LONG = 64;
    private static final int MASK_BYTE = 0xFF;
    private static final int BIT_WIDTH_UTF8 = 8;
    private static final int MAX_LENGTH_UTF8 = BITS_LONG / BIT_WIDTH_UTF8;
    private static final int MASK_UTF8 = MASK_BYTE;

    public UTF8Coder(final int maxLength){
        this.maxLength = maxLength;

    }
    @Override
    public void Encode(MingZi[] xs){
        boolean isPerfect = true;
        final long[] result = new long[xs.length];
        for (int i = 0; i < xs.length; i++) {
            final String x = xs[i].getHanZi();
            if (isPerfect) isPerfect = perfectForLength(x.length());
            result[i] = utf8ToLong(x);
        }
        this.longs = result;
    }
    public final boolean perfectForLength(final int length) {
        return length <= maxLength;
    }
    static long utf8ToLong(final String str) {
        // TODO Need to test that the mask value is correct. I think it might not be.
        return longArrayToLong(toUTF8Array(str), MAX_LENGTH_UTF8, BIT_WIDTH_UTF8, MASK_UTF8) >>> 1;
    }
    private static long longArrayToLong(final long[] xs, final int maxLength, final int bitWidth, final int mask) {
        final int length = Math.min(xs.length, maxLength);
        long result = 0;
        if (((~mask)) == 0)
            for (int i = 0; i < length; i++) result = result << bitWidth | xs[i];
        else
            for (int i = 0; i < length; i++) result = result << bitWidth | xs[i] & mask;
        result = result << (bitWidth * (maxLength - length));
        return result;
    }
    private static long[] toUTF8Array(final String str) {
        final int length = str.length();
        final LongBuffer byteBuffer = LongBuffer.allocate(length << 2);
        int count = 0;
        final char[] codes = str.toCharArray();
        for (int i = 0; i < length; i++) {
            final char code = codes[i];
            if (code < 0x80) {
                count++;
                byteBuffer.put(code);
            } else if (code < 0x800) {
                count += 2;
                byteBuffer.put(0xC0 | (code >> 6));
                byteBuffer.put(0x80 | (code & 0x3F));
            } else if (code < 0xD800 || code >= 0xE000) {
                count += 3;
                byteBuffer.put(0xE0 | (code >> 12));
                byteBuffer.put(0x80 | ((code >> 6) & 0x3F));
                byteBuffer.put(0x80 | (code & 0x3F));
            } else {
                i++;
                final int tempCode = 0x10000 + (((code & 0x3FF) << 10) | codes[i] & 0x3FF);
                count += 4;
                byteBuffer.put(0xF0 | (tempCode >> 18));
                byteBuffer.put(0x80 | ((tempCode >> 12) & 0x3F));
                byteBuffer.put(0x80 | ((tempCode >> 6) & 0x3F));
                byteBuffer.put(0x80 | (tempCode & 0x3F));
            }
        }
        final long[] result = new long[count];
        byteBuffer.rewind();
        byteBuffer.get(result);
        return result;
    }
    private final int maxLength;
}
