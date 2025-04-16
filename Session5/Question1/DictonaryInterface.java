package Session5.Question1;

import java.util.List;
import java.util.Map;

public interface DictonaryInterface {
    public void add(int key,String value); 
    public void delete(int key); 
    public String get(int key); 
    public List<Map.Entry<Integer, String>> getSortedEntries(); 
    public List<Map.Entry<Integer, String>> getRange(int K1,int K2);    
}
