function AsistenciasRecientesCard() {
  return (
    <div className="card">
      <h3>Asistencias recientes</h3>

      <table>
        <thead>
          <tr>
            <th>Fecha</th>
            <th>Tipo</th>
            <th>Asistencia</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>10/05/2026</td>
            <td>Trabajo táctico</td>
            <td>8</td>
          </tr>
          <tr>
            <td>10/05/2026</td>
            <td>Prep. Física</td>
            <td>6</td>
          </tr>
        </tbody>
      </table>

      <div className="link-action">+ Ver calendario</div>
    </div>
  );
}

export default AsistenciasRecientesCard;