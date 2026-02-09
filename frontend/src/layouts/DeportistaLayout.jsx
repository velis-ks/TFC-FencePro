import SidebarDeportista from '../components/dashboard/SidebarDeportista';
import TopbarDeportista from '../components/dashboard/TopbarDeportista';
import '../styles/dashboardDeportista.css';

function DeportistaLayout({children}){
    return (
        <div className="dashboard">
            <SidebarDeportista />
            <div className='dashboard-main'>
                <TopbarDeportista />
                <div className="dashboard-content">
                    {children}
                </div>
            </div>
        </div>
    );

}

export default DeportistaLayout;