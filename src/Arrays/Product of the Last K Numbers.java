class ProductOfNumbers {
    private List<Integer> stream;

    public ProductOfNumbers() {
        stream = new ArrayList<>();
    }

    public void add(int num) {
        stream.add(num);
    }

    public int getProduct(int k) {
        int product = 1;
        int n = stream.size();
        for (int i = n - 1; i >= n - k; i--) {
            product *= stream.get(i);
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */