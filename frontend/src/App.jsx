import { Routes, Route, Navigate } from 'react-router-dom';
import Login from './pages/auth/Login';
import Register from './pages/auth/Register';
import DashboardAdmin from './pages/admin/DashboardAdmin';
import DashboardDeportista from './pages/deportista/DashboardDeportista';
import DashboardEntrenador from "./pages/entrenador/DashboardEntrenador";
import DashboardClub from "./pages/club/DashboardClub";
import DashboardArbitro from './pages/arbitro/DashboardArbitro';
import LicenciasAdmin from "./pages/admin/LicenciasAdmin";
import PagosAdmin from "./pages/admin/PagosAdmin";
import UsuariosAdmin from "./pages/admin/UsuariosAdmin";
import CompeticionesAdmin from "./pages/admin/CompeticionesAdmin";
import InformesAdmin from "./pages/admin/InformesAdmin";
import MonitorizacionAdmin from "./pages/admin/MonitorizacionAdmin";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/login" />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/admin" element={<DashboardAdmin />} />
      <Route path="/deportista" element={<DashboardDeportista />} />
      <Route path="/entrenador" element={<DashboardEntrenador />} />
      <Route path="/club" element={<DashboardClub />} />
      <Route path="/arbitro" element={<DashboardArbitro />} />
      <Route path="/admin/licencias" element={<LicenciasAdmin />} />
      <Route path="/admin/pagos" element={<PagosAdmin />} />
      <Route path="/admin/usuarios" element={<UsuariosAdmin />} />
      <Route path="/admin/competiciones" element={<CompeticionesAdmin/>}/>
      <Route path="/admin/informes" element={<InformesAdmin/>}/>
      <Route path="/admin/monitorizacion" element={<MonitorizacionAdmin/>}/>

      

    </Routes>
  );
}

export default App;

