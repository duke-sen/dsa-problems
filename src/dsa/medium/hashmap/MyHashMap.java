package dsa.medium.hashmap;


public class MyHashMap {
    private int SIZE_OF_BUCKETS = 10;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;
    private Node[] buckets;
    private int size;

    public MyHashMap() {
        this.buckets = new Node[SIZE_OF_BUCKETS];
        size = 0;
    }

    public void put(int key, int value) {
        int bucketIdxOfThisEle = getIndex(key, SIZE_OF_BUCKETS);
        Node prevEle = findElement(bucketIdxOfThisEle, key);

        // Element has not been found
        if (prevEle.next == null) {
            prevEle.next = new Node(key, value);
            size++;

            if ((double) size / SIZE_OF_BUCKETS >= LOAD_FACTOR_THRESHOLD) {
                resize();
            }
        }
        else {
            prevEle.next.value = value;
        }
    }
    public void remove(int key) {
        int bucketIdxOfThisEle = getIndex(key, SIZE_OF_BUCKETS);
        Node prevEle = findElement(bucketIdxOfThisEle, key);
        if (prevEle.next != null) {
            prevEle.next = prevEle.next.next;
            size--;
        }
    }

    public int get(int key) {
        int bucketIdxOfThisEle = getIndex(key, SIZE_OF_BUCKETS);
        Node prevEle = findElement(bucketIdxOfThisEle, key);

        if (prevEle.next == null)
            return -1;
        return prevEle.next.value;
    }

    private Node findElement(int index, int key) {
        if (buckets[index] == null) {
            buckets[index] = new Node(-1, -1);
            return buckets[index];
        }
        Node prev = buckets[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }

    private int getIndex(int key, int bucketSize) {
        return key % bucketSize;
    }

    private void resize() {
        // SIZE_OF_BUCKETS *= 2;
        Node[] newBuckets = new Node[SIZE_OF_BUCKETS * 2];

        for (Node currentBucket : buckets) {

            while (currentBucket != null && currentBucket.next != null) {
                int newBucketIdx = getIndex(currentBucket.next.key, SIZE_OF_BUCKETS * 2);
                Node temp = currentBucket.next;
                currentBucket.next = temp.next;

                temp.next = null;

                if (newBuckets[newBucketIdx] == null) {
                    newBuckets[newBucketIdx] = new Node(-1, -1);
                }
                Node prev = newBuckets[newBucketIdx];
                while (prev.next != null) {
                    prev = prev.next;
                }
                prev.next = temp;
            }
        }

        SIZE_OF_BUCKETS *= 2;
        buckets = newBuckets;
    }



}
