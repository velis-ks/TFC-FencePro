function IndicadoresClub() {
  return (
    <div className="club-card">
      <h4>Indicadores de progreso</h4>

      <div className="progress-line">
        <span>Competiciones</span>
        <div className="progress-bar">
          <div className="progress-fill" style={{ width: "70%" }}></div>
        </div>
      </div>

      <div className="progress-line">
        <span>Ingresos</span>
        <div className="progress-bar">
          <div className="progress-fill" style={{ width: "60%" }}></div>
        </div>
      </div>

      <div className="club-link">+ Ver progreso</div>
    </div>
  );
}

export default IndicadoresClub;