package shaparenko.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeftJoinOperationTest {

    @Test
    void join() {
        List<DataRow<Integer, String>> leftRowListTest = new ArrayList<>();
        leftRowListTest.add(new DataRow<>(0, "Ukraine"));
        leftRowListTest.add(new DataRow<>(1, "Germany"));
        leftRowListTest.add(new DataRow<>(2, "France"));

        List<DataRow<Integer, String>> rightRowListTest = new ArrayList<>();
        rightRowListTest.add(new DataRow<>(0, "Kyiv"));
        rightRowListTest.add(new DataRow<>(1, "Berlin"));
        rightRowListTest.add(new DataRow<>(3, "Budapest"));

        List<JoinedDataRow<Integer, String, String>> joinedRowList = new ArrayList<>();
        joinedRowList.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        joinedRowList.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
        joinedRowList.add(new JoinedDataRow<>(2, "France", null));

        Assertions.assertEquals(joinedRowList, new LeftJoinOperation().join(leftRowListTest, rightRowListTest));
    }

    @Test
    void nullObject(){
        List<DataRow<Integer, String>> leftRowListTest = new ArrayList<>();
        leftRowListTest.add(null);
        leftRowListTest.add(null);
        leftRowListTest.add(new DataRow<>(0, "Ukraine"));
        leftRowListTest.add(null);
        leftRowListTest.add(null);
        leftRowListTest.add(new DataRow<>(1, "Germany"));
        leftRowListTest.add(null);
        leftRowListTest.add(new DataRow<>(2, "France"));
        leftRowListTest.add(null);

        List<DataRow<Integer, String>> rightRowListTest = new ArrayList<>();
        leftRowListTest.add(null);
        leftRowListTest.add(null);
        rightRowListTest.add(new DataRow<>(0, "Kyiv"));
        leftRowListTest.add(null);
        leftRowListTest.add(null);
        rightRowListTest.add(new DataRow<>(1, "Berlin"));
        leftRowListTest.add(null);
        rightRowListTest.add(new DataRow<>(3, "Budapest"));
        leftRowListTest.add(null);

        List<JoinedDataRow<Integer, String, String>> joinedRowList = new ArrayList<>();
        joinedRowList.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        joinedRowList.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
        joinedRowList.add(new JoinedDataRow<>(2, "France", null));

        Assertions.assertEquals(joinedRowList, new LeftJoinOperation().join(leftRowListTest, rightRowListTest));
    }
}