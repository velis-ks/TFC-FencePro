import { Link, useNavigate } from 'react-router-dom';
import { useState } from 'react';
import logo from '../../assets/FencePro_Logo.png';
import '../../styles/Login.css';

function Login() {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');

    try {
      const response = await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password }),
      });

      if (!response.ok) {
        throw new Error('Usuario y/o contraseña incorrectos');
      }

      const data = await response.json();

      //Guardamos el token y el rol
      localStorage.setItem('token', data.token);
      localStorage.setItem('rol', data.rol);

      console.log('Inicio de sesión correcto: ', data);

      //Redirección según el rol de usuario
      if(data.rol === 'ADMIN') {
        navigate('/admin');
      }else {
        //TODO redigir al resto de roles
        alert("Inicio de sesión correcto como " + data.rol);
      }
    }catch(err) {
      setError(err.message);
    }
  };

  return (
    <div className="auth-container">
      <div className="auth-card">
        <img src={logo} alt="FencePro" className="auth-logo" />
        <h2>Bienvenid@</h2>
        <form onSubmit={handleSubmit}>
          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <input
            type="password"
            placeholder="Contraseña"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          <div className="auth-forgot">
            <span
              className="forgot-link"
              onClick={() => {
              console.log("Recuperar contraseña");
              }}
            >
              ¿Has olvidado la contraseña?
            </span>
          </div>
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