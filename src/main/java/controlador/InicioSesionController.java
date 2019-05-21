/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDao;
import dto.UsuarioDto;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 *
 * @author PabloTnT
 */
@Controller
public class InicioSesionController {

    @RequestMapping("index")
    public String inicioDeSesion(Model m, HttpServletRequest request) {
        UsuarioDao dao = new UsuarioDao();
        UsuarioDto dto = new UsuarioDto();
        return "seleccionModulos";
    }
}
