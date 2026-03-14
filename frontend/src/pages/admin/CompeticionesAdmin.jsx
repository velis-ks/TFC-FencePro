import DashboardLayout from "../../layouts/DashboardLayout";
import CompeticionesCalendar from "../../components/competiciones/CompeticionesCalendar";
import CompeticionesTable from "../../components/competiciones/CompeticionesTable";
import RankingTable from "../../components/competiciones/RankingTable";
import InscripcionesTable from "../../components/competiciones/InscripcionesTable";
import CompeticionesStats from "../../components/competiciones/CompeticionesStats";
import "../../styles/competicionesAdmin.css";

function CompeticionesAdmin(){

return(

<DashboardLayout>

<div className="competiciones-admin">

<h2 className="competiciones-title">Competiciones</h2>

{/* GRID PRINCIPAL */}

<div className="competiciones-grid">

<CompeticionesCalendar/>

<CompeticionesTable/>

</div>

{/* GRID INFERIOR */}

<div className="competiciones-bottom">

<RankingTable/>

<CompeticionesStats/>

<InscripcionesTable/>

</div>

</div>

</DashboardLayout>

)

}

export default CompeticionesAdmin;