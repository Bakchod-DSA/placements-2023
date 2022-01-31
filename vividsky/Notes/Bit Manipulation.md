
**Golden Tricks**
1. x & (x-1) will clear the lowest set bit of x
   x | (x + 1) = x with the lowest cleared bit set.
2. _x & ~(x-1) (same as x & -x)_ extracts the lowest set bit of x (all others are clear).
   x | ~(x + 1) = extracts the lowest cleared bit of x (all others are set).
3. x & (x + (1 << n)) = x, with the run of set bits (possibly length 0) starting at bit n cleared.
4. x & ~(x + (1 << n)) = the run of set bits (possibly length 0) in x, starting at bit n.
7. x | (x - (1 << n)) = x, with the run of cleared bits (possibly length 0) starting at bit n set.
8. x | ~(x - (1 << n)) = the lowest run of cleared bits (possibly length 0) in x, starting at bit n are the only clear bits.

* **Integer.highestOneBit(x)** -> return int with all bit cleared except the most significant set bit
* **Integer.lowestOneBit(x)** -> return int with all bit cleared except the least significant set bit