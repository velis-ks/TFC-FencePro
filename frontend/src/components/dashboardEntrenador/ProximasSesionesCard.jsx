function ProximasSesionesCard() {
  return (
    <div className="card">
      <h3>Próximas sesiones</h3>

      <div className="session-item">
        <div>
          <strong>Jueves, 25 abril</strong>
          <p>Trabajos tácticos</p>
        </div>
        <div className="progress-bar">
          <div className="progress-fill" style={{ width: "70%" }}></div>
        </div>
      </div>

      <div className="session-item">
        <div>
          <strong>Sábado, 27 abril</strong>
          <p>Preparación física</p>
        </div>
        <div className="progress-bar">
          <div className="progress-fill" style={{ width: "100%" }}></div>
        </div>
      </div>

      <div className="link-action">+ Ver calendario</div>
    </div>
  );
}

export default ProximasSesionesCard;