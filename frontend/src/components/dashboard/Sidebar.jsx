import { NavLink} from 'react-router-dom';
import logo from '../../assets/FencePro_Logo.png';

function Sidebar() {
    return (
        <aside className="sidebar">
            <div className="sidebar-header">
                <img src={logo} alt="FencePro" />
                
            </div>

            <nav className="sidebar-menu">

                <NavLink to="/admin" end>🏠 Home</NavLink>
                <NavLink to="/admin/licencias">📄 Licencias</NavLink>
                <NavLink to="/admin/pagos">💳 Pagos</NavLink>
                <NavLink to="/admin/usuarios">👤 Usuarios</NavLink>
                <NavLink to="/admin/competiciones">⚔️ Competiciones</NavLink>
                <NavLink to="/admin/informes">📊 Informes</NavLink>
                <NavLink to="/admin/seguridad">🔒 Seguridad</NavLink>
                <NavLink to="/admin/monitorizacion">📈 Monitorización</NavLink>
                <NavLink to="/admin/notificaciones">🔔 Notificaciones</NavLink>

            </nav>

            <div className="sidebar-footer">
                ⚙️ Configuración
            </div>
        </aside>
    );
}

export default Sidebar;