package shaparenko.task;

import java.util.Objects;

public class DataRow<K extends Comparable<K>, V> implements Comparable<DataRow>{
    private final K index;
    private final V name;

    public K getIndex() {
        return index;
    }

    public V getName() {
        return name;
    }

    public DataRow(K index, V name){
        this.index = index;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DataRow{" +
                "index=" + index +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRow<?, ?> dataRow = (DataRow<?, ?>) o;
        return Objects.equals(index, dataRow.index) && Objects.equals(name, dataRow.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name);
    }

    public int compareTo(DataRow o) {
        if (index == o.getIndex()){
            return 1;
        } else {
            return 0;
        }
    }
}
