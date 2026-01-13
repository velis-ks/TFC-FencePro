import { Link } from 'react-router-dom';
import logo from '../assets/FencePro_Logo.png';

function Login() {
  const handleSubmit = (e) => {
    e.preventDefault();
    // aquí irá el backend
  };

  return (
    <div className="auth-container">
      <div className="auth-card">

        <img src={logo} alt="FencePro" className="auth-logo" />


        <h2>Bienvenido</h2>

        <form onSubmit={handleSubmit}>
          <input
            type="email"
            placeholder="Email"
            required
          />

          <input
            type="password"
            placeholder="Contraseña"
            required
          />

          <button type="submit">Iniciar sesión</button>
        </form>

        <div className="auth-link">
          <Link to="/register">Crear cuenta</Link>
        </div>
      </div>
    </div>
  );
}

export default Login;