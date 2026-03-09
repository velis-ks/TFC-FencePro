function RendimientoCard() {
  return (
     <div className="depor-card">

      <h3>Mi rendimiento</h3>

      <div className="depor-row">
        <span>Competiciones temporada</span>
        <b>2000</b>
      </div>

      <div className="depor-row">
        <span>🏆 Podios</span>
        <b>2000</b>
      </div>

      <div className="depor-row">
        <span>Mejor resultado</span>
        <span>Esgrima Ciudad Real, 2e</span>
      </div>

      <div className="depor-row">
        <span>Puntuación</span>
        <b className="green">2070.48</b>
      </div>

      <span className="link-action">
        + Gestionar inscripciones
      </span>

    </div>
  );
}

export default RendimientoCard;   