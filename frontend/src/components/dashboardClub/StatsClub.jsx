function StatsClub() {
  return (
    <div className="club-stats-grid">

      <div className="club-stat-card green">
        <h4>Deportistas totales</h4>
        <p>320</p>
        <span>Activos 200 | Inactivos 120</span>
      </div>

      <div className="club-stat-card blue">
        <h4>Licencias activas</h4>
        <p>230</p>
        <span>Competitivas 80 | Sociales 20</span>
      </div>

      <div className="club-stat-card gold">
        <h4>Próximas competiciones</h4>
        <p>17</p>
        <span>Comp. 8 | Sociales 2</span>
      </div>

      <div className="club-stat-card orange">
        <h4>Pagos pendientes</h4>
        <p>12</p>
        <span>850€</span>
      </div>

    </div>
  );
}

export default StatsClub;