function LicenciasClubTable() {
  return (
    <div className="club-card">
      <h4>Licencias activas</h4>

      <table>
        <thead>
          <tr>
            <th>Deportista</th>
            <th>Tipo</th>
            <th>Nº Licencia</th>
            <th>Arma</th>
            <th>Expiración</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Carlos Martín</td>
            <td>Competitiva</td>
            <td>123456</td>
            <td>Espada</td>
            <td>10/05/2026</td>
          </tr>
        </tbody>
      </table>

      <div className="club-link">+ Ver licencias</div>
    </div>
  );
}

export default LicenciasClubTable;