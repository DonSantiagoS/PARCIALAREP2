package edu.escuelaing.arep.parcial.app.componentes;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.Math;

/**
 * ---------------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------------
 * 													OPERACION
 * ---------------------------------------------------------------------------------------------------------------------------
 * Clase: Operacion
 * Encargada de realizar las operaciones solicitadas funciones como log o acos
 * ---------------------------------------------------------------------------------------------------------------------------
 * @author Santiago Buitrago
 * ---------------------------------------------------------------------------------------------------------------------------
 */

public class operacion {


    public operacion() {

    }

    public Double getLog(Double solicitud) {
        Double respuesta=Math.log10(solicitud);
        return respuesta;
    }

    public Double getAcos(Double solicitud) {
        Double respuesta=Math.acos(solicitud);
        return respuesta;
    }
}