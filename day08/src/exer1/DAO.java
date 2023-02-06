package exer1;

import java.util.*;

/**
 * @author SHJ
 * @create 2023-01-03 14:20
 */
public class DAO<T> {

    private Map<String,T> map = new HashMap<String,T>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public List<T> list() {
        // 错误写法
//        Collection<T> values = map.values();
//        return (List<T>) values;

        // 正确写法
        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t : values) {
            list.add(t);
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }

}
