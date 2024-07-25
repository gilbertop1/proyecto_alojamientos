package mx.toluca.service.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import mx.toluca.tecnm.Alojamientos;
import mx.toluca.tecnm.ServiciosAdicionales;
import service.AlojamientosFacadeREST;
import service.ServiciosAdicionalesFacadeREST;

@RequestScoped
@Named
public class ServiciosAdicionalesController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ServiciosAdicionalesFacadeREST serviciosAdicionalesFacade;

    @Inject
    private AlojamientosFacadeREST alojamientosFacade;

    private ServiciosAdicionales servicioAdicional;
    private List<Alojamientos> alojamientos; // Lista de alojamientos
    private List<ServiciosAdicionales> items; // Lista de servicios adicionales
    private Integer selectedAlojamientoId; // ID del alojamiento seleccionado para crear un nuevo servicio
    private Integer alojamientoFiltroId; // ID del alojamiento seleccionado para listar servicios

    @PostConstruct
    public void init() {
        servicioAdicional = new ServiciosAdicionales();
        alojamientos = alojamientosFacade.findAll();
        items = serviciosAdicionalesFacade.findAll();
    }

    public ServiciosAdicionales getServicioAdicional() {
        return servicioAdicional;
    }

    public void setServicioAdicional(ServiciosAdicionales servicioAdicional) {
        this.servicioAdicional = servicioAdicional;
    }

    public List<Alojamientos> getAlojamientos() {
        return alojamientos;
    }

    public List<ServiciosAdicionales> getItems() {
        if (alojamientoFiltroId != null) {
            return serviciosAdicionalesFacade.findAll().stream()
                .filter(item -> item.getIdAlojamiento() != null && 
                                item.getIdAlojamiento().getIdAlojamiento().equals(alojamientoFiltroId))
                .collect(Collectors.toList());
        }
        return List.of(); // Retorna una lista vacía si no hay alojamiento seleccionado
    }

    public Integer getSelectedAlojamientoId() {
        return selectedAlojamientoId;
    }

    public void setSelectedAlojamientoId(Integer selectedAlojamientoId) {
        this.selectedAlojamientoId = selectedAlojamientoId;
    }

    public Integer getAlojamientoFiltroId() {
        return alojamientoFiltroId;
    }

    public void setAlojamientoFiltroId(Integer alojamientoFiltroId) {
        this.alojamientoFiltroId = alojamientoFiltroId;
    }

    public void onAlojamientoChange() {
        // Este método se llamará al cambiar el alojamiento en el filtro
        // Limpiar los elementos, se rebuscarán basándose en el nuevo alojamiento seleccionado
        items = null; // Esto provocará que el método getItems filtre la lista correctamente
    }

    public void saveServicioAdicional() {
        try {
            Alojamientos alojamientoSeleccionado = alojamientosFacade.find(selectedAlojamientoId);
            servicioAdicional.setIdAlojamiento(alojamientoSeleccionado);
            serviciosAdicionalesFacade.create(servicioAdicional);
            items = serviciosAdicionalesFacade.findAll();
            servicioAdicional = new ServiciosAdicionales(); // Reiniciar el formulario
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Servicio Adicional creado con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo crear el servicio adicional"));
        }
    }

    public String deleteServicioAdicional(ServiciosAdicionales servicioAdicional) {
        try {
            serviciosAdicionalesFacade.remove(servicioAdicional.getIdServicio());
            items = serviciosAdicionalesFacade.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Servicio Adicional eliminado con éxito"));
            return "GestionServiciosAdicionales"; // O cambia la página según tu necesidad
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar el servicio adicional"));
            return null;
        }
    }

    public String prepareEdit(ServiciosAdicionales servicioAdicional) {
        this.servicioAdicional = servicioAdicional;
        return "EditarServiciosAdicionales"; // O cambia la página según tu necesidad
    }
}
