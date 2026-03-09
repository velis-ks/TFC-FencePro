function EventosClubTable() {
  return (
    <div className="club-card">
      <h4>Eventos / Competiciones</h4>

      <table>
        <thead>
          <tr>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Tipo</th>
            <th>Nombre</th>
            <th>Fin inscripción</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>10/05/2026</td>
            <td>10:00</td>
            <td>Curso</td>
            <td>COPA MUNDO CADETE</td>
            <td>10/05/2026</td>
          </tr>
        </tbody>
      </table>

      <div className="club-link">+ Ver calendario</div>
    </div>
  );
}

export default EventosClubTable;