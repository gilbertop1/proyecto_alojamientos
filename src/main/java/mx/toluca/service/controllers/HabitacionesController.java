package mx.toluca.service.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mx.toluca.tecnm.Habitaciones;
import mx.toluca.tecnm.Alojamientos;
import service.HabitacionesFacadeREST;
import service.AlojamientosFacadeREST;

@RequestScoped
@Named
public class HabitacionesController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    

    @Inject // Inyección del ReservasController
    private ReservasController reservasController;
    
    @Inject
    private HabitacionesFacadeREST habitacionesFacade;
    
    @Inject
    Habitaciones hb;
    
    @Inject
    AlojamientosFacadeREST alo;
    
    @Inject
    Alojamientos alojar;
    
    @EJB
    private AlojamientosFacadeREST alojamientosFacade;

    private Habitaciones habitacion;
    private List<Alojamientos> alojamientos;
    private List<Habitaciones> items;
    
    private Integer selectedAlojamientoId;

    @PostConstruct
    public void init() {
        habitacion = new Habitaciones();
        habitacion.setIdAlojamiento(new Alojamientos());
        alojamientos = alojamientosFacade.findAll();
        items = habitacionesFacade.findAll();
    }
    
    public Habitaciones getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }

    public List<Alojamientos> getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos(List<Alojamientos> alojamientos) {
        this.alojamientos = alojamientos;
    }

    public List<Habitaciones> getItems() {
        List<Habitaciones> filteredItems = new ArrayList<>();
        if (selectedAlojamientoId != null) {
            filteredItems = items.stream()
                .filter(item -> item.getIdAlojamiento().getIdAlojamiento().equals(selectedAlojamientoId))
                .collect(Collectors.toList());
        }
        System.out.println("Selected Alojamiento ID: " + selectedAlojamientoId + ", Filtered Items Count: " + filteredItems.size());
        return filteredItems;
    }
    
    
    public void setItems(List<Habitaciones> items) {
        this.items = items;
    }
    
    public Integer getSelectedAlojamientoId() {
        return selectedAlojamientoId;
    }

    public void setSelectedAlojamientoId(Integer selectedAlojamientoId) {
        this.selectedAlojamientoId = selectedAlojamientoId;
    }
    
    public void onAlojamientoChange() {
        items = getItems(); // Filtrar las habitaciones por el nuevo alojamiento seleccionado
    }
    
    
    public void onAlojamientoChange2() {
        // Aquí se actualizan las habitaciones y también se notifica a ReservasController
        getItems(); // Actualiza las habitaciones
        reservasController.setSelectedAlojamientoId(selectedAlojamientoId); // Notifica el cambio
    }


    public void saveHabitacion() {
        try {
            habitacionesFacade.create(habitacion);
            items = habitacionesFacade.findAll();
            habitacion = new Habitaciones();
            habitacion.setIdAlojamiento(new Alojamientos());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Habitación creada con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo crear la habitación"));
        }
    }

    public String deleteHabitacion(Habitaciones habitacion) {
        try {
            habitacionesFacade.remove(habitacion);
            items = habitacionesFacade.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Habitación eliminada con éxito"));
            return "GestionHabitaciones";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar la habitación"));
            return null;
        }
    }

    public String updateHabitacion() {
        try {
            habitacionesFacade.edit(habitacion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registrado con éxito"));
            return "GestionHabitaciones";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo registrar la habitación"));
            return null;
        }
    }

    public String prepareEdit(Habitaciones habitacion) {
        this.habitacion = habitacion;
        return "EditarHabitacion";
    }

    public Habitaciones getSelected() {
        return habitacion;
    }

    public void setSelected(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }

    public Habitaciones getHb() {
        return hb;
    }

    public void setHb(Habitaciones hb) {
        this.hb = hb;
    }

    public AlojamientosFacadeREST getAlo() {
        return alo;
    }

    public void setAlo(AlojamientosFacadeREST alo) {
        this.alo = alo;
    }

    public Alojamientos getAlojar() {
        return alojar;
    }

    public void setAlojar(Alojamientos alojar) {
        this.alojar = alojar;
    }
}
