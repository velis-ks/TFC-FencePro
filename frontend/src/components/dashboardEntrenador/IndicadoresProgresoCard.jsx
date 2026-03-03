function IndicadoresProgresoCard() {
  return (
    <div className="card">
      <h3>Indicadores de progreso</h3>

      <div className="indicator-row">
        <span>Competiciones</span>
        <div className="progress-bar">
          <div className="progress-fill" style={{ width: "60%" }}></div>
        </div>
      </div>

      <div className="indicator-row">
        <span>Asistencia</span>
        <div className="progress-bar">
          <div className="progress-fill" style={{ width: "79%" }}></div>
        </div>
      </div>

      <div className="indicator-row">
        <span>Puntuación media</span>
        <div className="progress-bar">
          <div className="progress-fill" style={{ width: "80%" }}></div>
        </div>
      </div>

      <div className="link-action">+ Ver progreso</div>
    </div>
  );
}

export default IndicadoresProgresoCard;