function FacturacionCard() {
  return (
    <div className="stat-card">

      <h4>Facturación</h4>

      <div className="insc-row">
        <span>Anual: </span>
        <span className="bold">2000</span>
      </div>
      <div className="insc-row">
        <span>Mensual: </span>
        <span className="bold">2000</span>
      </div>
      <div className="insc-row">
        <span>Pagos pendientes: </span>
        <span className="bold">2000</span>
      </div>

      <div className="link-action">
        + Ver transacciones
      </div>

    </div>
  );
}

export default FacturacionCard;
