package shaparenko.task;

import java.util.Collection;
/*
D1 - is a generic type of the elements in the left collection
D2 - is a generic type of the elements in the right collection
R - is a generic type of the elements in the resulting collection
*/
public interface JoinOperation<D1, D2, R>{
    Collection<R> join(Collection<D1> leftCollection, Collection<D2> rightCollection);
}
