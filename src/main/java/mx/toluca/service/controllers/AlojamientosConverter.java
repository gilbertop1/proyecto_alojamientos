package mx.toluca.service.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import mx.toluca.tecnm.Alojamientos;
import service.AlojamientosFacadeREST;



@FacesConverter("alojamientoConverter")
@RequestScoped // Aseguramos que sea de alcance apropiado
public class AlojamientosConverter implements Converter {

    @Inject
    private AlojamientosFacadeREST alojamientosFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return alojamientosFacade.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null) {
            return "";
        }
        if (object instanceof Alojamientos) {
            Alojamientos alojamiento = (Alojamientos) object;
            return String.valueOf(alojamiento.getIdAlojamiento());
        } else {
            throw new IllegalArgumentException("Object is not of type Alojamientos");
        }
    }
}
