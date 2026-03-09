function CompeticionesTable(){

  return(
    <div className="arbitro-card">

      <h3>Competiciones</h3>

      <table>

        <thead>
          <tr>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Nombre</th>
            <th>Fin inscripción</th>
          </tr>
        </thead>

        <tbody>

          <tr>
            <td>10/05/2026</td>
            <td>10:00</td>
            <td>COPA MUNDO CADETE</td>
            <td>10/05/2026</td>
          </tr>

        </tbody>

      </table>

      <div className="arbitro-link">
        + Ver calendario
      </div>

    </div>
  )
}

export default CompeticionesTable