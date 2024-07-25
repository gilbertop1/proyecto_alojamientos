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
import mx.toluca.tecnm.Alojamientos;
import mx.toluca.tecnm.Estados;
import service.AlojamientosFacadeREST;
import service.EstadosFacadeREST;

@RequestScoped
@Named
public class AlojamientosController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EstadosFacadeREST esF;
    @Inject 
    private Estados es;
    @EJB
    private AlojamientosFacadeREST alojamientosFacade;

    private Alojamientos alojamiento;
    private List<Estados> lsEstados;
    private List<Alojamientos> items;

    @PostConstruct
    public void init() {
        alojamiento = new Alojamientos();
        alojamiento.setIdEstado(new Estados()); // Inicializa idEstado
        consultarEstados();
        items = alojamientosFacade.findAll();
    }

    public Alojamientos getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Alojamientos alojamiento) {
        this.alojamiento = alojamiento;
    }

    public List<Estados> getLsEstados() {
        return lsEstados;
    }

    public void setLsEstados(List<Estados> lsEstados) {
        this.lsEstados = lsEstados;
    }

    public List<Alojamientos> getItems() {
        return items;
    }

    public void setItems(List<Alojamientos> items) {
        this.items = items;
    }

    public void consultarEstados() {
        lsEstados = esF.findAll();
    }

    public String saveAlojamiento() {
        try {
            alojamientosFacade.create(alojamiento);
            items = alojamientosFacade.findAll(); // Refresh the list
            alojamiento = new Alojamientos(); // Reset the alojamiento object
            alojamiento.setIdEstado(new Estados()); // Reset idEstado
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alojamiento creado con éxito"));
            return "GestionAlojamientos"; // Navigation case
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo crear el alojamiento"));
            return null;
        }
    }

    public String delete(Alojamientos item) {
        try {
            alojamientosFacade.remove(item);
            items = alojamientosFacade.findAll(); // Refresh the list
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alojamiento eliminado con éxito"));
            return "GestionAlojamientos"; // Navigation case
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar el alojamiento"));
            return null;
        }
    }

    public String prepareEdit(Alojamientos alojamiento) {
        this.alojamiento = alojamiento;
        return "GEAupdate";
    }

    public String updateAlojamiento() {
        try {
            alojamientosFacade.edit(alojamiento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alojamiento actualizado con éxito"));
            return "GestionAlojamientos"; // Navigation case
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo actualizar el alojamiento"));
            return null;
        }
    }

    public Estados getEs() {
        return es;
    }

    public void setEs(Estados es) {
        this.es = es;
    }

    public EstadosFacadeREST getEsF() {
        return esF;
    }

    public void setEsF(EstadosFacadeREST esF) {
        this.esF = esF;
    }

    public String prepareList() {
        items = alojamientosFacade.findAll();
        return "List";
    }

    public String prepareView(Alojamientos item) {
        alojamiento = item;
        return "View";
    }

    public String prepareCreate() {
        alojamiento = new Alojamientos();
        return "Create";
    }

    public String create() {
        try {
            alojamientosFacade.create(alojamiento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alojamiento creado con éxito"));
            return "View";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo crear el alojamiento"));
            return null;
        }
    }

    public void conAlojamientos() {
        items = alojamientosFacade.findAll();
    }

    public Alojamientos getSelected() {
        return alojamiento;
    }

    public void setSelected(Alojamientos selected) {
        this.alojamiento = selected;
    }
}

