package shaparenko.task;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        int arr[] = {1,2,3};

        List<DataRow<Integer, String>> leftRowList = new ArrayList<>();
        leftRowList.add(new DataRow<>(0, "Ukraine"));
        leftRowList.add(new DataRow<>(1, "Germany"));
        leftRowList.add(new DataRow<>(2, "France"));
        leftRowList.add(new DataRow<>(5, "arr"));

        List<DataRow<Integer, String>> rightRowList = new ArrayList<>();
        rightRowList.add(new DataRow<>(0, "Kyiv"));
        rightRowList.add(new DataRow<>(1, "Berlin"));
        rightRowList.add(new DataRow<>(5, "Budapest"));
        rightRowList.add(new DataRow<>(2, "2"));
        rightRowList.add(new DataRow<>(4, "4"));
        rightRowList.add(new DataRow<>(6, "6"));

        System.out.println("InnerJoin");
        InnerJoinOperation innerJoin = new InnerJoinOperation();
        System.out.println(innerJoin.join(leftRowList, rightRowList).toString());

        System.out.println("LeftJoin");
        LeftJoinOperation leftJoin = new LeftJoinOperation();
        System.out.println(leftJoin.join(leftRowList, rightRowList));

        System.out.println("RightJoin");
        RightJoinOperation rightJoin = new RightJoinOperation();
        System.out.println(rightJoin.join(leftRowList, rightRowList));
    }
}
