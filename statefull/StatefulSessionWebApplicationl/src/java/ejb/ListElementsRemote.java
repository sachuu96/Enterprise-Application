
package ejb;

import java.util.List;
import javax.ejb.Remote;

@Remote 
public interface ListElementsRemote {
    void addElement(int e);
    void removeElement(int e);
    List<Integer> getElements();  
}
