import { useState } from "react";
import { MoreHorizontal, Download } from "lucide-react";

function ParticipacionesTable(){

const [openMenu,setOpenMenu] = useState(null);

return(

<div className="card">

<h4>Participaciones</h4>

<div className="filtros">

<div className="filtro">Temporada ▾</div>
<div className="filtro">Arma ▾</div>
<div className="filtro">Categoría ▾</div>
<div className="filtro">Estado ▾</div>

<button className="btn-filtrar">
+ Filtrar
</button>

</div>

<table>

<thead>

<tr>

<th>Competición</th>
<th>Tipo</th>
<th>Arma</th>
<th>Categoría</th>
<th>Participantes</th>
<th>Clubes</th>
<th>Estado</th>
<th>Acción</th>

</tr>

</thead>

<tbody>

<tr>

<td>Copa Madrid</td>
<td>Nacional</td>
<td>Madrid</td>
<td>ABS</td>
<td>84</td>
<td>12</td>
<td className="estado estado-verde">En curso</td>

<td className="acciones">

<button
className="acciones-btn"
onClick={()=>setOpenMenu(openMenu === 0 ? null : 0)}
>
<MoreHorizontal size={18}/>
</button>

{openMenu === 0 && (

<div className="acciones-dropdown">

<div className="acciones-item">
<Download size={14}/>
Exportar lista
</div>

<div className="acciones-item">
<Download size={14}/>
Ver resultados
</div>

</div>

)}

</td>

</tr>

<tr>
<td>Copa Madrid</td>
<td>Nacional</td>
<td>Madrid</td>
<td>ABS</td>
<td>84</td>
<td>12</td>
<td className="estado estado-azul">Próx.</td>
<td><MoreHorizontal size={18}/></td>
</tr>

<tr>
<td>Copa Madrid</td>
<td>Nacional</td>
<td>Madrid</td>
<td>ABS</td>
<td>84</td>
<td>12</td>
<td className="estado estado-rojo">Finalizado</td>
<td><MoreHorizontal size={18}/></td>
</tr>

</tbody>

</table>

<div className="card-link">
→ Descargar histórico participaciones
</div>

</div>

)

}

export default ParticipacionesTable;