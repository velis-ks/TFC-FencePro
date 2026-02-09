function UsersCard() {
  return (
    <div className="stat-card">

      <h4>Usuarios</h4>

      <div className="insc-row">
        <span>Total</span>
        <span className="bold">200</span>
      </div>
      <div className="insc-row">
        <span>Activos</span>
        <span className="bold">2000</span>
      </div>
      <div className="insc-row">
        <span>Inactivos</span>
        <span className="bold">2000</span>
      </div>
      <div className="insc-row">
        <span>Bloqueados</span>
        <span className="bold">2000</span>
      </div>
      <div className="insc-row">
        <span>Nuevos</span>
        <span className="bold">2000</span>
      </div>

      <div className="link-action">
        + Gestionar usuarios
      </div>

    </div>
  );
}

export default UsersCard;
