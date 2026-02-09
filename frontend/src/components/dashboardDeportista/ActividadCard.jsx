function ActividadCard() {
  return (
    <div className="depor-card">

      <h3>Mi actividad</h3>

      <div className="depor-row">
        <span>Asistencias mes</span>
        <b>2000</b>
      </div>

      <div className="depor-row">
        <span>Asistencias temporada</span>
        <b>2000</b>
      </div>

      <div className="depor-row">
        <span>% asistencias</span>
        <b className="green">76%</b>
      </div>

      <div className="circle-progress">
        76%
      </div>

      <span className="link-action">
        + Gestionar inscripciones
      </span>

    </div>
  );
}

export default ActividadCard;   