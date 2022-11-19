package shaparenko.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RightJoinOperation implements JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>>{

    private void addElementByRightJoin(DataRow<Integer, String> leftRow, DataRow<Integer, String> rightRow){

    }
    public Collection<JoinedDataRow<Integer, String, String>> join(Collection<DataRow<Integer, String>> leftCollection, Collection<DataRow<Integer, String>> rightCollection) {

        List<JoinedDataRow<Integer, String, String>> joinedRowList = new ArrayList<>();

        Iterator<DataRow<Integer, String>> leftIterator = leftCollection.iterator();
        Iterator<DataRow<Integer, String>> rightIterator = rightCollection.iterator();

        while(leftIterator.hasNext() && rightIterator.hasNext()){
            DataRow<Integer, String> leftRow = leftIterator.next();
            DataRow<Integer, String> rightRow = rightIterator.next();

            if (leftRow == null) {
                while (leftRow == null) {
                    leftIterator.remove();
                    leftRow = leftIterator.next();
                }
                if (rightRow != null) {
                    if (leftRow.getIndex() == rightRow.getIndex()){
                        joinedRowList.add(new JoinedDataRow<>(leftRow.getIndex(), leftRow.getName(), rightRow.getName()));
                    } else if (leftRow.getIndex() != rightRow.getIndex()) {
                        joinedRowList.add(new JoinedDataRow<>(rightRow.getIndex(), null, rightRow.getName()));
                    }
                }
            } else if (rightRow == null) {
                while (rightRow == null) {
                    rightIterator.remove();
                    rightRow = rightIterator.next();
                }

                if (leftRow.getIndex() == rightRow.getIndex()){
                    joinedRowList.add(new JoinedDataRow<>(leftRow.getIndex(), leftRow.getName(), rightRow.getName()));
                } else if (leftRow.getIndex() != rightRow.getIndex()) {
                    joinedRowList.add(new JoinedDataRow<>(rightRow.getIndex(), null, rightRow.getName()));
                }

            } else {

                if (leftRow.getIndex() == rightRow.getIndex()){
                    joinedRowList.add(new JoinedDataRow<>(leftRow.getIndex(), leftRow.getName(), rightRow.getName()));
                } else if (leftRow.getIndex() != rightRow.getIndex()) {
                    joinedRowList.add(new JoinedDataRow<>(rightRow.getIndex(), null, rightRow.getName()));
                }

            }
        }
        return joinedRowList;
    }
}
