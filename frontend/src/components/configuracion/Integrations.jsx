import { useState } from "react";

function Integrations(){

const [openMenu,setOpenMenu] = useState(null);

const rows=[
{serv:"Stripe",tipo:"Pagos",estado:"Activo"},
{serv:"MailChimp",tipo:"Email",estado:"Activo"},
{serv:"Google Analytics",tipo:"Analítica",estado:"Cancelado"},
];

return(

<div className="config-card">

<h4>Conexión con servicios externos</h4>

<table>
<thead>
<tr>
<th>Servicio</th>
<th>Tipo</th>
<th>Estado</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

{rows.map((item,index)=>(

<tr key={index}>

<td>{item.serv}</td>
<td>{item.tipo}</td>
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
<div className="dropdown-item">⚙️ Configurar</div>
<div className="dropdown-item">❌ Cancelar</div>
<div className="dropdown-item">🔍 Ver detalles</div>
</div>

)}

</td>

</tr>

))}

</tbody>
</table>

<div className="card-link">→ Descargar servicios</div>

</div>

)

}

export default Integrations;