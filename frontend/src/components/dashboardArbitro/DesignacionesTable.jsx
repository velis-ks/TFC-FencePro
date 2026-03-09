function DesignacionesTable(){

  return(
    <div className="arbitro-card">

      <h3>Designaciones</h3>

      <table>

        <thead>
          <tr>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Nombre</th>
            <th>Lugar</th>
            <th>Rol</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>10/05/2026</td>
            <td>17:00</td>
            <td>Copa Madrid Junior</td>
            <td>Madrid</td>
            <td>Lorem ipsum</td>
          </tr>
        </tbody>

      </table>

      <div className="arbitro-link">
        + Ver designaciones
      </div>

    </div>
  )
}

export default DesignacionesTable