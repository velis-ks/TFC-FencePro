import userImg from "../../assets/user-placeholder.png";


function LicenciaCard() {
  return (
     <div className="depor-card licencia-card">

      <h3>Mi licencia</h3>

      {/* BLOQUE SUPERIOR */}
      <div className="licencia-header">

        {/* FOTO */}
        <img
          src={userImg}
          alt="Deportista"
          className="licencia-avatar"
        />

        {/* DATOS PRINCIPALES */}
        <div className="licencia-info">

          <p>
            <b>Estado: </b>
            <span className="green">Activa</span>
          </p>

          <p>
            <b>ID:</b> 250938919
          </p>

          <p>
            <b>Tipo:</b> Competitiva
          </p>

          <p>
            <b>Arma:</b> Florete
          </p>

          <p>
            <b>Categoría: </b>
            <span className="badge">ABS 25-26</span>
          </p>

        </div>

      </div>

      {/* BLOQUE INFERIOR */}
      <div className="licencia-extra">

        <p>
          <b>Expiración:</b> 10/12/2026
        </p>

        <p>
          <b>Federación:</b> Madrileña
        </p>

        <p>
          <b>Seguro: </b>
          <span className="red">No</span>
        </p>

      </div>

      {/* ACCIONES */}
      <div className="licencia-actions">

        <span className="link-action">
          → Modificar | Renovar
        </span>

        <span className="link-action">
          PDF · QR
        </span>

      </div>

    </div>
  );
}

export default LicenciaCard; 