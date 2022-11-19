package shaparenko.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InnerJoinOperation implements JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>>{

    public Collection<JoinedDataRow<Integer, String, String>> join(Collection<DataRow<Integer, String>> leftCollection, Collection<DataRow<Integer, String>> rightCollection) {

        List<JoinedDataRow<Integer, String, String>> joinedRowList = new ArrayList<>();

        for (DataRow<Integer, String> left: leftCollection){
            for (DataRow<Integer, String> right: rightCollection){
                if (left == null || right == null){
                    break;
                }
                if (left.getIndex() == right.getIndex()){
                    joinedRowList.add(new JoinedDataRow<>(left.getIndex(), left.getName(), right.getName()));
                }
            }
        }

        return joinedRowList;
    }

}
