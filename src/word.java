public class word {
    private int count;
    private String name;

    public word(String name, int i) {
        this.count = i;
        this.name = name;
    }

    public void addOne() {
        this.count++;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
