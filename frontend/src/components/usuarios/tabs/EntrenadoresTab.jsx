import UsuariosFilters from "../UsuariosFilters";
import UsuariosTable from "../UsuariosTable";
import UsuariosSideStats from "../UsuariosSideStats";

function EntrenadoresTab(){

const columns = [
"Nº licencia",
"Nombre",
"Club",
"Género",
"Categoría",
"Arma",
"Temporada",
"Estado"
];

const data = [

["012345678","Carlos Martín","Club Madrid","Masculino","ABS","Espada","25-26","Activo"],
["012345678","Carlos Martín","Club Madrid","Masculino","U23","Florete","25-26","Inactivo"],
["012345678","Carlos Martín","Club Madrid","Femenino","CAD","Sable","25-26","Activo"],
["012345678","Carlos Martín","Club Madrid","Masculino","ALE","Espada","25-26","Activo"]

];

return(

<div className="usuarios-grid">

<div>

<UsuariosFilters/>

<UsuariosTable
title="Usuarios entrenadores"
columns={columns}
data={data}
/>

</div>

<UsuariosSideStats/>

</div>

)

}

export default EntrenadoresTab;