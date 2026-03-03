function CambiosCitacionesCard() {
  return (
    <div className="card">
      <h3>Cambios en citaciones</h3>

      <div className="citacion-item">
        <span>Javier Pérez</span>
        <span className="status-green">Confirmado</span>
      </div>

      <div className="citacion-item">
        <span>Javier Pérez</span>
        <span className="status-orange">Pendiente</span>
      </div>

      <div className="citacion-item">
        <span>Javier Pérez</span>
        <span className="status-red">Cancelado</span>
      </div>

      <div className="link-action">+ Ver citaciones</div>
    </div>
  );
}

export default CambiosCitacionesCard;