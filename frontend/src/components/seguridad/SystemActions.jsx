function SystemActions(){

return(

<div className="security-card">

<h4>Registro de acciones dentro del sistema</h4>

<div className="security-card-header">

<div className="security-filters">
<span>Fecha ▾</span>
<span>Usuario ▾</span>
<span>Módulo ▾</span>
<span>Tipo acción ▾</span>
</div>

<button className="security-filter-btn">
+ Filtrar
</button>

</div>

<table>

<thead>
<tr>
<th>Fecha</th>
<th>Usuario</th>
<th>Acción</th>
<th>Módulo</th>
<th>Estado</th>
</tr>
</thead>

<tbody>

<tr>
<td>12.03.2025</td>
<td>Admin Fed</td>
<td>Editar competición</td>
<td>Competiciones</td>
<td className="status-ok">OK</td>
</tr>

<tr>
<td>10.03.2025</td>
<td>Club Madrid</td>
<td>Añadir deportista</td>
<td>Licencias</td>
<td className="status-ok">OK</td>
</tr>

<tr>
<td>08.03.2025</td>
<td>Admin Fed</td>
<td>Eliminar pago</td>
<td>Pagos</td>
<td className="status-error">Fallo</td>
</tr>

</tbody>

</table>

<div className="card-link">→ Descargar auditorías</div>

</div>

)

}

export default SystemActions;