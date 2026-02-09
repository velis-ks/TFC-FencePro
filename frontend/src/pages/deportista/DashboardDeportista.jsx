import DeportistaLayout from "../../layouts/DeportistaLayout";

import RendimientoCard from "../../components/dashboardDeportista/RendimientoCard";
import ActividadCard from "../../components/dashboardDeportista/ActividadCard";
import LicenciaCard from "../../components/dashboardDeportista/LicenciaCard";
import EventosTable from "../../components/dashboardDeportista/EventosTable";
import EntrenosCard from "../../components/dashboardDeportista/EntrenosCard";

import "../../styles/dashboardDeportista.css";

function DashboardDeportista() {
  return (
    <DeportistaLayout>

      <div className="dashboard-deportista">

        {/* FILA 1 */}
        <div className="deportista-row-1">

          <RendimientoCard />
          <ActividadCard />
          <LicenciaCard />

        </div>

        {/* FILA 2 */}
        <div className="deportista-row-2">

          <EventosTable />
          <EntrenosCard />

        </div>

      </div>

    </DeportistaLayout>
  );
}

export default DashboardDeportista;
