import { useState } from "react";

function AccessControl(){

const [openMenu,setOpenMenu] = useState(null);

const rows=[
{fecha:"12.03.2025",hora:"10:00",usuario:"Marta Ruiz",rol:"Club",ip:"42.127.244.206",dispositivo:"Chrome PC",estado:"OK"},
{fecha:"10.03.2025",hora:"10:00",usuario:"Juan Pérez",rol:"Árbitro",ip:"42.127.244.206",dispositivo:"iPhone",estado:"OK"},
{fecha:"08.03.2025",hora:"10:00",usuario:"Admin Fed",rol:"Federativo",ip:"42.127.244.206",dispositivo:"Edge PC",estado:"OK"},
{fecha:"26.03.2026",hora:"10:00",usuario:"Sandra",rol:"Deportista",ip:"42.127.244.206",dispositivo:"Chrome Phone",estado:"Fallo"}
]

return(

<div className="security-card">

<h4>Control de accesos al sistema</h4>    

<div className="security-card-header">

<div className="security-filters">
<span>Fecha ▾</span>
<span>Rol ▾</span>
<span>Estado ▾</span>
</div>

<button className="security-filter-btn">+ Filtrar</button>

</div>



<table>

<thead>
<tr>
<th>Fecha</th>
<th>Hora</th>
<th>Usuario</th>
<th>Rol</th>
<th>IP</th>
<th>Dispositivo</th>
<th>Estado</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

{rows.map((item,index)=>(
<tr key={index}>

<td>{item.fecha}</td>
<td>{item.hora}</td>
<td>{item.usuario}</td>
<td>{item.rol}</td>
<td>{item.ip}</td>
<td>{item.dispositivo}</td>

<td className={item.estado==="OK"?"status-ok":"status-error"}>
{item.estado}
</td>

<td className="action-cell">

<button
className="menu-btn"
onClick={()=>setOpenMenu(openMenu===index?null:index)}
>
⋯
</button>

{openMenu===index &&(

<div className="dropdown">

<div className="dropdown-item">Ver detalle</div>
<div className="dropdown-item">Bloquear usuario</div>
<div className="dropdown-item">Marcar sospechoso</div>

</div>

)}

</td>

</tr>
))}

</tbody>

</table>

<div className="card-link">→ Descargar historial</div>

</div>

)

}

export default AccessControl;