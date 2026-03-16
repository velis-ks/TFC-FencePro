import { useState } from "react";

function Devices(){

const [openMenu,setOpenMenu] = useState(null);

const devices=[

{
usuario:"Marta Ruiz",
rol:"Club",
dispositivo:"Chrome PC",
ubicacion:"Madrid",
actividad:"2 min"
},

{
usuario:"Admin Fed",
rol:"Federativo",
dispositivo:"iPhone",
ubicacion:"Madrid",
actividad:"Ahora"
},

{
usuario:"Juan Pérez",
rol:"Árbitro",
dispositivo:"Edge PC",
ubicacion:"Madrid",
actividad:"10 min"
},

{
usuario:"Victor Robles",
rol:"Club",
dispositivo:"Chrome Phone",
ubicacion:"Valencia",
actividad:"1 min"
},

{
usuario:"Admin Fed",
rol:"Federativo",
dispositivo:"iPhone",
ubicacion:"Madrid",
actividad:"Ahora"
}

];

return(

<div className="security-card">

<h4>Dispositivos conectados</h4>

<table>

<thead>
<tr>
<th>Usuario</th>
<th>Rol</th>
<th>Dispositivo</th>
<th>Ubicación</th>
<th>Última actividad</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

{devices.map((item,index)=>(

<tr key={index}>

<td>{item.usuario}</td>
<td>{item.rol}</td>
<td>{item.dispositivo}</td>
<td>{item.ubicacion}</td>
<td>{item.actividad}</td>

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
Cerrar sesión
</div>

<div className="dropdown-item">
Forzar cierre
</div>

<div className="dropdown-item">
Cerrar todas las sesiones
</div>

</div>

)}

</td>

</tr>

))}

</tbody>

</table>

<div className="card-link">
→ Descargar dispositivos conectados
</div>

</div>

)

}

export default Devices;