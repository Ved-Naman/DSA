class SmallestInfiniteSet {

    int nextNumber;
    PriorityQueue<Integer> returnedPile;
    HashSet<Integer> isReturned;

    public SmallestInfiniteSet() {
        nextNumber = 1;
        returnedPile = new PriorityQueue<>();
        isReturned = new HashSet<>();
    }

    public int popSmallest() {
        if (!returnedPile.isEmpty()) {
            int smallest = returnedPile.poll();
            isReturned.remove(smallest);
            return smallest;
        }

        int smallest = nextNumber;
        nextNumber++;
        return smallest;
    }

    public void addBack(int num) {
        if (num < nextNumber && !isReturned.contains(num)) {
            returnedPile.add(num);
            isReturned.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */