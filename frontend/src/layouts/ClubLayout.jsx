import SidebarClub from "../components/dashboard/SidebarClub";
import TopbarClub from "../components/dashboard/TopbarClub";
import "../styles/dashboardClub.css";

function ClubLayout({ children }) {
  return (
    <div className="dashboard">
      <SidebarClub />
      <div className="dashboard-main">
        <TopbarClub />
        <div className="dashboard-content">
          {children}
        </div>
      </div>
    </div>
  );
}

export default ClubLayout;