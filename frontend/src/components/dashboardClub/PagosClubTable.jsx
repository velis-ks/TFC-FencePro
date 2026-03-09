function PagosClubTable() {
  return (
    <div className="club-card">
      <h4>Pagos</h4>

      <table>
        <thead>
          <tr>
            <th>Deportista</th>
            <th>Concepto</th>
            <th>Importe</th>
            <th>Estado</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Carlos Martín</td>
            <td>Cuota anual</td>
            <td>80€</td>
            <td className="status-red">Pendiente</td>
          </tr>
          <tr>
            <td>Carlos Martín</td>
            <td>Inscripción</td>
            <td>80€</td>
            <td className="status-green">Realizado</td>
          </tr>
        </tbody>
      </table>

      <div className="club-link">+ Ver todos los pagos</div>
    </div>
  );
}

export default PagosClubTable;