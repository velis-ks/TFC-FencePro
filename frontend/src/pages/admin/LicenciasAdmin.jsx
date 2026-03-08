import DashboardLayout from "../../layouts/DashboardLayout";
import "../../styles/licenciasAdmin.css";
import { Check, X, Pencil } from "lucide-react";

function LicenciasAdmin() {
    return (
        <DashboardLayout>
            <div className="licencias-admin">

                <h2 className="licencias-title">Licencias</h2>

                {/* STATS */}
                <div className="licencias-stats">

                    <div className="lic-stat stat-activa">
                        <p>Activas</p>
                        <h3>2640</h3>
                    </div>

                    <div className="lic-stat stat-caducada">
                        <p>Caducadas</p>
                        <h3>2640</h3>
                    </div>

                    <div className="lic-stat stat-renovacion">
                        <p>Pte. renovación</p>
                        <h3>2640</h3>
                    </div>

                    <div className="lic-stat stat-alerta">
                        <p>Alerta de caducidad</p>
                        <h3>2640</h3>
                    </div>

                </div>

                {/* CONTENIDO */}
                <div className="licencias-grid">

                    {/* TABLA */}
                    <div className="licencias-table">

                        <h4>Gestión de licencias</h4>

                        <table>

                            <thead>
                                <tr>
                                    <th>Nº licencia</th>
                                    <th>Nombre</th>
                                    <th>Categoría</th>
                                    <th>Tipo</th>
                                    <th>Temporada</th>
                                    <th>Caducidad</th>
                                    <th>Estado</th>
                                    <th>Acción</th>
                                </tr>
                            </thead>

                            <tbody>

                                <tr>
                                    <td>0123456789</td>
                                    <td>Carlos Martín</td>
                                    <td>ABS</td>
                                    <td>Competitiva</td>
                                    <td>25-26</td>
                                    <td>26.06.27</td>

                                    <td>
                                        <span className="estado estado-activa">Activa</span>
                                    </td>

                                    <td className="acciones">

                                        <Check size={16} className="icon-ok" />

                                        <X size={16} className="icon-delete" />

                                        <Pencil size={16} className="icon-edit" />

                                    </td>
                                </tr>

                                <tr>
                                    <td>0123456789</td>
                                    <td>Carlos Martín</td>
                                    <td>ABS</td>
                                    <td>Competitiva</td>
                                    <td>25-26</td>
                                    <td>26.06.27</td>

                                    <td>
                                        <span className="estado estado-pendiente">Pendiente</span>
                                    </td>

                                    <td className="acciones">

                                        <Check size={16} className="icon-ok" />

                                        <X size={16} className="icon-delete" />

                                        <Pencil size={16} className="icon-edit" />

                                    </td>
                                </tr>

                                <tr>
                                    <td>0123456789</td>
                                    <td>Carlos Martín</td>
                                    <td>ABS</td>
                                    <td>Competitiva</td>
                                    <td>25-26</td>
                                    <td>26.06.27</td>

                                    <td>
                                        <span className="estado estado-caducada">Caducada</span>
                                    </td>

                                    <td className="acciones">

                                        <Check size={16} className="icon-ok" />

                                        <X size={16} className="icon-delete" />

                                        <Pencil size={16} className="icon-edit" />

                                    </td>
                                </tr>

                            </tbody>

                        </table>

                        <div className="lic-link">→ Ir al calendario</div>

                    </div>

                    {/* PANEL DERECHO */}
                    <div className="licencias-side">

                        <div className="side-card">

                            <h4>Renovaciones</h4>

                            <div className="renovacion-row">
                                <span>Total</span>
                                <span>2000</span>
                            </div>

                            <div className="renovacion-row">
                                <span>Pendientes</span>
                                <span>2000</span>
                            </div>

                            <div className="renovacion-row renovacion-aprobada">
                                <span>Aprobadas</span>
                                <span>2000</span>
                            </div>

                            <div className="renovacion-row renovacion-rechazada">
                                <span>Rechazadas</span>
                                <span>2000</span>
                            </div>

                            <div className="side-link">+ Gestionar renovaciones</div>

                        </div>

                        <div className="side-card">

                            <h4>Alertas de caducidad</h4>

                            <div className="side-row">
                                <span>Próx. caducar</span>
                                <span>2000</span>
                            </div>

                            <div className="side-row">
                                <span>Notificaciones enviadas</span>
                                <span>2000</span>
                            </div>

                            <div className="side-link">+ Revisar alertas</div>

                        </div>

                        <div className="side-card">

                            <h4>Tipos y tarifas</h4>

                            <div className="config-btn">⚙ Configuración de precios</div>
                            <div className="config-btn">⚙ Categorías</div>
                            <div className="config-btn">⚙ Temporadas</div>

                        </div>

                    </div>

                </div>

            </div>
        </DashboardLayout>
    );
}

export default LicenciasAdmin;