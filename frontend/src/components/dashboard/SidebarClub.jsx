import { NavLink } from 'react-router-dom';
import logo from '../../assets/FencePro_Logo.png';

function SidebarClub() {
    return (
        <aside className="sidebar">
            <div className="sidebar-header">
                <img src={logo} alt="FencePro" />

            </div>

            <nav className="sidebar-menu">
                <NavLink to="/club" end>🏠 Home</NavLink>
                <NavLink to="/club/licencias">📄 Licencias</NavLink>
                <NavLink to="/club/licencias-club">🏢 Licencias club</NavLink>
                <NavLink to="/club/pagos">💳 Pagos</NavLink>
                <NavLink to="/club/deportistas">🤺 Deportistas</NavLink>
                <NavLink to="/club/notificaciones">🔔 Notificaciones</NavLink>
            </nav>

            <div className="sidebar-footer">
                ⚙️ Configuración
            </div>
        </aside>
    );
}

export default SidebarClub;