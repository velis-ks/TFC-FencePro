import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import logo from '../../assets/FencePro_Logo.png';
import '../../styles/Login.css';

function Register() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    nombre: '', apellidos: '', email: '', password: '', fechaNacimiento: '', rol: '', club: ''
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const dataToSend = { ...formData, rol: formData.rol.toUpperCase() };

    try {
      const response = await fetch('/api/auth/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dataToSend),
      });

      if (response.ok) {
        alert('¡Cuenta creada con éxito!');
        navigate('/');
      } else {
        const errorData = await response.json();
        alert('Error: ' + (errorData.message || 'Datos inválidos'));
      }
    } catch  {
      alert('Error de red');
    }
  };

  return (
      <div className="auth-container">
        <div className="auth-card">
          <img src={String(logo)} alt="FencePro" className="auth-logo" />
          <h2>Registro de Usuario</h2>
          <form onSubmit={handleSubmit}>
            <div className="row-inputs">
              <input type="text" name="nombre" placeholder="Nombre" onChange={handleChange} required />
              <input type="text" name="apellidos" placeholder="Apellidos" onChange={handleChange} required />
            </div>
            <input type="email" name="email" placeholder="Email" onChange={handleChange} required />
            <input type="password" name="password" placeholder="Contraseña" onChange={handleChange} required />
            <div className="row-inputs">
              <input type="date" name="fechaNacimiento" onChange={handleChange} required />

              <select name="rol" onChange={handleChange} required>
                <option value="">Selecciona tu rol</option>
                <option value="deportista">Deportista</option>
                <option value="entrenador">Entrenador</option>
                <option value="club">Club</option>
                <option value="arbitro">Árbitro</option>

                {/* FILTRO: Solo visible si vienes de la sesión de Admin */}
                {localStorage.getItem('userRol') === 'ADMIN' && (
                    <option value="admin">Administrador (ADMIN)</option>
                )}
              </select>
            </div>
            <input type="text" name="club" placeholder="Club (Opcional)" onChange={handleChange} />
            <button type="submit">Crear cuenta</button>
          </form>
          <div className="auth-link">
            <Link to="/">Volver al Login</Link>
          </div>
        </div>
      </div>
  );
}

export default Register;