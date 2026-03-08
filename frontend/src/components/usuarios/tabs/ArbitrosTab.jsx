import UsuariosFilters from "../UsuariosFilters";
import UsuariosTable from "../UsuariosTable";
import UsuariosSideStats from "../UsuariosSideStats";

function ArbitrosTab(){

const columns = [
"Nº licencia",
"Nombre",
"Género",
"Categoría",
"Arma",
"Temporada",
"Estado"
];

const data = [

["012345678","Carlos Martín","Femenino","INF - BEN","Espada","25-26","Activo"],
["012345678","Carlos Martín","Masculino","ABS","Sable","25-26","Inactivo"],
["012345678","Carlos Martín","Femenino","U23","Florete","25-26","Activo"],
["012345678","Carlos Martín","Masculino","CAD","Espada","25-26","Activo"]

];

return(

<div className="usuarios-grid">

<div>

<UsuariosFilters/>

<UsuariosTable
title="Usuarios árbitros"
columns={columns}
data={data}
/>

</div>

<UsuariosSideStats/>

</div>

)

}

export default ArbitrosTab;