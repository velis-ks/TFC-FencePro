import { useState } from "react";
import { useNavigate } from "react-router-dom"; // Añadido
import { MoreHorizontal, Pencil, FileText, Folder, Ban } from "lucide-react";

function UsuariosTable({ title, columns, data }) {
    const [openMenu, setOpenMenu] = useState(null);
    const navigate = useNavigate(); // Inicializado

    return (
        <div className="usuarios-table">
            <h4>{title}</h4>
            <table>
                <thead>
                <tr>
                    {columns.map(col => (
                        <th key={col}>{col}</th>
                    ))}
                    <th>Acción</th>
                </tr>
                </thead>
                <tbody>
                {data.map((row, i) => (
                    <tr key={i}>
                        {row.map((cell, index) => {
                            if(columns[index] === "Estado"){
                                return (
                                    <td key={index}>
                      <span className={`estado estado-${cell.toLowerCase()}`}>
                        {cell}
                      </span>
                                    </td>
                                )
                            }
                            return <td key={index}>{cell}</td>
                        })}
                        <td className="acciones">
                            <button
                                className="acciones-btn"
                                onClick={() => setOpenMenu(openMenu === i ? null : i)}
                            >
                                <MoreHorizontal size={18} />
                            </button>
                            {openMenu === i && (
                                <div className="acciones-dropdown">
                                    <div className="acciones-item"><Pencil size={14}/>Editar</div>
                                    <div className="acciones-item"><FileText size={14}/>Ver historial</div>
                                    <div className="acciones-item"><Folder size={14}/>Documentación</div>
                                    <div className="acciones-item acciones-bloquear"><Ban size={14}/>Bloquear</div>
                                </div>
                            )}
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>

            {/* AQUÍ ESTÁ EL ARREGLO: de div a button con navigate */}
            <button
                className="table-link"
                onClick={() => navigate("/register")}
                style={{
                    background: 'none',
                    border: 'none',
                    padding: '10px 0',
                    font: 'inherit',
                    color: '#1565c0',
                    cursor: 'pointer',
                    textAlign: 'left'
                }}
            >
                + Crear usuario
            </button>
        </div>
    );
}

export default UsuariosTable;