function SystemActivityTable(){

return(

<div className="monitor-box">

<h4>Actividad del sistema</h4>

<div className="monitor-filters">

<div className="monitor-filter">Fecha ▾</div>
<div className="monitor-filter">Tipo de usuario ▾</div>
<div className="monitor-filter">Acción ▾</div>
<div className="monitor-filter">Módulo ▾</div>

<button className="monitor-filter-btn">
+ Filtrar
</button>

</div>

<table className="monitor-table">

<thead>
<tr>
<th>Hora</th>
<th>Usuario</th>
<th>Acción</th>
<th>Módulo</th>
<th>Detalle</th>
</tr>
</thead>

<tbody>
<tr>
<td>10:00</td>
<td>Club Madrid</td>
<td>Crear inscripción</td>
<td>Competiciones</td>
<td>Equipos</td>
</tr>

<tr>
<td>10:00</td>
<td>Carlos</td>
<td>Renovación licencia</td>
<td>Licencias</td>
<td>Individual</td>
</tr>

</tbody>

</table>

<div className="monitor-link">→ Exportar registro</div>

</div>

)

}

export default SystemActivityTable;