import { useState } from "react";
import { MoreHorizontal, Check, X, Download, Bell } from "lucide-react";

function InscripcionesTable() {

const [openMenu,setOpenMenu] = useState(null);

const data = [
{
deportista:"Carlos M.",
club:"Madrid",
arma:"Florete",
categoria:"ABS",
licencia:"012345678",
estado:"Pendiente",
pago:"En curso"
},
{
deportista:"Carlos M.",
club:"Madrid",
arma:"Florete",
categoria:"ABS",
licencia:"012345678",
estado:"Confirmado",
pago:"OK"
},
{
deportista:"Carlos M.",
club:"Madrid",
arma:"Florete",
categoria:"ABS",
licencia:"012345678",
estado:"Rechazado",
pago:"En curso"
}
];

return(

<div className="card">

<h4>Inscripciones</h4>

<table>

<thead>
<tr>
<th>Deportista</th>
<th>Club</th>
<th>Arma</th>
<th>Categoría</th>
<th>Licencia</th>
<th>Estado</th>
<th>Pago</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

{data.map((row,i)=>(

<tr key={i}>

<td>{row.deportista}</td>
<td>{row.club}</td>
<td>{row.arma}</td>
<td>{row.categoria}</td>
<td>{row.licencia}</td>

<td className={`estado estado-${row.estado.toLowerCase()}`}>
{row.estado}
</td>

<td>{row.pago}</td>

<td className="acciones">

<button
className="acciones-btn"
onClick={()=>setOpenMenu(openMenu === i ? null : i)}
>
<MoreHorizontal size={18}/>
</button>

{openMenu === i && (

<div className="acciones-dropdown">

<div className="acciones-item">
<Check size={14}/>
Validar
</div>

<div className="acciones-item acciones-rechazar">
<X size={14}/>
Rechazar
</div>

<div className="acciones-item">
<Download size={14}/>
Exportar
</div>

<div className="acciones-item">
<Bell size={14}/>
Notificar
</div>

</div>

)}

</td>

</tr>

))}

</tbody>

</table>

<div className="card-link">
→ Crear competición
</div>

</div>

)

}

export default InscripcionesTable;