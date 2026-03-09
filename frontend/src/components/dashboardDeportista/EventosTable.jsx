function EventosTable() {
  return (
    <div className="depor-card depor-table">

      <h3>Eventos / Competiciones</h3>

      <table>

        <thead>
          <tr>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Tipo</th>
            <th>Nombre</th>
            <th>Fin Inscripción</th>
            <th>Inscripción</th>
          </tr>
        </thead>

        <tbody>

          <tr>
            <td>10/05/2026</td>
            <td>10:00</td>
            <td>Curso</td>
            <td>COPA MUNDO</td>
            <td>25/11/2025</td>
            <td className="red-dot"></td>
          </tr>

          <tr>
            <td>10/05/2026</td>
            <td>10:00</td>
            <td>Tecnificación</td>
            <td>COPA MUNDO</td>
            <td>25/11/2025</td>
            <td className="green-dot"></td>
          </tr>

        </tbody>

      </table>

      <span className="link-action">
        + Ver calendario
      </span>

    </div>
  );
}

export default EventosTable; 