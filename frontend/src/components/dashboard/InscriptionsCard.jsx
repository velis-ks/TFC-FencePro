function InscriptionsCard() {
  return (
    <div className="side-card inscriptions-panel">

      <h4>Inscripciones</h4>

      <div className="insc-row">
        <span>Total</span>
        <span className="bold">2000</span>
      </div>

      <div className="insc-row">
        <span>Activas</span>
        <span className="green-text">2000</span>
      </div>

      <div className="insc-row">
        <span>Caducadas</span>
        <span className="red-text">2000</span>
      </div>

      <div className="insc-row">
        <span>Pte. renovación</span>
        <span>2000</span>
      </div>

      <div className="insc-row">
        <span>Alerta de caducidad</span>
        <span>2000</span>
      </div>

      <span className="link-action">
        + Gestionar inscripciones
      </span>

    </div>
  );
}

export default InscriptionsCard;

