function EventosEntrenadorTable() {
  return (
    <div className="card">
      <h3>Eventos / Competiciones</h3>

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
          <tr>
            <td>10/05/2026</td>
            <td>10:00</td>
            <td>Tecnificación</td>
            <td>PRUEBA CTO ESPAÑA</td>
            <td>10/05/2026</td>
          </tr>
        </tbody>
      </table>

      <div className="link-action">+ Ver calendario</div>
    </div>
  );
}

export default EventosEntrenadorTable;