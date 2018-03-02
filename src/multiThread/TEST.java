package multiThread;

import static sun.misc.Hashing.randomHashSeed;

/**
 * Created by GraceYang on 2018/1/28.
 */
public class TEST {
    private int hash(Object k) {
        final int hashSeed = randomHashSeed(this);
        int h = hashSeed;

        if ((0 != h) && (k instanceof String)) {
            return sun.misc.Hashing.stringHash32((String) k);
        }

        h ^= k.hashCode();

        // Spread bits to regularize both segment and index locations,
        // using variant of single-word Wang/Jenkins hash.
        h += (h <<  15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h <<   3);
        h ^= (h >>>  6);
        h += (h <<   2) + (h << 14);
        return h ^ (h >>> 16);
    }
}
