import { useState, useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import logo from '../../assets/FencePro_Logo.png';
import '../../styles/Login.css';

function Login() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({ email: '', password: '' });

  // LIMPIEZA AUTOMÁTICA: Al entrar al Login, nos cargamos cualquier rol previo
  useEffect(() => {
    localStorage.removeItem('userRol');
  }, []);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('/api/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        const data = await response.json();

        // GUARDAMOS EL ROL PARA QUE EL REGISTER SEPA QUIÉN ERES
        if (data.rol) {
          localStorage.setItem('userRol', data.rol.toUpperCase());
        }

        if (data.rol?.toUpperCase() === 'ADMIN') {
          navigate('/admin');
        } else {
          navigate('/deportista');
        }
      } else {
        alert('Credenciales incorrectas');
      }
    } catch  {
      alert('Error de conexión con el servidor');
    }
  };

  return (
      <div className="auth-container">
        <div className="auth-card">
          <img src={String(logo)} alt="FencePro" className="auth-logo" />
          <h2>Iniciar Sesión</h2>
          <form onSubmit={handleSubmit}>
            <input type="email" name="email" placeholder="Email" onChange={handleChange} required />
            <input type="password" name="password" placeholder="Contraseña" onChange={handleChange} required />
            <button type="submit">Entrar</button>
          </form>
          <div className="auth-link">
            <Link to="/register">¿No tienes cuenta? Regístrate</Link>
          </div>
        </div>
      </div>
  );
}

export default Login;