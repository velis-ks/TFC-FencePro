import { NavLink} from 'react-router-dom';
import logo from '../../assets/FencePro_Logo.png';

function SidebarDeportista() {
    return (
        <aside className="sidebar">
            <div className="sidebar-header">
                <img src={logo} alt="FencePro" />
                
            </div>

            <nav className="sidebar-menu">

                <NavLink to="/deportista" end>🏠 Home</NavLink>
                <NavLink to="/deportista/licencias">📄 Licencias</NavLink>
                <NavLink to="/deportista/pagos">💳 Pagos</NavLink>
                <NavLink to="/deportista/usuarios">👤 Inscripciones</NavLink>
                <NavLink to="/deportista/competiciones">⚔️ Competiciones</NavLink>
                <NavLink to="/deportista/informes">📊 Resultados</NavLink>
                <NavLink to="/deportista/monitorizacion">📈 Salud</NavLink>
                <NavLink to="/deportista/notificaciones">🔔 Notificaciones</NavLink>

            </nav>

            <div className="sidebar-footer">
                ⚙️ Configuración
            </div>
        </aside>
    );
}

export default SidebarDeportista;