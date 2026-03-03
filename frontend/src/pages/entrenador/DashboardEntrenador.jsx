import EntrenadorLayout from "../../layouts/EntrenadorLayout";
import StatsEntrenador from "../../components/dashboardEntrenador/StatsEntrenador";
import AccesoRapidoCard from "../../components/dashboardEntrenador/AccesoRapidoCard";
import EventosEntrenadorTable from "../../components/dashboardEntrenador/EventosEntrenadorTable";
import CambiosCitacionesCard from "../../components/dashboardEntrenador/CambiosCitacionesCard";
import ProximasSesionesCard from "../../components/dashboardEntrenador/ProximasSesionesCard";
import AsistenciasRecientesCard from "../../components/dashboardEntrenador/AsistenciasRecientesCard";
import IndicadoresProgresoCard from "../../components/dashboardEntrenador/IndicadoresProgresoCard";

function DashboardEntrenador() {
  return (
    <EntrenadorLayout>

      {/* FILA 1 - STATS */}
      <StatsEntrenador />

      {/* FILA 2 */}
      <div className="dashboard-row-2">
        <AccesoRapidoCard />
        <EventosEntrenadorTable />
        <CambiosCitacionesCard />
      </div>

      {/* FILA 3 */}
      <div className="dashboard-row-3">
        <ProximasSesionesCard />
        <AsistenciasRecientesCard />
        <IndicadoresProgresoCard />
      </div>

    </EntrenadorLayout>
  );
}

export default DashboardEntrenador;