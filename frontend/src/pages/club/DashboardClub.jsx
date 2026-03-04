import ClubLayout from "../../layouts/ClubLayout";

import StatsClub from "../../components/dashboardClub/StatsClub";
import EventosClubTable from "../../components/dashboardClub/EventosClubTable";
import PagosClubTable from "../../components/dashboardClub/PagosClubTable";
import AccesoRapidoClub from "../../components/dashboardClub/AccesoRapidoClub";
import LicenciasClubTable from "../../components/dashboardClub/LicenciasClubTable";
import IndicadoresClub from "../../components/dashboardClub/IndicadoresClub";

import "../../styles/dashboardClub.css";

function DashboardClub() {
  return (
    <ClubLayout>
      <div className="dashboard-club">

        {/* FILA 1 */}
        <StatsClub />

        {/* FILA 2 */}
        <div className="club-row-2">
          <EventosClubTable />
          <PagosClubTable />
          <AccesoRapidoClub />
        </div>

        {/* FILA 3 */}
        <div className="club-row-3">
          <LicenciasClubTable />
          <IndicadoresClub />
        </div>

      </div>
    </ClubLayout>
  );
}

export default DashboardClub;