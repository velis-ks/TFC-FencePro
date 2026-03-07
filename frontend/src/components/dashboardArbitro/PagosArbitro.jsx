function PagosArbitro(){

  return(

    <div className="arbitro-card">

      <h3>Pagos</h3>

      <table>

        <thead>
          <tr>
            <th>Competición</th>
            <th>Rol</th>
            <th>Importe</th>
            <th>Estado</th>
          </tr>
        </thead>

        <tbody>

          <tr>
            <td>Prueba Cto España</td>
            <td>Lorem ipsum</td>
            <td>80€</td>
            <td className="arbitro-badge arbitro-badge-green">Activo</td>
          </tr>
          <tr>
            <td>Prueba Cto España</td>
            <td>Lorem ipsum</td>
            <td>80€</td>
            <td className="arbitro-badge arbitro-badge-red">Pendiente</td>
          </tr>
          <tr>
            <td>Prueba Cto España</td>
            <td>Lorem ipsum</td>
            <td>80€</td>
            <td className="arbitro-badge arbitro-badge-green">Activo</td>
          </tr>
          <tr>
            <td>Prueba Cto España</td>
            <td>Lorem ipsum</td>
            <td>80€</td>
            <td className="arbitro-badge arbitro-badge-red">Pendiente</td>
          </tr>

        </tbody>

      </table>

      <div className="arbitro-link">
        + Ver todos los pagos
      </div>

    </div>

  )

}

export default PagosArbitro