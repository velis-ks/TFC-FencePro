import { useState } from "react";
import { MoreHorizontal, Pencil, Ban, Trash } from "lucide-react";

function CompeticionesTable(){

const [openMenu,setOpenMenu] = useState(null);

return(

<div className="card">

<h4>Competiciones</h4>

<table>

<thead>
<tr>
<th>Fecha</th>
<th>Hora</th>
<th>Lugar</th>
<th>Categoría</th>
<th>Tipo</th>
<th>Arma</th>
<th>Modalidad</th>
<th>Estado</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

<tr>

<td>26.07.27</td>
<td>10:00</td>
<td>Madrid</td>
<td>ABS</td>
<td>Nacional</td>
<td>Florete</td>
<td>Equipos</td>
<td className="estado estado-confirmado">En curso</td>

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
<Pencil size={14}/>
Editar
</div>

<div className="acciones-item">
<Ban size={14}/>
Bloquear
</div>

<div className="acciones-item acciones-eliminar">
<Trash size={14}/>
Eliminar
</div>

</div>

)}

</td>

</tr>

<tr>
<td>26.07.27</td>
<td>10:00</td>
<td>Madrid</td>
<td>ABS</td>
<td>Nacional</td>
<td>Espada</td>
<td>Individual</td>
<td className="estado estado-pendiente">Próx.</td>
<td><MoreHorizontal size={18}/></td>
</tr>

<tr>
<td>26.07.27</td>
<td>10:00</td>
<td>Madrid</td>
<td>ABS</td>
<td>Nacional</td>
<td>Sable</td>
<td>Equipos</td>
<td className="estado estado-rechazado">Finalizado</td>
<td><MoreHorizontal size={18}/></td>
</tr>

</tbody>

</table>

<div className="card-link">
→ Crear competición
</div>

</div>

)

}

export default CompeticionesTable;