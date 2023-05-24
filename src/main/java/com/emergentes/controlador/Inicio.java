package com.emergentes.controlador;

import com.emergentes.dao.AlmacenDAO;
import com.emergentes.dao.AlmacenDAOimp;
import com.emergentes.modelo.Almacen;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id;
            Almacen alm = new Almacen();
            AlmacenDAO dao = new AlmacenDAOimp();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("almacen", alm);
                    request.getRequestDispatcher("frmalmacen.jsp").forward(request, response);
                    break;

                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    alm = dao.getById(id);
                    System.out.println(alm);
                    request.setAttribute("almacen", alm);
                    request.getRequestDispatcher("frmalmacen.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/Inicio");
                    break;

                case "view":
                    List<Almacen> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            int id = Integer.parseInt(request.getParameter("id"));
            String descripcion = request.getParameter("descripcion");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            float precio = Float.parseFloat(request.getParameter("precio"));
            String categoria = request.getParameter("categoria");
            Almacen alm = new Almacen();
            
            alm.setId(id);
            alm.setDescripcion(descripcion);
            alm.setCantidad(cantidad);
            alm.setPrecio(precio);
            alm.setCategoria(categoria);
            
                if (id == 0) {
                  try {
                         //insertar registro
                      AlmacenDAO dao = new AlmacenDAOimp();
                      dao.insert(alm);
                      response.sendRedirect(request.getContextPath() + "/Inicio");
                  } catch (Exception ex) {
                      System.out.println("Error al guardar datos..");
                  }
                }
                    else{
                        try{
                             //altualizar registro
                            AlmacenDAO dao = new AlmacenDAOimp();
                            dao.update(alm);
                            response.sendRedirect(request.getContextPath() + "/Inicio");
                          } catch (Exception ex) {
                      System.out.println("Error al guardar datos..");
                  }
                }
                     
        }
    }


