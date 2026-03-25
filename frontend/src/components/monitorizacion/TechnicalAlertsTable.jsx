function TechnicalAlertsTable(){

return(

<div className="monitor-box">

<h4>Alertas técnicas</h4>

<div className="monitor-filters">

<div className="monitor-filter">Fecha ▾</div>
<div className="monitor-filter">Nivel ▾</div>
<div className="monitor-filter">Servicio ▾</div>
<div className="monitor-filter">Estado ▾</div>

<button className="monitor-filter-btn">
+ Filtrar
</button>

</div>

<table className="monitor-table">

<thead>
<tr>
<th>Fecha</th>
<th>Hora</th>
<th>Nivel</th>
<th>Servicio</th>
<th>Descripción</th>
<th>Estado</th>
</tr>
</thead>

<tbody>

<tr>
<td>26.03.26</td>
<td>10:00</td>
<td>Error</td>
<td>Pagos</td>
<td>Error conexión Stripe</td>
<td className="monitor-error">Activo</td>
</tr>

<tr>
<td>26.03.26</td>
<td>10:00</td>
<td>Alerta</td>
<td>Email</td>
<td>Retraso envío</td>
<td className="monitor-success">Resuelto</td>
</tr>

</tbody>

</table>

<div className="monitor-link">→ Exportar registro</div>

</div>

)

}

export default TechnicalAlertsTable;