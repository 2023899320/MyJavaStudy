public class ArrayQueue<T> {
    private final int maxSize;
    private int front;
    private int rear;
    private final T[] Queue;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.Queue = (T[]) new Object[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return (rear - front) == maxSize;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void add(T t) {
        if (rear + 1 == maxSize) {
            if (isFull()) {
                throw new RuntimeException("这里已经满员了");
            } else {
                tidy();
            }
        }
        Queue[++rear] = t;
    }

    public void tidy() {
        int size = rear - front;
        for (int i = 0; i < size; i++) {
            Queue[i] = Queue[maxSize - size + i];
            Queue[maxSize - size + i] = null;
        }
        front = -1;
        rear = rear - (maxSize - size);
    }

    public T get() {
        if (isEmpty()) {
            return null;
        }
        T result = Queue[++front];
        Queue[front] = null;
        return result;
    }

    public void show() {
        System.out.print("{");
        for (int i = 0; i < maxSize; i++) {
            if (i + 1 == maxSize) {
                System.out.print(Queue[i] + "}");
            } else {
                System.out.print(Queue[i] + ",");
            }
        }
    }

    public T showHead() {
        return Queue[front + 1];
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> integerQueue = new ArrayQueue<>(8);
        for (int i = 0; i < 5; i++) {
            integerQueue.add(i);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(integerQueue.get());
        }
        for (int i = 0; i < 4; i++) {
            integerQueue.add(i);
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(integerQueue.get());
        }
        integerQueue.show();


    }

}
