import { useState } from "react";

function NotificationHistory(){

const [openMenu,setOpenMenu] = useState(null);

const history = [
{
fecha:"12.03.2025",
titulo:"Renovación licencia",
destinatario:"Deportistas",
cantidad:420,
canal:"App + Email",
estado:"Enviada"
},
{
fecha:"10.03.2025",
titulo:"Inicio Copa Madrid",
destinatario:"Clubes",
cantidad:18,
canal:"App",
estado:"Enviada"
},
{
fecha:"08.03.2025",
titulo:"Recordatorio inscripción",
destinatario:"Deportistas",
cantidad:95,
canal:"Email",
estado:"Enviada"
},
{
fecha:"26.03.2026",
titulo:"Proceso de pago",
destinatario:"Árbitros",
cantidad:32,
canal:"Email",
estado:"Anulado"
},
{
fecha:"14.04.2026",
titulo:"Estado competiciones",
destinatario:"Clubes",
cantidad:152,
canal:"App + Email",
estado:"Enviada"
}
];

return(

<div className="notifications-card">

<h4>Historial</h4>

<table className="notifications-table">

<thead>
<tr>
<th>Fecha</th>
<th>Título</th>
<th>Destinatario</th>
<th>Cantidad</th>
<th>Canal</th>
<th>Estado</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

{history.map((item,index)=>(

<tr key={index}>

<td>{item.fecha}</td>
<td>{item.titulo}</td>
<td>{item.destinatario}</td>
<td>{item.cantidad}</td>
<td>{item.canal}</td>

<td className={
item.estado === "Enviada"
? "notifications-status-ok"
: "notifications-status-cancel"
}>
{item.estado}
</td>

<td className="notifications-actions">

<button
className="notifications-menu-btn"
onClick={()=>setOpenMenu(openMenu === index ? null : index)}
>
⋯
</button>

{openMenu === index && (

<div className="notifications-dropdown">

<div className="notifications-item">
Ver detalle
</div>

<div className="notifications-item">
Reenviar
</div>

<div className="notifications-item">
Duplicar
</div>

</div>

)}

</td>

</tr>

))}

</tbody>

</table>

<div className="notifications-link">
→ Descargar historial
</div>

</div>

)

}

export default NotificationHistory;