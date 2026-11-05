package com.biblioteca.api.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import java.util.Map;

@Controller
public class WebSocketBibliotecaController {

    // 1. Notificación de Disponibilidad de Libro
    @MessageMapping("/libro-disponible")
    @SendTo("/topic/libros")
    public Map<String, String> notificarLibroDisponible(Map<String, String> mensaje) {
        return Map.of(
                "evento", "LIBRO_DISPONIBLE",
                "titulo", mensaje.getOrDefault("titulo", "Libro Generico"),
                "mensaje", "El libro ya se encuentra disponible para prestamo."
        );
    }

    // 2. Estado de Cubículo en Tiempo Real
    @MessageMapping("/cambiar-cubiculo")
    @SendTo("/topic/cubiculos")
    public Map<String, Object> actualizarCubiculo(Map<String, Object> datos) {
        return Map.of(
                "cubiculoId", datos.get("cubiculoId"),
                "estado", datos.get("estado"),
                "mensaje", "Estado del cubiculo actualizado en tiempo real."
        );
    }

    // 3. Alertas de Préstamos Vencidos / Multas
    @MessageMapping("/alerta-multa")
    @SendTo("/topic/multas")
    public Map<String, String> emitirAlertaMulta(Map<String, String> datos) {
        return Map.of(
                "socio", datos.getOrDefault("socio", "Socio"),
                "monto", datos.getOrDefault("monto", "0.00"),
                "mensaje", "Nueva multa registrada por mora en devolucion."
        );
    }

    // 4. Chat Socio - Bibliotecario
    @MessageMapping("/chat-mensaje")
    @SendTo("/topic/chat")
    public Map<String, String> procesarChat(Map<String, String> mensaje) {
        return Map.of(
                "emisor", mensaje.getOrDefault("emisor", "Usuario"),
                "texto", mensaje.getOrDefault("texto", ""),
                "hora", java.time.LocalTime.now().toString()
        );
    }

    // 5. Ranking de Préstamos en Vivo
    @MessageMapping("/incrementar-prestamos")
    @SendTo("/topic/ranking")
    public Map<String, Object> actualizarRanking(Map<String, Object> datos) {
        return Map.of(
                "libro", datos.getOrDefault("libro", "Título"),
                "totalPrestamos", datos.getOrDefault("total", 1)
        );
    }
}