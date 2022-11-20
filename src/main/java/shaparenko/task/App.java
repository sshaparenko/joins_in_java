package shaparenko.task;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<DataRow<Integer, String>> leftRowList = new ArrayList<>();
        leftRowList.add(new DataRow<>(0, "Ukraine"));
        leftRowList.add(new DataRow<>(1, "Germany"));
        leftRowList.add(new DataRow<>(2, "France"));


        List<DataRow<Integer, String>> rightRowList = new ArrayList<>();
        rightRowList.add(new DataRow<>(0, "Kyiv"));
        rightRowList.add(new DataRow<>(1, "Berlin"));
        rightRowList.add(new DataRow<>(3, "Budapest"));

        System.out.println("Left Row:");
        System.out.println("--------------");
        System.out.println(leftRowList);
        System.out.println();

        System.out.println("Right Row:");
        System.out.println("--------------");
        System.out.println(rightRowList);
        System.out.println();

        System.out.println("InnerJoin:");
        System.out.println("--------------");
        InnerJoinOperation innerJoin = new InnerJoinOperation();
        System.out.println(innerJoin.join(leftRowList, rightRowList).toString());
        System.out.println();

        System.out.println("LeftJoin:");
        System.out.println("--------------");
        LeftJoinOperation leftJoin = new LeftJoinOperation();
        System.out.println(leftJoin.join(leftRowList, rightRowList));
        System.out.println();

        System.out.println("RightJoin:");
        System.out.println("--------------");
        RightJoinOperation rightJoin = new RightJoinOperation();
        System.out.println(rightJoin.join(leftRowList, rightRowList));
        System.out.println();
    }
}
