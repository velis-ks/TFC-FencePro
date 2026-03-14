import DashboardLayout from "../../layouts/DashboardLayout";
import InformesStats from "../../components/informes/InformesStats";
import LicenciasChart from "../../components/informes/LicenciasChart";
import RankingClubs from "../../components/informes/RankingClubs";
import CompeticionesReport from "../../components/informes/CompeticionesReport";
import InformesQuickAccess from "../../components/informes/InformesQuickAccess";
import IngresosChart from "../../components/informes/IngresosChart";
import ParticipacionesTable from "../../components/informes/ParticipacionesTable";

import "../../styles/informesAdmin.css";

function InformesAdmin(){

return(

<DashboardLayout>

<div className="informes-admin">

<h2 className="informes-title">
Informes
</h2>

<InformesStats/>

<div className="informes-grid">

<LicenciasChart/>

<RankingClubs/>

<CompeticionesReport/>

<InformesQuickAccess/>

</div>

<div className="informes-bottom">

<IngresosChart/>

<ParticipacionesTable/>

</div>

</div>

</DashboardLayout>

)

}

export default InformesAdmin;