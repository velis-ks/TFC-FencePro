import { useState } from "react";
import DashboardLayout from "../../layouts/DashboardLayout";
import "../../styles/usuariosAdmin.css";

import UsuariosTabs from "../../components/usuarios/UsuariosTabs";

import DeportistasTab from "../../components/usuarios/tabs/DeportistasTab";
import EntrenadoresTab from "../../components/usuarios/tabs/EntrenadoresTab";
import ArbitrosTab from "../../components/usuarios/tabs/ArbitrosTab";
import ClubesTab from "../../components/usuarios/tabs/ClubesTab";
import RolesPermisosTab from "../../components/usuarios/tabs/RolesPermisosTab";

function UsuariosAdmin(){

    const [activeTab,setActiveTab] = useState("todos");

    const renderTab = () => {
        switch (activeTab) {
            case "todos":
                return <DeportistasTab filtroRol="TODOS" />;
            case "deportistas":
                return <DeportistasTab filtroRol="DEPORTISTA" />;
            case "entrenadores":
                return <DeportistasTab filtroRol="ENTRENADOR" />;
            case "arbitros":
                return <DeportistasTab filtroRol="ARBITRO" />;
            case "clubes":
                return <DeportistasTab filtroRol="CLUB" />;
            default:
                return <DeportistasTab filtroRol="TODOS" />;
        }
    };

return(

<DashboardLayout>

<div className="usuarios-admin">

<h2 className="usuarios-title">Usuarios</h2>

<UsuariosTabs
activeTab={activeTab}
setActiveTab={setActiveTab}
/>

{renderTab()}

</div>

</DashboardLayout>

)

}

export default UsuariosAdmin;