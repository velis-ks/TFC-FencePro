function InscriptionsStatCard() {
  return (
    <div className="stat-card gray ">

      <h4>Inscripciones</h4>

      <div className="insc-row">
        <span>Nº insc. total</span>
        <span className="bold">2000</span>
      </div>
      <div className="insc-row">
        <span>Media insc. cto.</span>
        <span className="bold">2000</span>
      </div>


       <span className="link-action">
        + Gestionar inscripciones
      </span>

    </div>
  );
}

export default InscriptionsStatCard;
