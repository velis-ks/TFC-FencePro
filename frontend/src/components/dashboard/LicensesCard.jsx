function LicensesCard() {
  return (
    <div className="side-card">

      <h4>Licencias</h4>

      <p>10/05/2026 <span className="status-green">Completado</span></p>
      <p>10/05/2026 <span className="status-red">Rechazado</span></p>
      <p>10/05/2026 <span className="status-orange">Pendiente</span></p>

      <span className="link-action">
        + Ver transacciones
      </span>

    </div>
  );
}

export default LicensesCard;
