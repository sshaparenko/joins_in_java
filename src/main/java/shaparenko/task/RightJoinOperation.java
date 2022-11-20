package shaparenko.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RightJoinOperation implements JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> {

    // this method implements addition by right join rule
    private void addElementByRightJoin(DataRow<Integer, String> leftRow, DataRow<Integer, String> rightRow, List<JoinedDataRow<Integer, String, String>> joinedRowList) {
        if (leftRow.getIndex() == rightRow.getIndex()) {
            joinedRowList.add(new JoinedDataRow<>(leftRow.getIndex(), leftRow.getName(), rightRow.getName()));
        } else if (leftRow.getIndex() != rightRow.getIndex()) {
            joinedRowList.add(new JoinedDataRow<>(rightRow.getIndex(), null, rightRow.getName()));
        }
    }

    public Collection<JoinedDataRow<Integer, String, String>> join(Collection<DataRow<Integer, String>> leftCollection, Collection<DataRow<Integer, String>> rightCollection) {

        List<JoinedDataRow<Integer, String, String>> joinedRowList = new ArrayList<>();

        Iterator<DataRow<Integer, String>> leftIterator = leftCollection.iterator();
        Iterator<DataRow<Integer, String>> rightIterator = rightCollection.iterator();

        // Execute the loop while there is an elements
        while (leftIterator.hasNext() && rightIterator.hasNext()) {
            DataRow<Integer, String> leftRow = leftIterator.next();
            DataRow<Integer, String> rightRow = rightIterator.next();

            if (leftRow == null) {
                // While there is a null value in left row => remove it and take the next one till it will be not null
                while (leftRow == null) {
                    leftIterator.remove();
                    leftRow = leftIterator.next();
                }
                // If value of both right and left row are not null => add them to the list by right join rule
                if (rightRow != null) {
                    addElementByRightJoin(leftRow, rightRow, joinedRowList);
                }
            } else if (rightRow == null) {
                // If the right row element is null => execute while loop and remove the right row element till it will be not null
                while (rightRow == null) {
                    rightIterator.remove();
                    rightRow = rightIterator.next();
                }
                // add elements to the list by right join rule
                addElementByRightJoin(leftRow, rightRow, joinedRowList);
            } else {
                addElementByRightJoin(leftRow, rightRow, joinedRowList);
            }
        }
        return joinedRowList;
    }
}
