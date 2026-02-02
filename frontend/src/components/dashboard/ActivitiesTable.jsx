function ActivitiesTable() {
  return (
    <div className="card">

      <h3>Actividades</h3>

      <table>
        <thead>
          <tr>
            <th>Fecha</th>
            <th>Evento</th>
            <th>Nombre</th>
            <th>Lugar</th>
            <th>Plazas</th>
            <th>Estado</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>10/05/2026</td>
            <td>Curso</td>
            <td>COPA MUNDO</td>
            <td>Madrid</td>
            <td>35/40</td>
            <td className="green">Activo</td>
          </tr>
        </tbody>

      </table>

      <div className="link-action">
        + Crear
      </div>

    </div>
  );
}

export default ActivitiesTable;