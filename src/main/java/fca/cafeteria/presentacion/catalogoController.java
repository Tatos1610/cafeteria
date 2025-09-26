package fca.cafeteria.presentacion;

import fca.cafeteria.domain.catalogoDomain;
import fca.cafeteria.data.tbebida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/bebidas")
public class catalogoController {

    // INYECCIÓN DEL DOMAIN
    @Autowired
    private catalogoDomain catalogoDomain;

    // REGISTRAR BEBIDA
    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public String registrarBebida(
            @RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam String tipoBebida) {

        return catalogoDomain.registrarBebida(nombre, descripcion, tipoBebida);
    }

    // BUSCAR BEBIDAS
    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    public List<tbebida> buscarBebidasPorTipo(@RequestParam String tipo) {
        return catalogoDomain.buscarBebidasPorTipo(tipo);
    }
}
