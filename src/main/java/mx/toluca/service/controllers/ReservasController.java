package mx.toluca.service.controllers;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ejb.EJB;
import java.util.List;
import mx.toluca.tecnm.DetalleHabReserva;
import service.ReservasFacadeREST;

@Named
@RequestScoped
public class ReservasController {

    @EJB
    private ReservasFacadeREST reservasFacade;

    private Integer selectedAlojamientoId; // ID del alojamiento seleccionado
    private List<DetalleHabReserva> detalleHabReservas; // Lista de detalles de habitaciones de reservas

    // Método para obtener todas las reservas basadas en el alojamiento seleccionado
    public void onAlojamientoChange() {
        if (selectedAlojamientoId != null) {
            // Obtener todas las reservas para el alojamiento seleccionado
            detalleHabReservas = reservasFacade.findReservasByAlojamiento(selectedAlojamientoId);
        } else {
            detalleHabReservas = null; // Reiniciar si no hay selección
        }
    }

    // Método para obtener detalles de todas las reservas de un alojamiento
    public void loadReservas() {
        if (selectedAlojamientoId != null) {
            detalleHabReservas = reservasFacade.findReservasByAlojamiento(selectedAlojamientoId);
        } else {
            detalleHabReservas = null;
        }
    }

    // Getters y Setters
    public Integer getSelectedAlojamientoId() {
        return selectedAlojamientoId;
    }

    public void setSelectedAlojamientoId(Integer selectedAlojamientoId) {
        this.selectedAlojamientoId = selectedAlojamientoId;
        onAlojamientoChange(); // Llama al método para actualizar las reservas
    }


    public List<DetalleHabReserva> getDetalleHabReservas() {
        return detalleHabReservas;
    }
}