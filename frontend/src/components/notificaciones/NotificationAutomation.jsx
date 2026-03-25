function NotificationAutomation(){

return(

<div className="notifications-card">

<h4>Automatizaciones</h4>

<table className="notifications-table">

<thead>

<tr>
<th>Nombre</th>
<th>Disparador</th>
<th>Destinatario</th>
<th>Canal</th>
<th>Estado</th>
</tr>

</thead>

<tbody>

<tr>
<td>Renovación licencia</td>
<td>Licencia próxima a caducar</td>
<td>Deportistas</td>
<td>App + Email</td>
<td className="status-green">Enviada</td>
</tr>

<tr>
<td>Confirmación inscripción</td>
<td>Nueva inscripción</td>
<td>Clubes</td>
<td>App</td>
<td className="status-green">Enviada</td>
</tr>

<tr>
<td>Designación árbitro</td>
<td>Designación árbitro</td>
<td>Árbitros</td>
<td>Email</td>
<td className="status-orange">Inactivo</td>
</tr>

</tbody>

</table>

<div className="notifications-link">
+ Crear automatización
</div>

</div>

)

}

export default NotificationAutomation;