function LicensesCard() {
  return (
    <div className="stat-card">

      <h4>Licencias</h4>

      <div className="insc-row">
        <span>10/05/2026</span> <span className="status-green">Completado</span>
      </div>
      <div className="insc-row">
        <span>10/05/2026</span> <span className="status-red">Rechazado</span>
      </div>
      <div className="insc-row">
        <span>10/05/2026</span> <span className="status-orange">Pendiente</span>
      </div>

      <div className="link-action">
        + Ver transacciones
      </div>

    </div>
  );
}

export default LicensesCard;
