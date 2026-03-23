import { useState } from "react";

function WeaponsTable(){

const [openMenu,setOpenMenu] = useState(null);

const rows=[
{arma:"Florete",cod:"FLO",desc:"Arma ligera",estado:"Activa"},
{arma:"Espada",cod:"ESP",desc:"Sin prioridad",estado:"Activa"},
{arma:"Sable",cod:"SAB",desc:"Golpes válidos arriba",estado:"Activa"},
];

return(

<div className="config-card">

<h4>Tabla de armas</h4>

<table>
<thead>
<tr>
<th>Arma</th>
<th>Código</th>
<th>Descripción</th>
<th>Estado</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

{rows.map((item,index)=>(

<tr key={index}>

<td>{item.arma}</td>
<td>{item.cod}</td>
<td>{item.desc}</td>
<td className="status-ok">{item.estado}</td>

<td className="action-cell">

<button
className="menu-btn"
onClick={()=>setOpenMenu(openMenu===index?null:index)}
>
⋯
</button>

{openMenu===index &&(

<div className="dropdown">
<div className="dropdown-item">✏️ Editar</div>
<div className="dropdown-item">⚙️ Desactivar</div>
</div>

)}

</td>

</tr>

))}

</tbody>
</table>

<div className="card-link">→ Descargar armas</div>

</div>

)

}

export default WeaponsTable;