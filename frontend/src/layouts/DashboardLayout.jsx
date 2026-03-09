import Sidebar from '../components/dashboard/Sidebar';
import Topbar from '../components/dashboard/Topbar';
import '../styles/dashboardAdmin.css';

function DashboardLayout({children}){
    return (
        <div className="dashboard">
            <Sidebar />
            <div className='dashboard-main'>
                <Topbar />
                <div className="dashboard-content">
                    {children}
                </div>
            </div>
        </div>
    );

}

export default DashboardLayout;