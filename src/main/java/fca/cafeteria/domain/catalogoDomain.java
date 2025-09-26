package fca.cafeteria.domain;

import fca.cafeteria.data.bebidaRepository;
import fca.cafeteria.data.tipoBebidaRepository;
import fca.cafeteria.data.tbebida;
import fca.cafeteria.data.ttipobebida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class catalogoDomain {

    // INYECCIÓN DE REPOSITORIOS (igual que tu ejemplo)
    @Autowired
    private bebidaRepository bebidaRepository;

    @Autowired
    private tipoBebidaRepository tipoBebidaRepository;

    public String registrarBebida(String nombre, String descripcion, String tipoBebidaDesc) {
        // Validación básica (como en tu ejemplo)
        if (nombre == null || nombre.isEmpty() || tipoBebidaDesc == null || tipoBebidaDesc.isEmpty()) {
            return "Error: Nombre y tipo de bebida son requeridos";
        }

        // PREDICATE para verificar si la bebida ya existe (como tu ejemplo)
        Predicate<String> bebidaExiste = nom ->
                bebidaRepository.findAll().stream()
                        .anyMatch(bebida -> bebida.getNombre().equalsIgnoreCase(nom));

        if (bebidaExiste.test(nombre)) {
            return "Error: Ya existe una bebida con ese nombre";
        }

        // PREDICATE para buscar tipo de bebida existente (como tu ejemplo)
        Predicate<String> tipoExiste = desc ->
                tipoBebidaRepository.findAll().stream()
                        .anyMatch(tipo -> tipo.getDescripcion().equalsIgnoreCase(desc));

        ttipobebida tipoBebida;
        boolean esNuevoTipo = false;

        if (tipoExiste.test(tipoBebidaDesc)) {
            // si tipobebida existe, lo busca y usa
            tipoBebida = tipoBebidaRepository.findAll().stream()
                    .filter(tipo -> tipo.getDescripcion().equalsIgnoreCase(tipoBebidaDesc))
                    .findFirst()
                    .orElse(null);
        } else {
            // si tipobebida no existe, lo crea
            tipoBebida = new ttipobebida();
            tipoBebida.setDescripcion(tipoBebidaDesc);
            tipoBebida = tipoBebidaRepository.save(tipoBebida);
            esNuevoTipo = true;
        }

        // Crear y guardar la bebida
        tbebida nuevaBebida = new tbebida();
        nuevaBebida.setNombre(nombre);
        nuevaBebida.setDescripcion(descripcion != null ? descripcion : "");
        nuevaBebida.setTipobebida(tipoBebida);

        bebidaRepository.save(nuevaBebida);

        return "Bebida registrada. " + (esNuevoTipo ? "Nuevo tipo creado" : "Tipo existente usado");
    }

    // METODO DE BÚSQUEDA
    public java.util.List<tbebida> buscarBebidasPorTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            return new java.util.ArrayList<>();
        }

        // PREDICATE para filtrar por tipo
        Predicate<tbebida> filtroTipo = bebida ->
                bebida != null &&
                        bebida.getTipobebida() != null &&
                        bebida.getTipobebida().getDescripcion().equalsIgnoreCase(tipo);

        return bebidaRepository.findAll()
                .stream()
                .filter(filtroTipo)
                .collect(java.util.stream.Collectors.toList());
    }
}