import React, { useState, useEffect } from "react";
import UsuariosTable from "../UsuariosTable";

const DeportistasTab = ({ filtroRol = "TODOS" }) => {
    const [usuarios, setUsuarios] = useState([]);
    const [cargando, setCargando] = useState(true);

    // Definimos los nombres de las columnas que espera recibir la tabla
    const columnas = ["Nombre", "Apellidos", "Email", "Rol", "Club", "Acción"];

    useEffect(() => {
        const fetchUsuarios = async () => {
            try {
                const token = localStorage.getItem('token');
                const response = await fetch('/api/usuarios', {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });

                if (!response.ok) throw new Error('Error al cargar');

                const data = await response.json();

                // Filtramos los datos según la pestaña activa
                const datosFiltrados = filtroRol === "TODOS"
                    ? data
                    : data.filter(u => u.rol === filtroRol);

                // Mapeamos los datos al formato de array de arrays que usa tu tabla
                const formatoTabla = datosFiltrados.map(u => [
                    u.nombre || "-",
                    u.apellidos || "-",
                    u.email || "-",
                    u.rol || "-",
                    u.club || "Independiente",
                    "..." // Columna de Acción
                ]);

                setUsuarios(formatoTabla);
            } catch (error) {
                console.error("Error cargando usuarios:", error);
            } finally {
                setCargando(false);
            }
        };

        fetchUsuarios();
    }, [filtroRol]);

    if (cargando) return <p>Cargando usuarios...</p>;

    return (
        <UsuariosTable
            title={filtroRol === "TODOS" ? "Todos los Usuarios" : `Usuarios ${filtroRol.toLowerCase()}s`}
            columns={columnas}
            data={usuarios}
        />
    );
};

export default DeportistasTab;