import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import logo from '../../assets/FencePro_Logo.png';
import '../../styles/Login.css';

function Register() {
  const navigate = useNavigate();

  // Estado para capturar los datos del formulario
  const [formData, setFormData] = useState({
    nombre: '',
    apellidos: '',
    email: '',
    password: '',
    fechaNacimiento: '',
    rol: '',
    club: ''
  });

  // Función para actualizar el estado cuando escribes
  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Preparamos el objeto para el Backend
    // Importante: El rol debe ir en MAYÚSCULAS para Spring Security
    const dataToSend = {
      ...formData,
      rol: formData.rol.toUpperCase()

    };

    try {
      const response = await fetch('/api/auth/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(dataToSend),
      });

      if (response.ok) {
        alert('¡Cuenta creada con éxito! Ya puedes iniciar sesión.');
        navigate('/'); // Te redirige al login automáticamente
      } else {
        const errorData = await response.json();
        alert('Error en el registro: ' + (errorData.message || 'Datos inválidos'));
      }
    } catch (error) {
      console.error('Error de red:', error);
      alert('No se pudo conectar con el servidor. Revisa que el Backend esté corriendo.');
    }
  };

  return (
    <div className="auth-container">
      <div className="auth-card">
        <img src={logo} alt="FencePro" className="auth-logo" />
        <h2>Bienvenid@</h2>

        <form onSubmit={handleSubmit}>
          <div className="row-inputs">
            <input
              type="text" name="nombre" placeholder="Nombre"
              onChange={handleChange} required
            />
            <input
              type="text" name="apellidos" placeholder="Apellidos"
              onChange={handleChange} required
            />
          </div>

          <input
            type="email" name="email" placeholder="Email"
            onChange={handleChange} required
          />

          <input
            type="password" name="password" placeholder="Contraseña"
            onChange={handleChange} required
          />

          <div className="row-inputs">
            <input
              type="date" name="fechaNacimiento"
              onChange={handleChange} required
            />

            <select name="rol" onChange={handleChange} required>
              <option value="">Selecciona tu rol</option>
              <option value="deportista">Deportista</option>
              <option value="entrenador">Entrenador</option>
              <option value="club">Club</option>
              <option value="arbitro">Árbitro</option>
              <option value="admin">Admin</option>
            </select>
          </div>

          <input
            type="text" name="club" placeholder="Club (Opcional)"
            onChange={handleChange}
          />

          <div className="auth-checkbox">
            <input type="checkbox" required />
            <span>
              He leído y acepto la <a href="#">política de privacidad y cookies</a>
            </span>
          </div>

          <button type="submit">Crear cuenta</button>
        </form>

        <div className="auth-link">
          <Link to="/">Iniciar sesión</Link>
        </div>
      </div>
    </div>
  );
}

export default Register;