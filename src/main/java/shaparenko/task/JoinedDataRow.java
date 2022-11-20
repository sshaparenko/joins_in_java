package shaparenko.task;

import java.util.Objects;

public class JoinedDataRow<K extends Comparable<K>, V1, V2>{
    private K index;
    private V1 leftName;
    private V2 rightName;

    public JoinedDataRow(){

    }

    public JoinedDataRow(K index, V1 leftName, V2 rightName){
        this.index = index;
        this.leftName = leftName;
        this.rightName = rightName;
    }


    @Override
    public String toString() {
        return "JoinedDataRow{" +
                "index=" + index +
                ", leftName='" + leftName + '\'' +
                ", rightName='" + rightName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinedDataRow<?, ?, ?> that = (JoinedDataRow<?, ?, ?>) o;
        return Objects.equals(index, that.index) && Objects.equals(leftName, that.leftName) && Objects.equals(rightName, that.rightName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, leftName, rightName);
    }
}
