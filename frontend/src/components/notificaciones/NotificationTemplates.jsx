import { useState } from "react";

function NotificationTemplates() {

const [openMenu,setOpenMenu] = useState(null);

const templates = [
{
nombre:"Renovación licencia",
destinatarios:"Deportistas",
uso:45
},
{
nombre:"Inicio competición",
destinatarios:"Clubes",
uso:18
},
{
nombre:"Designación árbitro",
destinatarios:"Árbitros",
uso:8
},
{
nombre:"Pendiente de pago",
destinatarios:"Clubes",
uso:5
}
];

return (

<div className="notifications-card">

<h4>Plantillas</h4>

<table className="notifications-table">

<thead>
<tr>
<th>Nombre</th>
<th>Destinatarios</th>
<th>Uso</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

{templates.map((item,index)=>(
<tr key={index}>

<td>{item.nombre}</td>
<td>{item.destinatarios}</td>
<td>{item.uso}</td>

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
Editar
</div>

<div className="notifications-item">
Enviar
</div>

<div className="notifications-item">
Duplicar
</div>

<div className="notifications-item notifications-delete">
Eliminar
</div>

</div>

)}

</td>

</tr>
))}

</tbody>

</table>

<div className="notifications-link">
+ Crear plantilla
</div>

</div>

);

}

export default NotificationTemplates;