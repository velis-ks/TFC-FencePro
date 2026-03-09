import { NavLink } from 'react-router-dom';
import logo from '../../assets/FencePro_Logo.png';

function SidebarArbitro() {
    return (
        <aside className="sidebar">
            <div className="sidebar-header">
                <img src={logo} alt="FencePro" />

            </div>

            <nav className="sidebar-menu">
                <NavLink to="/arbitro" end>🏠 Home</NavLink>
                <NavLink to="/arbitro/licencias">📄 Licencias</NavLink>
                <NavLink to="/arbitro/pagos">💳 Pagos</NavLink>
                <NavLink to="/arbitro/competiciones">⚔️ Competiciones</NavLink>
                <NavLink to="/arbitro/usuarios">👤 Designaciones</NavLink>
                <NavLink to="/arbitro/informes">📊 Resultados</NavLink>
                <NavLink to="/arbitro/notificaciones">🔔 Notificaciones</NavLink>
            </nav>

            <div className="sidebar-footer">
                ⚙️ Configuración
            </div>
        </aside>
    );
}

export default SidebarArbitro;