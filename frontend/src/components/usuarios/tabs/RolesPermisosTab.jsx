import { useState } from "react";
import UsuariosSideStats from "../UsuariosSideStats";

function RolesPermisosTab() {

const roles = [
"Deportista",
"Entrenador",
"Árbitro",
"Club"
];

const permisosDisponibles = [
"Ver deportistas",
"Registrar asistencia",
"Crear entrenamientos",
"Ver resultados",
"Gestionar pagos",
"Validar licencias"
];

const [rol, setRol] = useState("");
const [permisos, setPermisos] = useState([]);

function togglePermiso(permiso){

if(permisos.includes(permiso)){

setPermisos(permisos.filter(p => p !== permiso));

}else{

setPermisos([...permisos, permiso]);

}

}

return(

<div className="usuarios-grid">

<div className="usuarios-table">

<h4>Roles y permisos</h4>

<div className="roles-container">

{/* SELECT ROL */}
<div className="roles-select">



<select
value={rol}
onChange={(e)=>setRol(e.target.value)}
className="roles-dropdown"
>

<option value="">Seleccionar rol</option>

{roles.map((r)=>(
<option key={r} value={r}>{r}</option>
))}

</select>

</div>

{/* PERMISOS */}

<div className="roles-permisos">

<h5>Permisos</h5>

{permisosDisponibles.map((permiso)=>(
<label key={permiso} className="permiso-item">

<input
type="checkbox"
checked={permisos.includes(permiso)}
onChange={()=>togglePermiso(permiso)}
/>

{permiso}

</label>
))}

</div>

</div>

<div className="table-link">
→ Crear usuario
</div>

</div>

<UsuariosSideStats/>

</div>

)

}

export default RolesPermisosTab;