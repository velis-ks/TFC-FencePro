import Sidebar from "../components/dashboard/SidebarArbitro";
import Topbar from "../components/dashboard/TopbarArbitro";

function ArbitroLayout({ children }) {

  return (
    <div className="dashboard">

      <Sidebar />

      <div className="dashboard-main">
        <Topbar />
        <div className="dashboard-content">
          {children}
        </div>
      </div>

    </div>
  );
}

export default ArbitroLayout;