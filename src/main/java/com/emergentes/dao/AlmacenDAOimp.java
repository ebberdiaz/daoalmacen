
package com.emergentes.dao;
import com.emergentes.modelo.Almacen;
import com.emergentes.utiles.ConexionDB;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlmacenDAOimp extends ConexionDB implements AlmacenDAO{
    
 @Override
    public void insert(Almacen almacen) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(
            "INSERT into productos (descripcion, cantidad, precio, categoria) values (?,?,?,?)");
            ps.setString(1, almacen.getDescripcion());
            ps.setInt(2, almacen.getCantidad());
            ps.setFloat(3, almacen.getPrecio());
            ps.setString(4, almacen.getCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Almacen almacen) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE productos set descripcion=?, cantidad=?, precio=?, categoria=? where id=? ");
            ps.setString(1, almacen.getDescripcion());
            ps.setInt(2, almacen.getCantidad());
            ps.setFloat(3, almacen.getPrecio());
            ps.setString(4, almacen.getCategoria());
            ps.setInt(5, almacen.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(
            "DELETE FROM productos WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();//aumentado
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Almacen getById(int id) throws Exception {
        Almacen alm = new Almacen();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(
            "SELECT * FROM productos WHERE id = ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            

            if (rs.next()) {
                alm.setId(rs.getInt("id"));
                alm.setDescripcion(rs.getString("descripcion"));
                alm.setCantidad(rs.getInt("cantidad"));
                alm.setPrecio(rs.getFloat("precio"));
                alm.setCategoria(rs.getString("categoria"));
            }

          } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return alm;
    }

    @Override
    public List<Almacen> getAll() throws Exception {
        List<Almacen> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(
            "SELECT * FROM productos");
            ResultSet rs = ps.executeQuery();
            lista =  new ArrayList<Almacen>();
            while (rs.next()) {
                Almacen alm = new Almacen();
                alm.setId(rs.getInt("id"));
                alm.setDescripcion(rs.getString("descripcion"));
                alm.setCantidad(rs.getInt("cantidad"));
                alm.setPrecio(rs.getFloat("precio"));
                alm.setCategoria(rs.getString("categoria"));
                lista.add(alm);
            }
            rs.close();
            ps.close();
           
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
}
   
}



    
