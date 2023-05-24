
package com.emergentes.dao;
import com.emergentes.modelo.Almacen;
import java.util.List;


public interface AlmacenDAO {
    public void insert(Almacen almacen) throws Exception;
    public void update(Almacen almacen) throws Exception;
    public void delete(int id) throws Exception;
    public Almacen getById(int id) throws Exception;
    public List<Almacen> getAll() throws Exception;    
}
