package my.server.dao.dao.util;


import java.util.List;

/**
 * Created by Vladislav on 01.05.2017.
 */
public interface ElementDAO<T> {

    public List<T> getALL();
    public void  add(T t);

}
