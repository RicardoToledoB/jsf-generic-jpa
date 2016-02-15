package com.ricardo.proyecto.service;
import com.ricardo.proyecto.dao.GenericDAOImpl;
import com.ricardo.proyecto.model.Usuario;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
/**
 *
 * @author ricardotoledo
 */
@LocalBean
@Stateless
public class UsuarioService  extends GenericDAOImpl<Usuario, Long> {

    public UsuarioService() {
        super(Usuario.class);
    }
   
}
