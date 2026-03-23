import { useState } from "react";

function SeasonsTable(){

const [openMenu,setOpenMenu] = useState(null);

const rows=[
{temp:"2023-2024",inicio:"01.09.2023",fin:"31.08.2024",estado:"Cerrada"},
{temp:"2024-2025",inicio:"01.09.2024",fin:"31.08.2025",estado:"Activa"},
{temp:"2025-2026",inicio:"01.09.2025",fin:"31.08.2026",estado:"Próxima"},
];

return(

<div className="config-card">

<h4>Tabla de temporadas</h4>

<table>
<thead>
<tr>
<th>Temporada</th>
<th>Fecha inicio</th>
<th>Fecha fin</th>
<th>Estado</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

{rows.map((item,index)=>(

<tr key={index}>

<td>{item.temp}</td>
<td>{item.inicio}</td>
<td>{item.fin}</td>
<td>{item.estado}</td>

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
<div className="dropdown-item">▶️ Activar temporada</div>
<div className="dropdown-item">⛔ Cerrar temporada</div>
</div>

)}

</td>

</tr>

))}

</tbody>
</table>

<div className="card-link">→ Descargar temporadas</div>

</div>

)

}

export default SeasonsTable;