package work.Utils;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class BitMap {
        private AtomicIntegerArray safeBitsMap;
        public BitMap(long length) {
            this.safeBitsMap= new AtomicIntegerArray((int) ((length >> 5) + ((length & 31) > 0 ? 1 : 0)));
        }
        public int getBit(long index) {
            int intData = safeBitsMap.get((int) ((index - 1) >> 5));
            int offset = (int) ((index - 1) & 31);
            return intData >> offset & 0x01;
        }
        public void setBit(long index) {
            int belowIndex = (int) ((index - 1) >> 5);
            int offset = (int) ((index - 1) & 31);
            int inData = safeBitsMap.get(belowIndex);
            safeBitsMap.set(belowIndex,inData | (0x01 << offset));
        }
    }

