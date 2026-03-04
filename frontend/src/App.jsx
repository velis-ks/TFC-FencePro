import { Routes, Route, Navigate } from 'react-router-dom';
import Login from './pages/auth/Login';
import Register from './pages/auth/Register';
import DashboardAdmin from './pages/admin/DashboardAdmin';
import DashboardDeportista from './pages/deportista/DashboardDeportista';
import DashboardEntrenador from "./pages/entrenador/DashboardEntrenador";
import DashboardClub from "./pages/club/DashboardClub";

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

      

    </Routes>
  );
}

export default App;

