import { NavLink} from 'react-router-dom';
import logo from '../../assets/FencePro_Logo.png';

function SidebarEntrenador() {
    return (
        <aside className="sidebar">
            <div className="sidebar-header">
                <img src={logo} alt="FencePro" />
                
            </div>

            <nav className="sidebar-menu">

                <NavLink to="/deportista" end>🏠 Home</NavLink>
                <NavLink to="/deportista/licencias">📄 Licencias</NavLink>
                <NavLink to="/deportista/pagos">💳 Pagos</NavLink>
                <NavLink to="/entrenador/asistencias">👥 Asistencias</NavLink>
                <NavLink to="/entrenador/entrenamientos">🏋️ Entrenamientos</NavLink>
                <NavLink to="/entrenador/calendario">📅 Calendario</NavLink>
                <NavLink to="/entrenador/resultados">🏆 Resultados</NavLink>
                <NavLink to="/entrenador/salud">❤️ Salud</NavLink>
                

            </nav>

            <div className="sidebar-footer">
                ⚙️ Configuración
            </div>
        </aside>
    );
}

export default SidebarEntrenador;