
package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

@Stateful
public class ListElementsImpl implements ListElementsRemote{
    List<Integer> values = new ArrayList<>();

    @Override
    public void addElement(int e) {
        values.add(e);
    }

    @Override
    public void removeElement(int e) {
        /*remove method has 2 implementations.
        remove(int e) here e will be the index of the array list.but i want to
        remove the element. so i used this way*/
        values.remove(new Integer(e));
    }

    @Override
    public List<Integer> getElements() {
        return values;
    }
}
