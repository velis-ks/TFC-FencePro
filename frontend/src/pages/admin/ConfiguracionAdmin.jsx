import DashboardLayout from "../../layouts/DashboardLayout";
import "../../styles/configuracionAdmin.css";

import GeneralInfo from "../../components/configuracion/GeneralInfo";
import SystemConfig from "../../components/configuracion/SystemConfig";
import RulesConfig from "../../components/configuracion/RulesConfig";
import CategoriesTable from "../../components/configuracion/CategoriesTable";
import NewCategory from "../../components/configuracion/NewCategory";
import WeaponsTable from "../../components/configuracion/WeaponsTable";
import NewWeapon from "../../components/configuracion/NewWeapon";
import SeasonsTable from "../../components/configuracion/SeasonsTable";
import NewSeason from "../../components/configuracion/NewSeason";
import Integrations from "../../components/configuracion/Integrations";
import NewIntegration from "../../components/configuracion/NewIntegration";

function ConfiguracionAdmin(){

return(

<DashboardLayout>

<div className="config-admin">

<h2 className="config-title">Configuración</h2>

{/* TOP */}
<div className="config-grid-top">
<GeneralInfo/>
<SystemConfig/>
<RulesConfig/>
</div>

{/* CATEGORIAS */}
<div className="config-grid">
<CategoriesTable/>
<NewCategory/>
</div>

{/* ARMAS */}
<div className="config-grid">
<WeaponsTable/>
<NewWeapon/>
</div>

{/* TEMPORADAS */}
<div className="config-grid">
<SeasonsTable/>
<NewSeason/>
</div>

{/* INTEGRACIONES */}
<div className="config-grid">
<Integrations/>
<NewIntegration/>
</div>

</div>

</DashboardLayout>

)

}

export default ConfiguracionAdmin;