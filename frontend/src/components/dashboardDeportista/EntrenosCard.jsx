function EntrenosCard() {
  return (
    <div className="depor-card">

      <h3>Planes de entrenamiento</h3>

      <p><b>Entrenador:</b> David Pérez</p>
      <p><b>Fecha:</b> Martes, 25 abril</p>
      <p><b>Hora:</b> 18:00</p>
      <p><b>Lugar:</b> Polideportivo</p>

      <button className="btn-green">
        Ver sesión de hoy
      </button>

      <button className="btn-green">
        Completada
      </button>

      <button className="btn-whatsapp">
        Contactar entrenador
      </button>

    </div>
  );
}

export default EntrenosCard;   