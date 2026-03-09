

function CompetitionsTable() {
  return (
    <div className="card">

      <h4>Competiciones</h4>

      <table>
        <thead>
          <tr>
            <th>Fecha</th>
            <th>Tipo</th>
            <th>Nombre</th>
            <th>Arma</th>
            <th>Género</th>
            <th>Modalidad</th>
            <th>Estado</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>10/05/2026</td>
            <td>Internacional</td>
            <td>COPA MUNDO</td>
            <td>Florete</td>
            <td>Masculino</td>
            <td>Individual</td>
            <td className="status-green">Activo</td>
          </tr>
        </tbody>

      </table>

      <div className="link-action">
        → Ir al calendario
      </div>

    </div>
  );
}

export default CompetitionsTable;
