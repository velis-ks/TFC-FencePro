import { useState } from "react";

function CategoriesTable(){

const [openMenu,setOpenMenu] = useState(null);

const rows=[
{cat:"Benjamín",min:6,max:8,tipo:"Formación",estado:"Activa"},
{cat:"Alevín",min:9,max:11,tipo:"Competición",estado:"Activa"},
{cat:"Cadete",min:14,max:16,tipo:"Competición",estado:"Activa"},
{cat:"Juvenil",min:16,max:18,tipo:"Competición",estado:"Activa"},
{cat:"Senior",min:18,max:"Sin límite",tipo:"Profesional",estado:"Activa"},
];

return(

<div className="config-card">

<h4>Gestión de categorías oficiales</h4>

<table>
<thead>
<tr>
<th>Categoría</th>
<th>Edad mín</th>
<th>Edad máx</th>
<th>Tipo</th>
<th>Estado</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

{rows.map((item,index)=>(

<tr key={index}>

<td>{item.cat}</td>
<td>{item.min}</td>
<td>{item.max}</td>
<td>{item.tipo}</td>
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
<div className="dropdown-item">🗑 Eliminar</div>
<div className="dropdown-item">⚙️ Desactivar</div>
</div>

)}

</td>

</tr>

))}

</tbody>
</table>

<div className="card-link">→ Descargar categorías</div>

</div>

)

}

export default CategoriesTable;