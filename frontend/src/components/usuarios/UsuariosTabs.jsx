import React from "react";

function UsuariosTabs({ activeTab, setActiveTab }) {
    return (
        <div className="usuarios-tabs">
            {/* ESTE ES EL BOTÓN QUE FALTA */}
            <button
                className={activeTab === "todos" ? "tab active" : "tab"}
                onClick={() => setActiveTab("todos")}
            >
                Todos
            </button>

            <button
                className={activeTab === "deportistas" ? "tab active" : "tab"}
                onClick={() => setActiveTab("deportistas")}
            >
                Deportistas
            </button>

            <button
                className={activeTab === "entrenadores" ? "tab active" : "tab"}
                onClick={() => setActiveTab("entrenadores")}
            >
                Entrenadores
            </button>

            <button
                className={activeTab === "arbitros" ? "tab active" : "tab"}
                onClick={() => setActiveTab("arbitros")}
            >
                Árbitros
            </button>

            <button
                className={activeTab === "clubes" ? "tab active" : "tab"}
                onClick={() => setActiveTab("clubes")}
            >
                Clubes
            </button>

            <button
                className={activeTab === "roles" ? "tab active" : "tab"}
                onClick={() => setActiveTab("roles")}
            >
                Roles y permisos
            </button>
        </div>
    );
}

export default UsuariosTabs;