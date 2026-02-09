import { Routes, Route, Navigate } from 'react-router-dom';
import Login from './pages/auth/Login';
import Register from './pages/auth/Register';
import DashboardAdmin from './pages/admin/DashboardAdmin';
import DashboardDeportista from './pages/deportista/DashboardDeportista';


function App() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/login" />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/admin" element={<DashboardAdmin />} />
      <Route path="/deportista" element={<DashboardDeportista />} />

      

    </Routes>
  );
}

export default App;

