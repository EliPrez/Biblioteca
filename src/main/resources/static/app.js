let stompClient = null;
let contadorPrestamos = 0;

function conectarWebSocket() {


    const socket = new SockJS('/ws-biblioteca');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        console.log('Conectado exitosamente al WebSocket: ' + frame);
        actualizarBadgeConexion(true);

        // 1. Suscripción a Libros Disponibles
        stompClient.subscribe('/topic/libros', function (mensaje) {
            const data = JSON.parse(mensaje.body);
            mostrarLog('log-libros', `📘 [DISPONIBLE]: ${data.titulo} - ${data.mensaje}`);
        });

        // 2. Suscripción a Estado de Cubículos
        stompClient.subscribe('/topic/cubiculos', function (mensaje) {
            const data = JSON.parse(mensaje.body);
            mostrarLog('log-cubiculos', `🪑 [CUBÍCULO]: ${data.cubiculoId} ahora está ${data.estado}`);
        });

        // 3. Suscripción a Alertas de Multas
        stompClient.subscribe('/topic/multas', function (mensaje) {
            const data = JSON.parse(mensaje.body);
            mostrarLog('log-multas', `⚠️ [MULTA]: Socio ${data.socio} tiene un recargo de Q${data.monto}`);
        });

        // 4. Suscripción a Chat Socio - Bibliotecario
        stompClient.subscribe('/topic/chat', function (mensaje) {
            const data = JSON.parse(mensaje.body);
            mostrarLog('log-chat', `💬 [${data.emisor}]: ${data.texto} (${data.hora})`);
        });

        // 5. Suscripción a Ranking de Préstamos en Vivo
        stompClient.subscribe('/topic/ranking', function (mensaje) {
            const data = JSON.parse(mensaje.body);
            contadorPrestamos++;
            document.getElementById('contador-ranking').innerText = contadorPrestamos;
        });

    }, function (error) {
        console.error('Error de conexión WebSocket:', error);
        actualizarBadgeConexion(false);
        // Intenta reconectarse automáticamente cada 5 segundos si cae la conexión
        setTimeout(conectarWebSocket, 5000);
    });
}

function actualizarBadgeConexion(conectado) {
    const badge = document.getElementById('conexion-badge');
    if (!badge) return;

    if (conectado) {
        badge.innerText = 'Conectado en Tiempo Real (WebSocket)';
        badge.className = 'badge conectado';
    } else {
        badge.innerText = 'Desconectado del Servidor';
        badge.className = 'badge desconectado';
    }
}

function mostrarLog(elementId, texto) {
    const box = document.getElementById(elementId);
    if (!box) return;
    box.innerHTML += `<div>${texto}</div>`;
    box.scrollTop = box.scrollHeight;
}

// --- Funciones para enviar eventos desde los botones del Frontend hacia el Backend ---

function enviarLibroDisponible() {
    const input = document.getElementById('input-libro');
    const titulo = input && input.value ? input.value : 'Cien Años de Soledad';
    stompClient.send("/app/libro-disponible", {}, JSON.stringify({ titulo: titulo }));
    if (input) input.value = '';
}

function cambiarCubiculo() {
    const select = document.getElementById('select-cubiculo');
    const cubiculo = select ? select.value : 'Cubículo 1';
    stompClient.send("/app/cambiar-cubiculo", {}, JSON.stringify({ cubiculoId: cubiculo, estado: 'Ocupado' }));
}

function emitirMulta() {
    const input = document.getElementById('input-socio');
    const socio = input && input.value ? input.value : 'Juan Pérez';
    stompClient.send("/app/alerta-multa", {}, JSON.stringify({ socio: socio, monto: '25.00' }));
    if (input) input.value = '';
}

function enviarMensajeChat() {
    const input = document.getElementById('input-chat');
    const texto = input ? input.value : '';
    if (!texto) return;
    stompClient.send("/app/chat-mensaje", {}, JSON.stringify({ emisor: 'Socio Lector', texto: texto }));
    if (input) input.value = '';
}

function incrementarRanking() {
    stompClient.send("/app/incrementar-prestamos", {}, JSON.stringify({ libro: 'Libro Destacado', total: 1 }));
}

// Iniciar la conexión cuando el documento web cargue por completo
window.onload = function() {
    conectarWebSocket();
};