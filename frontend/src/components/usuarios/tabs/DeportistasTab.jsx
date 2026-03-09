import UsuariosFilters from "../UsuariosFilters";
import UsuariosTable from "../UsuariosTable";
import UsuariosSideStats from "../UsuariosSideStats";


function DeportistasTab(){

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
["012345678","Carlos Martín","Club Madrid","Femenino","INF","Florete","25-26","Activo"],
["012345678","Carlos Martín","Club Madrid","Masculino","ABS","Espada","25-26","Inactivo"]
];

return(

<div className="usuarios-grid">

<div>

<UsuariosFilters/>

<UsuariosTable
title="Usuarios deportistas"
columns={columns}
data={data}
/>

</div>

<UsuariosSideStats/>

</div>

)

}

export default DeportistasTab;