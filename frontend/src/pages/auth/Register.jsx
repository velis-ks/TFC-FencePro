import { Link } from 'react-router-dom';
import logo from '../../assets/FencePro_Logo.png';
import '../../styles/Login.css';

function Register() {
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Registro enviado');
  };

  return (
    <div className="auth-container">
      <div className="auth-card">

        <img src={logo} alt="FencePro" className="auth-logo" />

        <h2>Bienvenid@</h2>

        <form onSubmit={handleSubmit}>
          <div className="row-inputs">
            <input type="text" placeholder="Nombre" required/>
            <input type="text" placeholder="Apellidos" required/>
          </div>

          <input type="email" placeholder="Email" required/>

          <input type="password" placeholder="Contraseña" required/>

          <div className="row-inputs">
            <input type="date" placeholder="Fecha de nacimiento" required/>

            <select required>
              <option value="">Selecciona tu rol</option>
              <option value="deportista">Deportista</option>
              <option value="entrenador">Entrenador</option>
              <option value="club">Club</option>
              <option value="arbitro">Árbitro</option>
              <option value="administrador">Admin</option>
            </select>
          </div>

          <input type="text" placeholder="Club"/>
          
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