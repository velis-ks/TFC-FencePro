import { useState, useEffect } from "react";
import UsuariosFilters from "../UsuariosFilters";
import UsuariosTable from "../UsuariosTable";
import UsuariosSideStats from "../UsuariosSideStats";

function DeportistasTab() {
    const [deportistas, setDeportistas] = useState([]);
    const [cargando, setCargando] = useState(true);

    const columns = [
        "Nombre",
        "Apellidos",
        "Email",
        "Rol",
        "Club"
    ];

    useEffect(() => {
        const fetchDeportistas = async () => {
            try {
                // Hacemos la llamada al backend.
                // Si tu endpoint para usuarios es distinto, cambialo aquí (ej: /api/users o /api/usuarios/deportistas)
                const response = await fetch('/api/usuarios');

                if (!response.ok) {
                    throw new Error('Error al cargar los datos');
                }

                const data = await response.json();

                // Transformamos el JSON de Java al formato de array que espera tu UsuariosTable
                const formatoTabla = data.map(usuario => [
                    usuario.nombre || "Sin nombre",
                    usuario.apellidos || "-",
                    usuario.email || "-",
                    usuario.rol || "-",
                    usuario.club || "-"
                ]);

                setDeportistas(formatoTabla);
            } catch (error) {
                console.error("Error cargando deportistas:", error);
            } finally {
                setCargando(false);
            }
        };

        fetchDeportistas();
    }, []);

    return (
        <div className="usuarios-grid">
            <div>
                <UsuariosFilters />

                {cargando ? (
                    <p style={{marginTop: "20px"}}>Cargando usuarios desde la base de datos...</p>
                ) : (
                    <UsuariosTable
                        title="Usuarios deportistas"
                        columns={columns}
                        data={deportistas}
                    />
                )}
            </div>

            <UsuariosSideStats />
        </div>
    );
}

export default DeportistasTab;