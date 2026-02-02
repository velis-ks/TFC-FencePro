import DashboardLayout from '../../layouts/DashboardLayout';

import StatsCards from '../../components/dashboard/StatsCards';
import CompetitionsTable from '../../components/dashboard/CompetitionsTable';
import ActivitiesTable from '../../components/dashboard/ActivitiesTable';

import InscriptionsCard from '../../components/dashboard/InscriptionsCard';

import UsersCard from '../../components/dashboard/UsersCard';
import LicensesCard from '../../components/dashboard/LicensesCard';
import FacturacionCard from '../../components/dashboard/FacturacionCard';

import '../../styles/dashboardAdmin.css';


function DashboardAdmin() {
  return (
    <DashboardLayout>

      <div className="dashboard-admin">

        {/* FILA 1 */}
        <div className="stats-grid">

          <StatsCards />

          

        </div>

        {/* FILA 2 */}
        <div className="dashboard-row-2">

          <CompetitionsTable />
          <LicensesCard />

        </div>

        {/* FILA 3 */}
        <div className="dashboard-row-3">

          <ActivitiesTable />
          <InscriptionsCard />
          <UsersCard />
          <FacturacionCard />

        </div>

      </div>

    </DashboardLayout>
  );
}

export default DashboardAdmin;