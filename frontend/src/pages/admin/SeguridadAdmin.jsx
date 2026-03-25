import DashboardLayout from "../../layouts/DashboardLayout";
import "../../styles/seguridadAdmin.css";

import AccessControl from "../../components/seguridad/AccessControl";
import SecurityStats from "../../components/seguridad/SecurityStats";
import SystemActions from "../../components/seguridad/SystemActions";
import RoleHistory from "../../components/seguridad/RoleHistory";
import Devices from "../../components/seguridad/Devices";
import DeviceStats from "../../components/seguridad/DeviceStats";

function SeguridadAdmin(){

return(

<DashboardLayout>

<div className="security-admin">

<h2 className="security-title">Seguridad</h2>

<div className="security-grid-top">

<AccessControl/>
<SecurityStats/>

</div>

<div className="security-grid-middle">

<SystemActions/>
<RoleHistory/>

</div>

<div className="security-grid-bottom">

<Devices/>
<DeviceStats/>

</div>

</div>

</DashboardLayout>

)

}

export default SeguridadAdmin;