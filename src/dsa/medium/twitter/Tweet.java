package dsa.medium.twitter;

public class Tweet {
    private int id;
    private int time;
    private Tweet next;

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public Tweet getNext() {
        return next;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setNext(Tweet next) {
        this.next = next;
    }

    public Tweet(int id, int timeStamp) {
        this.id = id;
        this.time = timeStamp;
    }
}
