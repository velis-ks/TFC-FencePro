import UsuariosFilters from "../UsuariosFilters";
import UsuariosTable from "../UsuariosTable";
import UsuariosSideStats from "../UsuariosSideStats";

function ClubesTab(){

const columns = [
"Nº licencia",
"Nombre",
"Ciudad",
"Temporada",
"Estado"
];

const data = [

["012345678","Club Madrid","Madrid","25-26","Activo"],
["012345678","Club Madrid","Madrid","25-26","Inactivo"],
["012345678","Club Barcelona","Barcelona","25-26","Activo"],
["012345678","Club Valencia","Valencia","25-26","Activo"]

];

return(

<div className="usuarios-grid">

<div>

<UsuariosFilters/>

<UsuariosTable
title="Usuarios clubes"
columns={columns}
data={data}
/>

</div>

<UsuariosSideStats/>

</div>

)

}

export default ClubesTab;