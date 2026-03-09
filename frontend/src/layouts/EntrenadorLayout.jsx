import SidebarEntrenador from "../components/dashboard/SidebarEntrenador";
import TopbarEntrenador from "../components/dashboard/TopbarEntrenador";
import "../styles/dashboardEntrenador.css";

function EntrenadorLayout({ children }) {
  return (
    <div className="dashboard">
      <SidebarEntrenador />
      <div className="dashboard-main">
        <TopbarEntrenador />
        <div className="dashboard-content">
          {children}
        </div>
      </div>
    </div>
  );
}

export default EntrenadorLayout;