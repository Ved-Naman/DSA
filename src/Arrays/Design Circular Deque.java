class MyCircularDeque {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int k;

    public MyCircularDeque(int k) {
        this.k = k;
        arr = new int[k];
        size = 0;
        front = 0;
        rear = k - 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + k) % k;
        arr[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % k;
        arr[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % k;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + k) % k;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}