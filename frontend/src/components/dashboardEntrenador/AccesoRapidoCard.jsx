function AccesoRapidoCard() {
  return (
    <div className="card">
      <h3>Acceso rápido</h3>

      <div className="quick-item">
        <span>Plan Táctica Avanzada</span>
        <span className="status-green">Activo</span>
      </div>

      <div className="quick-item">
        <span>Plan Preparación Física</span>
        <span className="status-green">Activo</span>
      </div>

      <div className="quick-item">
        <span>Plan Cadetes ABS</span>
        <span className="status-green">Activo</span>
      </div>

      <div className="link-action">+ Ver todos los planes</div>
    </div>
  );
}

export default AccesoRapidoCard;