import DashboardLayout from "../../layouts/DashboardLayout";
import "../../styles/monitorizacionAdmin.css";

import MonitorStats from "../../components/monitorizacion/MonitorStats";
import SystemActivityTable from "../../components/monitorizacion/SystemActivityTable";
import LogsTable from "../../components/monitorizacion/LogsTable";
import TechnicalAlertsTable from "../../components/monitorizacion/TechnicalAlertsTable";
import AlertsSummary from "../../components/monitorizacion/AlertsSummary";
import RoleActivity from "../../components/monitorizacion/RoleActivity";
import UserActivityChart from "../../components/monitorizacion/UserActivityChart";
import UserSummary from "../../components/monitorizacion/UserSummary";
import ModuleAccessTable from "../../components/monitorizacion/ModuleAccessTable";

function MonitorizacionAdmin(){

return(

<DashboardLayout>

<div className="monitor-admin">

<h2 className="monitor-title">Monitorización</h2>

<MonitorStats/>

<div className="monitor-grid-top">
<SystemActivityTable/>
<LogsTable/>
</div>

<div className="monitor-grid-middle">
<TechnicalAlertsTable/>
<AlertsSummary/>
<RoleActivity/>
</div>

<div className="monitor-grid-bottom">
<UserActivityChart/>
<UserSummary/>
<ModuleAccessTable/>
</div>

</div>

</DashboardLayout>

)

}

export default MonitorizacionAdmin;