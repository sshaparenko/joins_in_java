package shaparenko.task;

import java.util.*;

public class LeftJoinOperation implements JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> {

    public Collection<JoinedDataRow<Integer, String, String>> join(Collection<DataRow<Integer, String>> leftCollection, Collection<DataRow<Integer, String>> rightCollection) {

        List<JoinedDataRow<Integer, String, String>> joinedRowList = new ArrayList<>();

        Iterator<DataRow<Integer, String>> leftIterator = leftCollection.iterator();
        Iterator<DataRow<Integer, String>> rightIterator = rightCollection.iterator();
        /*
         * Execute the loop while there is an elements
         * If an element of left data row is Null => remove it and take next element for leftRow variable
         * If an element of right data row is Null => remove it and take next element for rightRow variable
         * And then
         * */
        while (leftIterator.hasNext() && rightIterator.hasNext()) {
            DataRow<Integer, String> leftRow = leftIterator.next();
            DataRow<Integer, String> rightRow = rightIterator.next();
            if (leftRow == null) {
                while (leftRow == null) {
                    leftIterator.remove();
                    leftRow = leftIterator.next();
                }
                if (rightRow != null) {
                    if (leftRow.getIndex() == rightRow.getIndex()) {
                        joinedRowList.add(new JoinedDataRow<>(leftRow.getIndex(), leftRow.getName(), rightRow.getName()));
                    } else if (leftRow.getIndex() != rightRow.getIndex()) {
                        joinedRowList.add(new JoinedDataRow<>(leftRow.getIndex(), leftRow.getName(), null));
                    }
                }
            } else if (rightRow == null) {
                while (rightRow == null) {
                    rightIterator.remove();
                    rightRow = rightIterator.next();
                }

                if (leftRow.getIndex() == rightRow.getIndex()) {
                    joinedRowList.add(new JoinedDataRow<>(leftRow.getIndex(), leftRow.getName(), rightRow.getName()));
                } else if (leftRow.getIndex() != rightRow.getIndex()) {
                    joinedRowList.add(new JoinedDataRow<>(leftRow.getIndex(), leftRow.getName(), null));
                }

            } else {

                if (leftRow.getIndex() == rightRow.getIndex()) {
                    joinedRowList.add(new JoinedDataRow<>(leftRow.getIndex(), leftRow.getName(), rightRow.getName()));
                } else if (leftRow.getIndex() != rightRow.getIndex()) {
                    joinedRowList.add(new JoinedDataRow<>(leftRow.getIndex(), leftRow.getName(), null));
                }

            }
        }
        return joinedRowList;
    }
}
