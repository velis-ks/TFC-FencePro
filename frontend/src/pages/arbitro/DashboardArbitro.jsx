import ArbitroLayout from "../../layouts/ArbitroLayout";

import DesignacionesTable from "../../components/dashboardArbitro/DesignacionesTable";
import CompeticionesTable from "../../components/dashboardArbitro/CompeticionesTable";
import AccesoRapidoArbitro from "../../components/dashboardArbitro/AccesoRapidoArbitro";

import HistorialArbitro from "../../components/dashboardArbitro/HistorialArbitro";
import PagosArbitro from "../../components/dashboardArbitro/PagosArbitro";
import LicenciaArbitro from "../../components/dashboardArbitro/LicenciaArbitro";

import "../../styles/dashboardArbitro.css";

function DashboardArbitro() {
  return (
    <ArbitroLayout>

      <div className="arbitro-dashboard">

        <div className="arbitro-row-1">
          <DesignacionesTable />
          <CompeticionesTable />
          <AccesoRapidoArbitro />
        </div>

        <div className="arbitro-row-2">
          <HistorialArbitro />
          <PagosArbitro />
          <LicenciaArbitro />
        </div>

      </div>

    </ArbitroLayout>
  );
}

export default DashboardArbitro;