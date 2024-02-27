package AccessorMethods;

public class FindLongestProject {
    private String name;
    private int mounth_count;

    public FindLongestProject() {
        this.name = name;
        this.mounth_count = mounth_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthCount() {
        return mounth_count;
    }

    public void setMonthCount(int monthCount) {
        this.mounth_count = monthCount;
    }

    @Override
    public String toString() {
        return "FindLongestProject{" +
                "name='" + name + '\'' +
                ", mounth_count=" + mounth_count +
                '}';
    }
}
