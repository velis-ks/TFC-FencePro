import { useState } from "react";

function RoleHistory(){

const [openMenu,setOpenMenu] = useState(null);

const history = [

{
fecha:"12.03.2025",
usuario:"Club Sevilla",
cambio:"Permiso pagos añadido",
realizado:"Admin Fed"
},

{
fecha:"10.03.2025",
usuario:"Árbitro López",
cambio:"Rol actualizado",
realizado:"Admin Fed"
},

{
fecha:"08.03.2025",
usuario:"Club Valencia",
cambio:"Acceso resultados eliminado",
realizado:"Admin Fed"
},

{
fecha:"14.04.2026",
usuario:"Club Sevilla",
cambio:"Permiso pagos añadido",
realizado:"Admin Fed"
}

];

return(

<div className="security-card">

<h4>Historial de modificaciones, roles y permisos</h4>

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
<th>Usuario afectado</th>
<th>Cambio</th>
<th>Realizado por</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

{history.map((item,index)=>(

<tr key={index}>

<td>{item.fecha}</td>
<td>{item.usuario}</td>
<td>{item.cambio}</td>
<td>{item.realizado}</td>

<td className="action-cell">

<button
className="menu-btn"
onClick={()=>setOpenMenu(openMenu===index?null:index)}
>
⋯
</button>

{openMenu===index &&(

<div className="dropdown">

<div className="dropdown-item">
Ver detalle
</div>

<div className="dropdown-item">
Restaurar permisos
</div>

</div>

)}

</td>

</tr>

))}

</tbody>

</table>

<div className="card-link">
→ Descargar auditorías
</div>

</div>

)

}

export default RoleHistory;